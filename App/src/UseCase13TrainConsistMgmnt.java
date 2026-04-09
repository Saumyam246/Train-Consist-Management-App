import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * =========================================================
 * MAIN CLASS - UseCase13TrainConsistMgmnt
 * =========================================================
 *
 * Use Case 13: Find Heaviest Bogie
 */
public class UseCase13TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC13 - Find Heaviest Bogie");
        System.out.println("==================================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72, 45.5));
        bogies.add(new Bogie("AC Chair", 56, 42.0));
        bogies.add(new Bogie("First Class", 24, 48.2));
        bogies.add(new Bogie("Sleeper", 70, 45.5));

        System.out.println("Bogies in Train:");
        bogies.forEach(System.out::println);

        // 🔥 Find heaviest bogie
        Optional<Bogie> heaviest = findHeaviestBogie(bogies);

        System.out.println("\nHeaviest Bogie Found:");

        if (heaviest.isPresent()) {
            Bogie b = heaviest.get();
            System.out.println("Type: " + b.getName() +
                    " | Weight: " + b.getWeight() + " tons");
        } else {
            System.out.println("No bogies found in train.");
        }

        System.out.println("\nUC13 identification completed...");
    }

    // 🔥 Reusable method (for testing)
    public static Optional<Bogie> findHeaviestBogie(List<Bogie> bogies) {

        return bogies.stream()
                .max(Comparator.comparingDouble(Bogie::getWeight));
    }
}