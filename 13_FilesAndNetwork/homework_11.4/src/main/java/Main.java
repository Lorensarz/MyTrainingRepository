import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File input = new File("/path/directory");
        try {
            Document doc = Jsoup.parse(input, "UTF-8", "https://lenta.ru");

            Elements links = doc.select("a[href]"); // a with href
            Elements pngs = doc.select("img[src$=.png]");
            // img with src ending .png

            Element masthead = doc.select("div.masthead").first();
            // div with class=masthead

            Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
            System.out.println(links);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
