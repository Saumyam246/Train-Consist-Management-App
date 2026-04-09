import java.util.List;

class TrainService {

    public static int calculateTotalSeats(List<Bogie> bogies) {

        return bogies.stream()
                .map(Bogie::getCapacity)   // Extract capacity
                .reduce(0, Integer::sum); // Sum all values
    }
}
