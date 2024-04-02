import java.util.List;

/**
 * @author <Hoang Duc Phuong - s3885751>
 */

public interface ClaimProcessManager {
    void add(Claim claim);
    void update(Claim claim);
    void delete(String claimId);
    Claim getOne(String claimId);
    List<Claim> getAll();
    void writeToCsvFile(String filename); // Add this method to the interface
}
