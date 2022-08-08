import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<Branch> bank;
    private Scanner scanner = new Scanner( System.in);

    public Bank() {
        bank = new ArrayList<Branch>();
    }

    public ArrayList<Branch> getBank() {
        return bank;
    }

    public void addBranch(Branch branch) {
        bank.add(branch);
    }
    public boolean addCustomer(Customer customer) {
        System.out.println("Which branch do you want to add customer to. You have " + bank.size() + " branches available.");
        int index = Integer.parseInt(scanner.nextLine()) -1;
        if(bank.get(index).addCustomer(customer)) {
            System.out.println("Successfully added a new customer.");
            return true;
        }
        else {
            System.out.println("Unable to add new customer.");
            return false;
        }
    }
    public boolean addTransaction(String name, double amount) {
        for(int i=0 ; i<bank.size(); i++) {
            int index = bank.get(i).customerAlreadyExist(name);
            if(index >= 0) {
                bank.get(i).getBranch().get(index).addTransaction(amount);
                System.out.println(name + " account, transaction added of " + amount);
                return true;
            }
        }
        System.out.println("unable to add transaction.");
        return false;
    }
    public boolean printListOfBranch(int index) {
        if(index > bank.size() || index < 0) {
            System.out.println("Out of bound bank indicated.");
            return false;
        }
        System.out.println("The list of Customer in Branch " + index + " are:");
        index--;
        System.out.println("Want to see the transactions too?");
        boolean showTransaction = Boolean.parseBoolean(scanner.nextLine());
        for(int i=0; i<bank.get(index).getBranch().size() ; i++) {
            System.out.println((i+1) +". " + bank.get(index).getBranch().get(i).getName());
            if(showTransaction)
                bank.get(index).getBranch().get(i).showAllTransactions();
        }
        return true;
    }
}
