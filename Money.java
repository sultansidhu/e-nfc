/**
 * Class containing transactional information.
 */
public class Money {
    private String senderID;
    private double amount;
    private String currencyType;
    private boolean transactionComplete = false;
    
    public void Money(String senderID, double amount, String currencyType) {
        this.senderID = senderID;
        this.amount = amount;
        this.currencyType = currencyType;
    }
    
    public String getsenderID() {
        return this.senderID;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public String currencyType() {
        return this.currencyType;
    }
    
    public void setsenderID(String newsenderID) {
        this.senderID = newsenderID;
    }

    public void setAmount(double newAmount) {
        this.amount = newAmount;
    }

    public void setTransactionComplete(boolean success) {
        this.transactionComplete = success;
    }

    public boolean transactionSuccess() {
        return this.transactionComplete;
    }
}
