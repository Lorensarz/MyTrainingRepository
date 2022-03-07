import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metro {
    List<Line> lines = new ArrayList<>();
    Map<String, ArrayList<String>> stations = new HashMap<>();

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Map<String, ArrayList<String>> getStations() {
        return stations;
    }

    public void setStations(Map<String, ArrayList<String>> stations) {
        this.stations = stations;
    }
}
