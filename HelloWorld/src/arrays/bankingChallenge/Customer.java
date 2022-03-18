package arrays.bankingChallenge;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transaction = new ArrayList<>();

    public Customer(String name, Double transaction) {
        this.name = name;
        this.transaction.add(transaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }
}
