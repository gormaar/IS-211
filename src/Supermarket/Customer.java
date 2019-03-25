package Supermarket;

import java.util.*;
import EventSimulator.*;

public class Customer {


    private int custNr;
    private int products;
    private int shoppingDuration;
    private int checkoutDuration;
    private int enter;
    private boolean checkout1;


    public Customer(int custNr)   {

        this.custNr = custNr;
    }

    public int getCustNr()  {
        return custNr;
    }

    public void setProducts(int products)   {
        this.products = products;
    }

    public int getProducts()    {
        return products;
    }

    public void setShoppingDuration(int shoppingDuration)  {
        this.shoppingDuration = shoppingDuration;
    }

    public int getShoppingDuration()   {
        return shoppingDuration;
    }

    public void setCheckoutDuration(int checkoutDuration)    {
        this.checkoutDuration = checkoutDuration;
    }

    public int getCheckoutDuration()    {
        return checkoutDuration;
    }

    public void setEnter(int enter)  {
        this.enter = enter;
    }

    public int getEnter()   {
        return enter;
    }

    public void setCheckout(boolean checkout1) { this.checkout1 = checkout1; }

    public boolean getCheckout()    {
        return checkout1;
    }

    public String printCheckout()   {
        if (checkout1)  {
            return "Checkout 1";
        }
        else    {
            return "Checkout 2";
        }
    }

    public String toString()    {
        return "" + custNr;
    }
}