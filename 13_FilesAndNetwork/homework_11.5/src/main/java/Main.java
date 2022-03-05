import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final String dataFile = "C:/Skillbox/java_basics/13_FilesAndNetwork/files/metro.json";

    public static void main(String[] args) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());
        JSONObject stationsObject = (JSONObject) jsonData.get("stations");

        stationsObject.keySet()
                .stream()
                .sorted(Comparator.comparing(s -> Integer.parseInt(((String) s)
                .replaceAll("[^\\d]", "")))).forEach(lineNumber -> {
                    JSONArray stationArray = (JSONArray) stationsObject.get(lineNumber);
                    int stationsCount = stationArray.toList().size();
                    System.out.println("Номер линии: " + lineNumber + " - количество станций: " + stationsCount);
                });

    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(builder::append);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
