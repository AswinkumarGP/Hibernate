package arrays.bankingChallenge;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void printCustomers(boolean transactionNeeded){
        for (Customer customer: customers){
            System.out.println(customer.getName());
            if (transactionNeeded){
                for (int i=0; i< customer.getTransaction().size(); i++){
                    System.out.println(customer.getTransaction().get(i).doubleValue());
                }
            }
        }
    }

    public boolean addCustomer(String name, Double transaction){
        Customer customer = new Customer(name, transaction);
        if (!customers.contains(customer)) {
            this.customers.add(customer);
            System.out.println("Customer added");
            return true;
        }
        System.out.println("Customer exists");
        return false;
    }

    public boolean addTransaction(String name, Double transaction){
        for (Customer customer: customers){
            if (name.equals(customer.getName())){
                customer.getTransaction().add(transaction);
                System.out.println("Transaction added");
                return true;
            }
        }
        System.out.println("Customer does not exists ");
        return false;
    }
}
