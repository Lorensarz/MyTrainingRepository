import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Station {
    private String name;
    private ArrayList<String> branches = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branches.add(branch);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getBranches() {
        return this.branches;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ArrayList<String>> toMap() {
        Map<String, ArrayList<String>> mapObject = new HashMap<>();
        mapObject.put(name, branches);
        return mapObject;
    }

}
