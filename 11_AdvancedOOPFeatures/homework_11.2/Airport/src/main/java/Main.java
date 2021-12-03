import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        LocalDateTime currentTime = LocalDateTime.now();

        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter(flight -> formatDate(flight).isAfter(currentTime) && formatDate(flight).isBefore(currentTime.plusHours(2)))
                .collect(Collectors.toList());


        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.

    }

    public static LocalDateTime formatDate(Flight date) {
        return LocalDateTime.ofInstant(date.getDate().toInstant(), ZoneId.systemDefault());
    }


}