import java.util.Date;

/**
 * @author <Hoang Duc Phuong - s3885751>
 */

public class InsuranceCard {
    private long cardNumber;
    private String cardHolder;
    private String policyOwner;
    private Date expirationDate;

    public InsuranceCard(long cardNumber, String cardHolder, String policyOwner, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    // Getters and setters
    // Implement as needed
}
