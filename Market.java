import java.util.ArrayList;

// TODO marketStorage <--- user input this  
// TODO Fruit will be represented by a string 
// TODO Market class that have two kind of methods 
// the farmer method that get a fruit and the customer that take the fruit 

class Market {
    private ArrayList<String> fruits = new ArrayList<>();
    private int fruitsNumber;

    // make a constructor to get set the fruit number on initializing the market
    public Market(int fruitsNumber) {
        if (fruitsNumber > 0) {
            this.fruitsNumber = fruitsNumber;
        } else {
            throw new IllegalArgumentException("This argument is not valid");
        }
    } // end of the constructor

    // check if their is no place or its full //
    private synchronized boolean isFull() {
        return fruits.size() == this.fruitsNumber;
    }

    private synchronized boolean isEmpty() {
        return fruits.isEmpty();
    }

    // consumer and producer methods // the main program //
    public synchronized void farmer(String fruit) {
        if (isFull()) {
            System.out
                    .println("We can not accept more fruites at the moment !!");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interruption");
            }
        }
        fruits.add(fruit);
        System.out.printf("fruit : %s is added !!!%n", fruit);
    }

    public synchronized String consumer() {

        if (isEmpty()) {
            System.out.println("we don't have any goods yet");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("interruption occur !!!");
            }
        }

        String currentFruit = fruits.remove(0);
        notifyAll();
        return currentFruit;
    }

}

