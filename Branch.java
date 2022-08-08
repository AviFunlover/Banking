import java.util.ArrayList;
import java.util.Scanner;

public class Branch {
    private ArrayList<Customer> branch;
    private Scanner scanner = new Scanner(System.in);

    public Branch() {
        branch = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getBranch() {
        return branch;
    }

    public boolean customerAlreadyExist(Customer customer) {
        return branch.contains(customer);
    }
    public int customerAlreadyExist(String name) {
        for(int i=0; i< branch.size(); i++) {
            if(name.equals(branch.get(i).getName()))
                return i;
        }
        return -1;
    }

    public Boolean addCustomer(Customer customer) {
        if(!customerAlreadyExist(customer)) {
            System.out.println("Customer does not exist in Arraylist.\nAdding " + customer.getName() + " with initial" +
                    "amount of transaction" + customer.getTransactions() +".");
            branch.add(customer);
            return true;
        }
        System.out.println("Customer " + customer.getName() + " already exists in Arraylist.\nCannot add as a new customer.");
        return false;
    }
    public Boolean addTransaction(String name) {
        int index = customerAlreadyExist(name);
        if(index >= 0) {
            System.out.println("Give the amount you want to add to transaction: ");
            branch.get(index).addTransaction(Double.parseDouble(scanner.nextLine()));
            return true;
        }
        System.out.println("Account of name " + name + " does not exist. Cannot add Transaction ");
        return false;
    }
}
