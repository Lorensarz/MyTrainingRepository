import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metro {
    List<Line> lines = new ArrayList<>();
    Map<String, List<Station>> stations = new HashMap<>();

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Map<String, List<Station>> getStations() {
        return stations;
    }

    public void setStations(Map<String, List<Station>> stations) {
        this.stations = stations;
    }
}
