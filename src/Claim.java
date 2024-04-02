import java.util.Date;
import java.util.List;

/**
 * @author <Hoang Duc Phuong - s3885751>
 */

public class Claim {
    private String id;
    private Date claimDate;
    private String insuredPerson;
    private long cardNumber;
    private Date examDate;
    private List<String> documents;
    private double claimAmount;
    private String status;
    private String receiverBank;
    private String receiverBankName;
    private String receiverBankNumber;

    public Claim(String id, Date claimDate, String insuredPerson, long cardNumber, Date examDate,
                 List<String> documents, double claimAmount, String status, String receiverBank,
                 String receiverBankName, String receiverBankNumber) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBank = receiverBank;
        this.receiverBankName = receiverBankName;
        this.receiverBankNumber = receiverBankNumber;
    }

    public String getId() {
        return id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getReceiverBank() {
        return receiverBank;
    }

    public String getReceiverBankName() {
        return receiverBankName;
    }

    public String getReceiverBankNumber() {
        return receiverBankNumber;
    }
}
