import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        JSONObject jsonMoscowMetro = new JSONObject();

        String strUrl = "https://skillbox-java.github.io/";

        Document document = Jsoup.connect(strUrl).maxBodySize(0).get();

        Elements linesElements = document.select(".js-metro-line");
        Elements stationElements = document.select(".js-depend");

        Iterator<Element> iterateLines = linesElements.iterator();
        Iterator<Element> iterateStations = stationElements.iterator();

        ArrayList<Line> lines = new ArrayList<>();

        Map<String, String> stationsMap = new HashMap<>();
        Map<String, ArrayList<String>> stations = new HashMap<>();
        ArrayList<String> stationsList;



//        while (iterateStations.hasNext()) {
//            Element e = iterateStations.next();
//            stationsList = new ArrayList<>(Arrays.asList(e.text().replaceAll("[\\d.]+?( )", "")));
////            System.out.println(stationsList);
//        }
//        System.out.println(stationsList);


        int counter = 0;
        while (iterateStations.hasNext()) {
            Element e = iterateStations.next();
            counter += 1;
            stationsMap.put(Integer.toString(counter), e.text().replaceAll("[\\d.]", ""));

        }
//        stationsMap.forEach((a,b) -> System.out.println("Key: " + a + "\t" + "Value: " + b));


        int counterLines = 0;
        while (iterateLines.hasNext()) {
            Element e = iterateLines.next();
            counterLines += 1;
            lines.add(new Line(counterLines, e.text()));

        }

        jsonMoscowMetro.put("lines", lines);
        jsonMoscowMetro.put("stations", stationsMap);
        System.out.println(jsonMoscowMetro);


    }

}
