package Supermarket;

import EventSimulator.*;

public class CustomerLookForCheckout extends Event {


    public CustomerLookForCheckout(Customer customer, int time)    {
        super(customer.getShoppingDuration(), customer);
    }

    public Event happen()   {

        int time = super.getTime();
        System.out.println("Customer " + customer.getCustNr() + " has stopped shopping, and is now looking for a checkout point --- " + "time: " + time);
        return new CustomerSelectCheckout(customer, time);

    }
}
