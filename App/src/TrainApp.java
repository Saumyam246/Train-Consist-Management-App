import java.util.*;

public class TrainApp {

    public static void main(String[] args) {

        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );

        System.out.println("========================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("========================================\n");

        System.out.println("Bogies in Train:");
        bogies.forEach(System.out::println);

        int total = TrainService.calculateTotalSeats(bogies);

        System.out.println("\nTotal Seating Capacity of Train: " + total);
        System.out.println("\nUC10 aggregation completed...");
    }
}