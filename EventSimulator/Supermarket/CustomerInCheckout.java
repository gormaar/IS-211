package Supermarket;

import EventSimulator.*;


public class CustomerInCheckout extends Event{



    public CustomerInCheckout(Customer customer, int time) {
        super(customer.getShoppingDuration(), customer);
    }

    public Event happen()   {

        Supermarket supermarket = new Supermarket();
        boolean checkout = customer.getCheckout();
        if (checkout)  {
            supermarket.checkout1(customer);
        }
        else    {

            supermarket.checkout2(customer);
        }

        int time = super.getTime();
        System.out.println("Customer " + customer.getCustNr() + " is checking out in checkout point: " + customer.printCheckout() + " --- time: " + time);


        return new CustomerCheckedOut(customer, time);
    }
}
