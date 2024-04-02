import java.util.Scanner;

public class UIManager {
    private ClaimProcessManager claimProcessManager;
    private Scanner scanner;

    public UIManager(ClaimProcessManager claimProcessManager) {
        this.claimProcessManager = claimProcessManager;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Show current customers");
        System.out.println("2. Show current insurance cards");
        System.out.println("3. Show current claims");
        System.out.println("4. Test Claim Process Manager functions");
        System.out.println("5. Logout");
    }

    public void handleUserInput() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    showCurrentCustomers();
                    break;
                case 2:
                    showCurrentInsuranceCards();
                    break;
                case 3:
                    showCurrentClaims();
                    break;
                case 4:
                    testClaimProcessManagerFunctions();
                    break;
                case 5:
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void showCurrentCustomers() {
        // Implement logic to display current customers
        System.out.println("Showing current customers...");
    }

    private void showCurrentInsuranceCards() {
        // Implement logic to display current insurance cards
        System.out.println("Showing current insurance cards...");
    }

    private void showCurrentClaims() {
        // Implement logic to display current claims
        System.out.println("Showing current claims...");
    }

    private void testClaimProcessManagerFunctions() {
        // Implement logic to test Claim Process Manager functions
        System.out.println("Testing Claim Process Manager functions...");
    }
}
