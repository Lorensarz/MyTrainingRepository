import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime timeInTwoHours = currentTime.plusHours(2);
        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter(allFlightNow -> allFlightNow.getDate().toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDateTime().isAfter(currentTime) &&
                        allFlightNow.getDate().toInstant().atZone(ZoneId.systemDefault())
                                .toLocalDateTime().isBefore(timeInTwoHours))

                .collect(Collectors.toList());


        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.

    }

}