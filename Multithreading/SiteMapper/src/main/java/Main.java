import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;


public class Main {

    private static final String URL = "https://skillbox.ru/";

    public static void main(String[] args) {
        Set<String> mainPageLinksSet = new TreeSet<>();
        Set<String> followingPages = new TreeSet<>();

        Document doc = null;
        try {
            doc = Jsoup.connect(URL).maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert doc != null;
        Elements elements = doc.select("a[href]");

        for (Element link : elements) {
            String absLink = link.attr("abs:href");
            if (absLink.contains("skillbox.ru")) {
                mainPageLinksSet.add(absLink);
            }

            try {
                for (String followingLinks : mainPageLinksSet) {
                    Document followingDoc = Jsoup.connect(followingLinks).maxBodySize(0).get();
                    Elements followingElement = followingDoc.select("a[href]");

                    for (Element followingElements : followingElement) {
                        String followingAbsLink = followingElements.attr("abs:href");
                        if (followingAbsLink.contains("skillbox.ru")
                                && !mainPageLinksSet.contains(followingAbsLink)) {
                            followingPages.add(followingAbsLink);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            followingPages.forEach(System.out::println);
            System.out.println(followingPages.size());

        }
    }
}
