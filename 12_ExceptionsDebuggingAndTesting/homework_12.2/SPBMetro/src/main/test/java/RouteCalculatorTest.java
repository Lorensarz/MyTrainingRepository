import core.Line;
import core.Station;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Программа для составления маршрута и времени поездки на метро")
public class RouteCalculatorTest {

    private static List<Station> route;
    private static List<Station>  routeExpected;
    private static List<Station>  routeExpected1;
    private static List<Station>  routeExpected2;
    private static RouteCalculator calculator;
    private static StationIndex stationIndex;

    @BeforeAll
    static void setUp() {

        routeExpected = new ArrayList<>();
        route = new ArrayList<>();
        routeExpected1 = new ArrayList<>();
        routeExpected2 = new ArrayList<>();

        Line line1 = new Line(1, "L1");
        Line line2 = new Line(2, "L2");
        Line line3 = new Line(3, "L3");

        route.add(new Station("ST1-L1", line1));
        line1.addStation(route.get(0));
        route.add(new Station("ST2-L1", line1));
        line1.addStation(route.get(1));
        route.add(new Station("ST3-L1", line1));
        line1.addStation(route.get(2));
        route.add(new Station("ST1-L2", line2));
        line2.addStation(route.get(3));
        route.add(new Station("ST2L2", line2));
        line2.addStation(route.get(4));
        route.add(new Station("ST3-L2", line2));
        line2.addStation(route.get(5));
        route.add(new Station("ST4-L2", line2));
        line2.addStation(route.get(6));
        route.add(new Station("ST1-L3", line3));
        line3.addStation(route.get(7));
        route.add(new Station("ST2-L3", line3));
        line3.addStation(route.get(8));
        route.add(new Station("ST3-L3", line3));
        line3.addStation(route.get(9));

        stationIndex = new StationIndex();
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        route.forEach(stationIndex::addStation);

        List<Station> connection = new ArrayList<>();
        connection.add(route.get(5));
        connection.add(route.get(1));

        stationIndex.addConnection(connection);

        connection.clear();
        connection.add(route.get(6));
        connection.add(route.get(8));

        stationIndex.addConnection(connection);

        calculator = new RouteCalculator(stationIndex);

        routeExpected.add(route.get(0));
        routeExpected.add(route.get(1));
        routeExpected.add(route.get(2));

        routeExpected1.add(route.get(0));
        routeExpected1.add(route.get(1));
        routeExpected1.add(route.get(5));
        routeExpected1.add(route.get(4));
        routeExpected1.add(route.get(3));

        routeExpected2.add(route.get(0));
        routeExpected2.add(route.get(1));
        routeExpected2.add(route.get(5));
        routeExpected2.add(route.get(6));
        routeExpected2.add(route.get(8));
        routeExpected2.add(route.get(9));
    }

    @Test
    @DisplayName("Корректное получение маршрута на одной линии")
    public void getShortestRouteOnTheLine() {
        List<Station> actual = calculator.getShortestRoute(route.get(0), route.get(2));
        List<Station> expected = routeExpected;
        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Корректное получение маршрута с одной пересадкой")
    public void getShortestRouteWithOneConnection() {
        List<Station> actual = calculator.getShortestRoute(route.get(0), route.get(3));
        List<Station> expected = routeExpected1;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Корректное получение маршрута с двумя пересадками")
    public void getShortestRouteWithTwoConnection() {

        List<Station> actual = calculator.getShortestRoute(route.get(0), route.get(9));
        List<Station> expected = routeExpected2;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Расчет времени маршрута")
    public void calculateDuration() {

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 24.5;
        double delta = 0;
        assertEquals(expected, actual, delta);

    }
}
