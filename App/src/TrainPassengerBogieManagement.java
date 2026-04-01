import java.util.ArrayList;

public class TrainPassengerBogieManagement {

    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("===================================");

        ArrayList<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println();
        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies);

        // Remove "AC Chair"
        passengerBogies.remove("AC Chair");

        System.out.println();
        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + passengerBogies);

        // Check existence of "Sleeper"
        System.out.println();
        System.out.println("Checking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper"));

        // Final consist
        System.out.println();
        System.out.println("Final Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println();
        System.out.println("UC2 operations completed successfully...");
    }
}