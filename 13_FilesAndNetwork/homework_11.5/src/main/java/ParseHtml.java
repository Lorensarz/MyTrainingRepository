import java.io.File;
import java.io.IOException;
import java.util.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ParseHtml {

    public static void main(String[] args) throws IOException {

        Metro metro = new Metro();

        Document doc = Jsoup.connect("https://skillbox-java.github.io/").maxBodySize(0).get();

        List<Line> lines = new ArrayList<>();

        Elements namesOfLine = doc.getElementsByClass("js-metro-line");
        for (Element e : namesOfLine) {
            lines.add(new Line(e.attr("data-line"), e.text()));
        }
        Map<String, ArrayList<String>> parsedStations = new HashMap<>();
        Elements stationsElements = doc.getElementsByClass("js-metro-stations");
        for (Element el : stationsElements) {
                Station station = new Station(el.attr("data-line"));
                for (String branch : el.text().replaceAll("\\b1\\. ", "").split(" [\\d]{0,2}\\. ")) {
                        station.setBranch(branch);
                }
                parsedStations.put(station.getName(), station.getBranches());

        }

        metro.setStations(parsedStations);
        metro.setLines(lines);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:/Skillbox/java_basics/13_FilesAndNetwork/files/metro.json"), metro);
    }
}
