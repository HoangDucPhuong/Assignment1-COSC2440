/**
 * @author <Hoang Duc Phuong - s3885751>
 */

public class Main {
    public static void main(String[] args) {
        // Create ClaimProcessManager without any initial data
        ClaimProcessManager claimProcessManager = new ClaimProcessManagerImpl();

        // Create UIManager and start UI interaction
        UIManager uiManager = new UIManager(claimProcessManager);
        uiManager.handleUserInput();
    }
}
