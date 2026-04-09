public class TrainConsistMgmnt {

    // ===============================
    // Custom Exception
    // ===============================
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ===============================
    // Passenger Bogie Model
    // ===============================
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }

            this.type = type;
            this.capacity = capacity;
        }
    }

    // ===============================
    // Main Method
    // ===============================
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("======================================");

        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + bogie1.type + " -> " + bogie1.capacity);

            PassengerBogie bogie2 = new PassengerBogie("AC Chair", 0); // invalid
            System.out.println("Created Bogie: " + bogie2.type + " -> " + bogie2.capacity);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}