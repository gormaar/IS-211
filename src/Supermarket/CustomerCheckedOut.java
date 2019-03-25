package Supermarket;

import EventSimulator.*;

public class CustomerCheckedOut extends Event {


    public CustomerCheckedOut(Customer customer, int time)  {
       super(time, customer);

    }

    public Event happen()   {

        int time = super.getTime();
        System.out.println("Customer " + customer.getCustNr() + " has checked out with " + customer.getProducts() + " items" + " --- time: " + time + " --- checkoutduration: " + customer.getCheckoutDuration());

        return null;
    }

}
