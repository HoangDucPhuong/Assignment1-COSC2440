import java.util.List;

public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private List<Claim> claims;

    public ClaimProcessManagerImpl(List<Claim> claims) {
        this.claims = claims;
    }

    @Override
    public void add(Claim claim) {

    }

    @Override
    public void update(Claim claim) {

    }

    @Override
    public void delete(String claimId) {

    }

    @Override
    public Claim getOne(String claimId) {
        return null;
    }

    @Override
    public List<Claim> getAll() {
        return null;
    }

    // Implement methods for ClaimProcessManager interface
    // Add methods to interact with claims list
}
