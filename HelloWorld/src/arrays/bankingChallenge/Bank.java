package arrays.bankingChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Branch> branches = new ArrayList<>();

    public static void main(String[] args) {

        viewOptions();
        boolean flag = true;
        while(flag){
            System.out.println("Enter the option : ");
            int input = scanner.nextInt();
            switch(input){
                case 0:
                    viewOptions();
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    listOfCustomers();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option !!");
                    flag = false;
            }
        }
    }

    private static void viewOptions(){
        System.out.println("0. Available options");
        System.out.println("1. Add branch");
        System.out.println("2. Add Customer");
        System.out.println("3. Add transaction to existing customer");
        System.out.println("4. List of customer");
        System.out.println("5. Quit");
    }

    private static void addBranch(){
        System.out.println("Enter branch name");
        String branchName = scanner.next();
        branches.add(new Branch(branchName));
        System.out.println("Branch added");
    }

    private static boolean addCustomer(){
        System.out.println("Enter branch name");
        String branchName = scanner.next();
        System.out.println("Enter customer name");
        String name = scanner.next();
        System.out.println("Enter transaction");
        Double transaction = scanner.nextDouble();
        for (Branch branch: branches){
            if (branchName.equals(branch.getBranchName())){
                branch.addCustomer(name, transaction);
                return true;
            }
        }
        System.out.println("Branch not found");
        return false;
    }

    private static boolean addTransaction(){
        System.out.println("Enter branch name");
        String branchName = scanner.next();
        System.out.println("Enter customer name");
        String name = scanner.next();
        System.out.println("Enter transaction");
        Double transaction = scanner.nextDouble();
        for (Branch branch: branches) {
            if (branchName.equals(branch.getBranchName())) {
                branch.addTransaction(name, transaction);
                return true;
            }
        }
        System.out.println("Branch not found");
        return false;
    }

    private static boolean listOfCustomers(){
        System.out.println("Enter branch name");
        String branchName = scanner.next();
        System.out.println("Transaction needed");
        boolean transactionNeeded = scanner.nextBoolean();
        for (Branch branch:branches){
            if (branchName.equals(branch.getBranchName())){
                branch.printCustomers(transactionNeeded);
                return true;
            }
        }
        System.out.println("Branch not found");
        return false;
    }
}
