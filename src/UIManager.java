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

/**
 * @author <Hoang Duc Phuong - s3885751>
 */

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
        System.out.println("4. add Claims");
        System.out.println("5. update Claims");
        System.out.println("6. delete Claims");
        System.out.println("7. get one Claims");
        System.out.println("8. get all Claims");
        System.out.println("9. Logout");
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
                    addClaim();
                    break;
                case 5:
                    updateClaim();
                    break;
                case 6:
                    deleteClaim();
                    break;
                case 7:
                    getOneClaim();
                    break;
                case 8:
                    getAllClaims();
                    break;
                case 9:
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

    private void addClaim() {
        // Ask the user to input details for a new claim
        System.out.println("Enter details for a new claim:");
        // Implement input for claim attributes
        // For example:
        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Claim Date (yyyy-MM-dd): ");
        Date claimDate = parseDateInput(scanner.nextLine());

        System.out.print("Insured Person: ");
        String insuredPerson = scanner.nextLine();

        System.out.print("Card Number: ");
        long cardNumber = Long.parseLong(scanner.nextLine());

        System.out.print("Exam Date (yyyy-MM-dd): ");
        Date examDate = parseDateInput(scanner.nextLine());

        System.out.print("Documents (comma-separated): ");
        List<String> documents = Arrays.asList(scanner.nextLine().split(","));

        System.out.print("Claim Amount: ");
        double claimAmount = Double.parseDouble(scanner.nextLine());

        System.out.print("Status: ");
        String status = scanner.nextLine();

        System.out.print("Receiver Bank: ");
        String receiverBank = scanner.nextLine();

        System.out.print("Receiver Bank Name: ");
        String receiverBankName = scanner.nextLine();

        System.out.print("Receiver Bank Number: ");
        String receiverBankNumber = scanner.nextLine();

        // Create a new Claim object with the provided details
        // Then, call the add method of ClaimProcessManager
        claimProcessManager.add(new Claim(id,claimDate, insuredPerson, cardNumber, examDate, documents,
                claimAmount, status, receiverBank, receiverBankName, receiverBankNumber));
        System.out.println("New claim added successfully.");
    }

    private Date parseDateInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return sdf.parse(input);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }
    }

    private void updateClaim() {
        // Ask the user to input the ID of the claim to update
        System.out.print("Enter ID of the claim to update: ");
        String claimId = scanner.nextLine();

        // Get the claim from ClaimProcessManager
        Claim claim = claimProcessManager.getOne(claimId);
        if (claim != null) {
            // Ask for new values for claim attributes
            // Update the claim object
            // Then, call the update method of ClaimProcessManager
            claimProcessManager.update(claim);
            System.out.println("Claim updated successfully.");
        } else {
            System.out.println("Claim with ID " + claimId + " not found.");
        }
    }

    private void deleteClaim() {
        // Ask the user to input the ID of the claim to delete
        System.out.print("Enter ID of the claim to delete: ");
        String claimId = scanner.nextLine();

        // Call the delete method of ClaimProcessManager
        claimProcessManager.delete(claimId);
        System.out.println("Claim deleted successfully.");
    }

    private void getOneClaim() {
        // Ask the user to input the ID of the claim to get
        System.out.print("Enter ID of the claim to get: ");
        String claimId = scanner.nextLine();

        // Get the claim from ClaimProcessManager
        Claim claim = claimProcessManager.getOne(claimId);
        if (claim != null) {
            // Display the claim
            System.out.println("Claim found:");
            System.out.println(claim);
        } else {
            System.out.println("Claim with ID " + claimId + " not found.");
        }
    }

    private void getAllClaims() {
        // Get all claims from ClaimProcessManager
        List<Claim> claims = claimProcessManager.getAll();

        // Display all claims
        System.out.println("All claims:");
        for (Claim claim : claims) {
            System.out.println(claim);
        }
    }

}
