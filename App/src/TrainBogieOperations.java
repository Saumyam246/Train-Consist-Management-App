import java.util.*;

public class TrainBogieOperations {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("UC4 - Ordered Bogie Operations");
        System.out.println("================================");
        System.out.println();

        // Create Deque for train bogies
        Deque<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("Pantry Car");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        // Remove first and last bogie
        train.removeFirst(); // Engine removed
        train.removeLast();  // Guard removed

        // Display result
        System.out.println("After Removing First and Last Bogie:");
        System.out.println(train);
        System.out.println();

        System.out.println("UC4 ordered consist operations completed...");
    }
}