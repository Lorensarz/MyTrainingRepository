import core.Line;
import core.Station;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@DisplayName("Программа для составления маршрута и времени поездки на метро")
public class RouteCalculatorTest {

    List<Station> route;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Before
    public void setUp() throws Exception {

        stationIndex = new StationIndex();
        route = new ArrayList<>();
        routeCalculator = new RouteCalculator(stationIndex);

        // Create lines

        Line lineA = new Line(0, "A");
        Line lineB = new Line(1, "B");
        Line lineC = new Line(2, "C");

        // Add lines in stationIndex

        stationIndex.addLine(lineA);
        stationIndex.addLine(lineB);
        stationIndex.addLine(lineC);

        // Create stations

        Station a1 = new Station("A1", lineA);
        Station a2 = new Station("A2", lineA);


        Station b1 = new Station("B1", lineB);
        Station b2 = new Station("B2", lineB);
        Station b3 = new Station("B3", lineB);
        Station b4 = new Station("B4", lineB);

        Station c1 = new Station("C1", lineC);
        Station c2 = new Station("C2", lineC);


        // Add stations in line

        lineA.addStation(a1);
        lineA.addStation(a2);


        lineB.addStation(b1);
        lineB.addStation(b2);
        lineB.addStation(b4);

        lineC.addStation(c1);
        lineC.addStation(c2);


        // Add stations in stationIndex

        stationIndex.addStation(a1);
        stationIndex.addStation(a2);
        stationIndex.addStation(b1);
        stationIndex.addStation(b2);
        stationIndex.addStation(b3);
        stationIndex.addStation(b4);
        stationIndex.addStation(c1);
        stationIndex.addStation(c2);


        // Add stations in route

        route.add(a1);
        route.add(a2);
        route.add(b1);
        route.add(b2);
        route.add(b3);
        route.add(b4);
        route.add(c1);
        route.add(c2);



        // Create List connections

        List<Station> connectionAtoB = new ArrayList<>();
        List<Station> connectionBtoA = new ArrayList<>();
        List<Station> connectionCtoB = new ArrayList<>();
        List<Station> connectionBtoC = new ArrayList<>();


        // Add stations in List connections

        connectionAtoB.add(b2);
        connectionBtoA.add(a2);
        connectionCtoB.add(b4);
        connectionBtoC.add(c2);

        // Add connections

        stationIndex.addConnection(connectionAtoB);
        stationIndex.addConnection(connectionBtoA);
        stationIndex.addConnection(connectionCtoB);
        stationIndex.addConnection(connectionBtoC);

    }

    @Test
    @DisplayName("Корректное получение маршрута на одной линии")
    public void getShortestRouteOnTheLine() {
        List<Station> expected = new ArrayList<>();
        expected.add(route.get(0));
        expected.add(route.get(1));
        assertEquals(expected, routeCalculator.getShortestRoute(route.get(0), route.get(1)));

    }

    @Test
    @DisplayName("Корректное получение маршрута с одной пересадкой")
    public void getShortestRouteWithOneConnection() {


    }

    @Test
    public void calculateDuration() {

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 19.5;
        double delta = 0;
        assertEquals(expected, actual, delta);

    }
}