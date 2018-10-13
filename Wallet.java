/*
==============================================================
This class represents a Wallet, which contains Credit Cards
==============================================================

*/

import java.util.ArrayList;

public class Wallet
{

    /*
    The list of credit cards in this wallet
    */
    private ArrayList<CreditCard> creditCardList;
    /*
    The username of the holder of this wallet
    */
    private String holderUser;
    /*
    The unique ID of this wallet
    */
    private String ID;
    /*
    The total amount in this wallet (in Canadian Dollars)
    */
    private double totalAmount;

    /*
    Constructor method for this Wallet
    */
    public Wallet(String holderUser)
    {
        this.holderUser = holderUser;
        this.creditCardList = new ArrayList<CreditCard>();
        this.ID = " " + System.currentTimeMillis() / 1000l;
        this.totalAmount = getTotalAmount();
    }

     /*
     Return the total amount in this wallet by considering the total amount in each
     Credit Card in the list of credit cards
     @return total the total amount in this wallet
     */
    public double getTotalAmount()
    {
        double total = 0;
        for(int i = 0;i<this.creditCardList.size();i++)
            total += creditCardList.get(i).getAmount();
        return total;
    }

    /*
    Return the ID of this wallet
    @return id the ID of this wallet
    */
    public String getID()
    {
        return this.ID;
    }

    /*
    Set the ID of this wallet
    @param id the new ID of this wallet
    */
    public void setID(String id)
    {
        this.ID = id;
    }

    /*
    Return the username of the holder of this wallet
    @param return the holder's username
    */
    public String getHolderUser()
    {
        return this.holderUser;
    }

    /*
    Return the username of the holder of this wallet
    @param holderUser the new username of the holder of this wallet
    */
    public void setHolderUser(String holderUser)
    {
        this.holderUser = holderUser;
    }

    /*
    Sends a packet of money, in the form of an object of type Money
    @param moneyToSend the instance of Money to be sent
    */
    public void send(Money moneyToSend)
    {
        //this is a stub
        ///waiting...
    }

    /*
    Receives a packet of money, in the form of an object of type Money
    */
    public void receive()
    {
        //this is a stub
        ///waiting...
    }

}
