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
    private static StationIndex stationIndex;
    private static RouteCalculator routeCalculator;

    @BeforeAll
    static void setUp() {

        stationIndex = new StationIndex();
        route = new ArrayList<>();

        Line lineFirst = new Line(1, "First");
        Line lineSecond = new Line(2, "Second");
        Line lineThird = new Line(3, "Third");

        stationIndex.addLine(lineFirst);
        stationIndex.addLine(lineSecond);
        stationIndex.addLine(lineThird);

        Station st1l1 = new Station("L1-ST-1", lineFirst);
        Station st2l1 = new Station("L1-ST-2", lineFirst);
        Station st3l1 = new Station("L1-ST-3", lineFirst);

        lineFirst.addStation(st1l1);
        lineFirst.addStation(st2l1);
        lineFirst.addStation(st3l1);

        Station st1l2 = new Station("L2-ST-1", lineSecond);
        Station st2l2 = new Station("L2-ST-2", lineSecond);
        Station st3l2 = new Station("L2-ST-3", lineSecond);
        Station st4l2 = new Station("L2-ST-4", lineSecond);

        lineSecond.addStation(st1l2);
        lineSecond.addStation(st2l2);
        lineSecond.addStation(st3l2);
        lineSecond.addStation(st4l2);

        Station st1l3 = new Station("L3-ST-1", lineThird);
        Station st2l3 = new Station("L3-ST-2", lineThird);
        Station st3l3 = new Station("L3-ST-3", lineThird);

        stationIndex.addStation(st1l1);
        stationIndex.addStation(st2l1);
        stationIndex.addStation(st3l1);
        stationIndex.addStation(st1l2);
        stationIndex.addStation(st2l2);
        stationIndex.addStation(st3l2);
        stationIndex.addStation(st4l2);
        stationIndex.addStation(st1l3);
        stationIndex.addStation(st2l3);
        stationIndex.addStation(st3l3);

        route.add(st1l1);
        route.add(st2l1);
        route.add(st2l2);
        route.add(st3l2);

        List<Station> connection1to2 = new ArrayList<>();
        connection1to2.add(st2l1);
        connection1to2.add(st2l2);


        List<Station> connection2to3 = new ArrayList<>();
        connection2to3.add(st4l2);
        connection2to3.add(st2l3);

        stationIndex.addConnection(connection1to2);
        stationIndex.addConnection(connection2to3);

        routeCalculator = new RouteCalculator(stationIndex);

    }

    @Test
    @DisplayName("Корректное получение маршрута на одной линии")
    public void getShortestRouteOnTheLine() {
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("L1-ST-1", 1));
        expected.add(stationIndex.getStation("L1-ST-2", 1));
        expected.add(stationIndex.getStation("L1-ST-3", 1));
        assertEquals(expected, routeCalculator.getShortestRoute(
                stationIndex.getStation("L1-ST-1", 1),
                stationIndex.getStation("L1-ST-3", 1)));

    }

    @Test
    @DisplayName("Корректное получение маршрута с одной пересадкой")
    public void getShortestRouteWithOneConnection() {

        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("L1-ST-1", 1));
        expected.add(stationIndex.getStation("L1-ST-2", 1));
        expected.add(stationIndex.getStation("L2-ST-2", 2));
        expected.add(stationIndex.getStation("L2-ST-1", 2));

        assertEquals(expected, routeCalculator.getShortestRoute(
                stationIndex.getStation("L1-ST-1", 1),
                stationIndex.getStation("L2-ST-1", 2)));

    }

    @Test
    @DisplayName("Корректное получение маршрута с двумя пересадками")
    public void getShortestRouteWithTwoConnection() {

        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("L1-ST-1", 1));
        expected.add(stationIndex.getStation("L1-ST-2", 1));
        expected.add(stationIndex.getStation("L2-ST-2", 2));
        expected.add(stationIndex.getStation("L2-ST-3", 2));
        expected.add(stationIndex.getStation("L2-ST-4", 2));
        expected.add(stationIndex.getStation("L3-ST-2", 3));
        expected.add(stationIndex.getStation("L3-ST-3", 3));

        assertEquals(expected, routeCalculator.getShortestRoute(
                stationIndex.getStation("L1-ST-3", 1),
                stationIndex.getStation("L3-ST-3", 3)));

    }

    @Test
    @DisplayName("Расчет времени маршрута")
    public void calculateDuration() {

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        double delta = 0;
        assertEquals(expected, actual, delta);

    }
}