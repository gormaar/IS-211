package Supermarket;

import EventSimulator.*;

public class CustomerSelectCheckout extends Event {


    public CustomerSelectCheckout(Customer customer, int time) {
        super(customer.getShoppingDuration(), customer);
    }

    public Event happen()   {

        Supermarket supermarket = new Supermarket();
        supermarket.chooseCheckout(customer);
        int time = super.getTime();
        System.out.println("Customer " + customer.getCustNr() + " is chosing a checkout point --- time: " + time);

        return new CustomerInCheckout(customer, time);
    }
}
