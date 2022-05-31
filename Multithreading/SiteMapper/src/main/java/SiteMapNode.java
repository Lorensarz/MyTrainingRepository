import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveTask;

import static java.lang.Thread.sleep;

public class SiteMapNode extends RecursiveTask<Set<String>> {

    private final String url;


    public SiteMapNode(String url) {
        this.url = url;
    }

    @Override
    protected Set<String> compute() {

        Set<String> allLinks = parseUrl(url);
        List<SiteMapNode> tasks = new ArrayList<>();
        for (String links : allLinks) {
            parseUrl(links);
            SiteMapNode task = new SiteMapNode(url);
            task.fork();
            tasks.add(task);
        }
        addResultsFromTasks(allLinks, tasks);
        return allLinks;
    }

    private void addResultsFromTasks(Set<String> links, List<SiteMapNode> tasks)
    {
        for (SiteMapNode item : tasks)
        {
            links.addAll(item.join());
        }
    }

    private Set<String> parseUrl(String url) {
        Set<String> links = new CopyOnWriteArraySet<>();

        try {
            Document doc = Jsoup.connect(url).timeout(100000).get();
            Elements elements = doc.select("a[href]");

            for (Element link : elements) {
                String absLink = link.attr("abs:href");
                if (isCorrected(absLink)) {
                    links.add(absLink);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return links;
    }

    private boolean isCorrected(String absLink) {
        return (!absLink.isEmpty() && absLink.startsWith(url) && !absLink.contains("#")
                && !absLink.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|pdf))$)"));
    }
}
