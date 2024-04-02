import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private Map<String, Claim> claimMap;

    // Default constructor
    public ClaimProcessManagerImpl() {
        this.claimMap = new HashMap<>();
    }

    // Constructor that accepts a list of claims
    public ClaimProcessManagerImpl(List<Claim> claims) {
        this.claimMap = new HashMap<>();
        for (Claim claim : claims) {
            add(claim);
        }
    }

    @Override
    public void add(Claim claim) {
        claimMap.put(claim.getId(), claim);
        writeToCsvFile("claims.csv"); // Update CSV after adding
    }

    @Override
    public void update(Claim claim) {
        if (claimMap.containsKey(claim.getId())) {
            claimMap.put(claim.getId(), claim);
            writeToCsvFile("claims.csv"); // Update CSV after updating
        } else {
            System.out.println("Claim with ID " + claim.getId() + " does not exist.");
        }
    }

    @Override
    public void delete(String claimId) {
        if (claimMap.containsKey(claimId)) {
            claimMap.remove(claimId);
            writeToCsvFile("claims.csv"); // Update CSV after deleting
        } else {
            System.out.println("Claim with ID " + claimId + " does not exist.");
        }
    }

    @Override
    public Claim getOne(String claimId) {
        return claimMap.getOrDefault(claimId, null);
    }

    @Override
    public List<Claim> getAll() {
        return new ArrayList<>(claimMap.values());
    }

    @Override
    public void writeToCsvFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write header
            writer.println("id,claimDate,insuredPerson,cardNumber,examDate,documents,claimAmount,status,receiverBank,receiverBankName,receiverBankNumber");

            // Write claims data
            for (Claim claim : claimMap.values()) {
                writer.println(claimToCsvString(claim));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String claimToCsvString(Claim claim) {
        // Convert a Claim object to a CSV string
        // Format each field appropriately
        // Example:
        return String.format("%s,%s,%s,%d,%s,%s,%.2f,%s,%s,%s,%s",
                claim.getId(), claim.getClaimDate(), claim.getInsuredPerson(), claim.getCardNumber(),
                claim.getExamDate(), String.join(",", claim.getDocuments()), claim.getClaimAmount(), claim.getStatus(),
                claim.getReceiverBank(), claim.getReceiverBankName(), claim.getReceiverBankNumber());
    }
}
