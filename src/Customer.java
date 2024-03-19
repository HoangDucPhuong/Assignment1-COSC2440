import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String fullName;
    private String insuranceCardId;
    private List<String> claims;

    public Customer(String id, String fullName, String insuranceCardId, List<String> claims) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCardId = insuranceCardId;
        this.claims = claims;
    }

    // Getters and setters
    // Implement as needed
}
