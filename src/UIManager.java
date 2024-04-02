import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<Customer> customers = loadCustomers("C:\\Users\\Admin\\IdeaProjects\\Insurance claims management system\\src\\customers.csv");
        System.out.println("Showing current customers...");
    }

    private void showCurrentInsuranceCards() {
        List<InsuranceCard> insuranceCards = loadInsuranceCards("C:\\Users\\Admin\\IdeaProjects\\Insurance claims management system\\src\\insurance_cards.csv");
        System.out.println("Showing current insurance cards...");
    }

    private void showCurrentClaims() {
        List<Claim> claims = loadClaims("C:\\Users\\Admin\\IdeaProjects\\Insurance claims management system\\src\\claims.csv");
        System.out.println("Showing current claims...");
    }

    private void testClaimProcessManagerFunctions() {
        // Implement logic to test Claim Process Manager functions
        System.out.println("Testing Claim Process Manager functions...");
    }

    private static List<Customer> loadCustomers(String filename) {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("" + line); // Print out the line for debugging
                String[] data = line.split(",");
                String id = data[0];
                String fullName = data[1];
                String insuranceCardId = data[2];
                List<String> claims = new ArrayList<>();
                for (int i = 3; i < data.length; i++) {
                    claims.add(data[i]);
                }
                customers.add(new Customer(id, fullName, insuranceCardId, claims));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
    private static List<InsuranceCard> loadInsuranceCards(String filename) {
        List<InsuranceCard> insuranceCards = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Skip the header line
            br.readLine();
            System.out.println();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("" + line); // Print out the line for debugging
                String[] data = line.split(",");
                long cardNumber = Long.parseLong(data[0]);
                String cardHolder = data[1];
                String policyOwner = data[2];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date expirationDate = sdf.parse(data[3]);
                insuranceCards.add(new InsuranceCard(cardNumber, cardHolder, policyOwner, expirationDate));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return insuranceCards;
    }

    private static List<Claim> loadClaims(String filename) {
        List<Claim> claims = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Skip the header line
            br.readLine();
            System.out.println();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("" + line); // Print out the line for debugging
                String[] data = line.split(",");
                String id = data[0];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date claimDate = sdf.parse(data[1]);
                String insuredPerson = data[2];
                long cardNumber = Long.parseLong(data[3]);
                Date examDate = sdf.parse(data[4]);
                // Parse documents list
                List<String> documents = Arrays.asList(data[5].split(","));
                // Parse claim amount
                double claimAmount = Double.parseDouble(data[6]);
                String status = data[7];
                String receiverBank = data[8];
                String receiverBankName = data[9];
                String receiverBankNumber = data[10];
                claims.add(new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documents,
                        claimAmount, status, receiverBank, receiverBankName, receiverBankNumber));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return claims;
    }
}
