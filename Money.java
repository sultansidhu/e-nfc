/**
 * Class containing transactional information.
 */
public class Money {
    private String sender;
    private double amount;
    private String currencyType;
    
    public void Money(String sender, double amount, String currencyType) {
        this.sender = sender;
        this.amount = amount;
        this.currencyType = currencyType;
    }
    
    public String getSender() {
        return this.sender;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public String currencyType() {
        return this.currencyType;
    }
    
    public void setSender(String newSender) {
        this.sender = newSender;
        
    }

    public void setAmount(double newAmount) {
        this.amount = newAmount;
    }
}
