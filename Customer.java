import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name , Double initialAmount) {
        this.name = name;
        transactions = new ArrayList<Double>();
        transactions.add(initialAmount);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount) {
        transactions.add(amount);
    }
    public void showAllTransactions() {
        System.out.println("\tTransactions of " + getName() + " are as follows: ");
        for(int i=0; i<transactions.size(); i++)
            System.out.println("\t\t"+(i+1) + " . \t" + getTransactions().get(i));
    }
}
