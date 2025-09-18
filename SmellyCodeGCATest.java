
public class GodClass {

    // Global variables
    public static int globalCounter = 0;
    public static String globalStatus = "INIT";

    // Method with too many parameters
    public void processData(String name, int age, String address, String phone, String email, String occupation,
                            String nationality, boolean isEmployed, double salary, String department) {
        System.out.println("Processing data for: " + name);
        // Poor exception handling
        try {
            int result = age / 0;
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    // Very long method (>100 lines)
    public void longMethod() {
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
        for (int i = 0; i < 10; i++) {
            globalCounter++;
            System.out.println("Step " + i);
        }
    }

    // Duplicate code
    public void duplicateLogic() {
        System.out.println("Starting duplicate logic");
        for (int i = 0; i < 5; i++) {
            System.out.println("Duplicate block A: " + i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Duplicate block A: " + i);
        }
    }

    // Another unrelated responsibility
    public void unrelatedResponsibility() {
        System.out.println("Sending email notification...");
        System.out.println("Logging activity...");
        System.out.println("Updating database...");
    }
}
