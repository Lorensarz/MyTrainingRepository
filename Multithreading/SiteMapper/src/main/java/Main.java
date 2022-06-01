import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String SITE_URL = "https://skillbox.ru/";
    private static final String SITEMAP_DOC =
            "C:\\Skillbox\\java_basics\\Multithreading\\SiteMapper\\src\\main\\resources\\sitemap.txt";

    public static void main(String[] args) {
        SiteMapNode rootUrl = new SiteMapNode(SITE_URL);
        new ForkJoinPool().invoke(new SiteMapNodeRecursiveTask(rootUrl, rootUrl));
        writeSitemapUrl(rootUrl, SITEMAP_DOC);
    }

    public static void writeSitemapUrl(SiteMapNode node, String sitemapDoc) {
        int depth = node.getDepth();
        String tabs = String.join("", Collections.nCopies(depth, "\t"));
        appendStringInFile(sitemapDoc, tabs + node.getUrl() + "\n");
        node.getSubLinks().forEach(link -> writeSitemapUrl(link, sitemapDoc));
    }

    private static void appendStringInFile(String fileName, String data) {
        try (OutputStream outputStream = new FileOutputStream(fileName, true)) {
            outputStream.write(data.getBytes(), 0, data.length());

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}