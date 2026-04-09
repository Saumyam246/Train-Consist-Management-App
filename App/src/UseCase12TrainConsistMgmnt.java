import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

/**
 * =========================================================
 * MAIN CLASS - UseCase12TrainConsistMgmnt
 * =========================================================
 *
 * Use Case 12: Calculate Total Train Weight
 */
public class UseCase12TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC12 - Calculate Total Train Weight");
        System.out.println("==================================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72, 45.5));
        bogies.add(new Bogie("AC Chair", 56, 42.0));
        bogies.add(new Bogie("First Class", 24, 48.2));
        bogies.add(new Bogie("Sleeper", 70, 45.5));

        System.out.println("Bogies in Train:");
        bogies.forEach(System.out::println);

        // 🔥 Pass logic as lambda
        double totalWeight = calculateTotal(bogies, b -> b.getWeight());

        System.out.println("\nTotal Train Weight: " + totalWeight + " tons");

        System.out.println("\nUC12 calculation completed...");
    }

    // 🔥 Generic reusable method
    public static double calculateTotal(List<Bogie> list,
                                        ToDoubleFunction<Bogie> mapper) {

        return list.stream()
                .mapToDouble(mapper)
                .sum();
    }
}