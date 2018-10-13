/*
================================================
This class represents a single Credit Card
================================================
*/
public class CreditCard
{
    /*
    The credit card number of this card
    */
    private int cardNumber;
    /*
    The bank this credit card is associated with
    */
    private String bank;
    /*
    The amount of money in this bank account
    */
    private double amount;
    /*
    The type of money (currency/bitcoin)
    */
    private String type;

    /*
    The constructor method for the CreditCard class
    */
    public CreditCard(int cardNumber, String bank, int amount, String type)
    {
        this.cardNumber = cardNumber;
        this.bank = bank;
        this.amount = amount;
        this.type = type;
    }

    /*
    Return the amount of money in this Credit Card
    */
    public double getAmount()
    {
        return this.amount;
    }




}
