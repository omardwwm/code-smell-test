
public class SmellyCode {

    public static void main(String[] args) {
        SmellyCode sc = new SmellyCode();
        sc.doEverything();
    }

    public void doEverything() {
        // Long method with too many responsibilities
        int a = 5;
        int b = 10;
        int c = a + b;
        System.out.println("Sum: " + c);

        try {
            int[] arr = new int[5];
            System.out.println(arr[10]); // Will throw exception
        } catch (Exception e) {
            // Bad exception handling
            System.out.println("Something went wrong.");
        }

        String unusedVariable = "I am never used";

        for (int i = 0; i < 3; i++) {
            System.out.println("Hello");
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Hello");
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Hello");
        }

        // Deeply nested code
        if (a > 0) {
            if (b > 0) {
                if (c > 0) {
                    System.out.println("All positive");
                }
            }
        }
    }
}
