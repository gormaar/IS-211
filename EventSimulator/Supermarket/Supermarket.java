package Supermarket;

import java.util.*;
import EventSimulator.*;

public class Supermarket {

    private Queue<Customer> queue1;
    private Queue<Customer> queue2;
    private List<Queue> queueList;
    private List<Event> initialEvents;
    private List<Customer> customerList;
    private int checkoutTime;

    public Supermarket()    {

        queue2 = new LinkedList<>();
        queue1 = new LinkedList<>();
        initialEvents = new ArrayList<>();
        customerList = new ArrayList<>();
        checkoutTime = 20;
        queueList = new ArrayList<>();
        queueList.add(queue1);
        queueList.add(queue2);
    }

    public void customerSetup() {

        EventSim eventsim = new EventSim();
        Random random = new Random(41);

        for (int i = 0; i < 3; i++)    {
            Customer customer = new Customer(i);

            int time = random.nextInt(1000);        //fix the numbers and time that each event happens
            customer.setShoppingDuration(time);                 //Every event happens at the same time now
            int prod = random.nextInt(50);
            customer.setProducts(prod);
            int stopShopping = random.nextInt(1000);

            int enter = random.nextInt(1000);
            customer.setEnter(enter);

            CustomerEnter customerEnter = new CustomerEnter(customer, time);

            customerList.add(customer);
            initialEvents.add(customerEnter);
            System.out.println("Customer " + customer.getCustNr() + " was just created");
        }

        eventsim.setup(initialEvents);
        eventsim.run();

    }


    public void checkout1(Customer customer)  {

            int products = customer.getProducts() * 2;

            checkoutTime += products;
            customer.setCheckoutDuration(checkoutTime);

            queue1.remove(customer);

        }

        public void checkout2(Customer customer)    {

            int products = customer.getProducts() * 2;

            checkoutTime += products;
            customer.setCheckoutDuration(checkoutTime);

            queue2.remove(customer);

        }

        public void chooseCheckout(Customer customer) {

            if (queue1.size() > queue2.size())    {
                queue2.add(customer);
                customer.setCheckout(false);
            }
            else {
                queue1.add(customer);
                customer.setCheckout(true);
            }
        }


    public void simulate()  {


        customerSetup();
        /*for (int i = 0; i > -1; i++) {

            for (Customer customer : customerList) {

                if (i == customer.getEnter()) {

                    CustomerEnter customerEnter = new CustomerEnter(customer, i);
                    customerEnter.happen();

                }
            }
        }*/
    }
}