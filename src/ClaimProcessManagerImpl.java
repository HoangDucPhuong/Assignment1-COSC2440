import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }

    @Override
    public void update(Claim claim) {
        if (claimMap.containsKey(claim.getId())) {
            claimMap.put(claim.getId(), claim);
        } else {
            System.out.println("Claim with ID " + claim.getId() + " does not exist.");
        }
    }

    @Override
    public void delete(String claimId) {
        if (claimMap.containsKey(claimId)) {
            claimMap.remove(claimId);
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
}
