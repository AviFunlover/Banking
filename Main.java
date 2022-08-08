import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();
        Branch branch = new Branch();
        String name = "no_name";
        Customer customer;

        printInstructions();

        boolean quit = false;

        while(!quit) {
            System.out.println("Choose your choice:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice) {
                case 1:
                    printInstructions();
                    break;
                case 2:
                    System.out.println("Adding branch");
                    bank.addBranch(branch);
                    System.out.println("No. of branches for the bank are " + bank.getBank().size());
                    break;
                case 3:
                    System.out.println("Give name of new customer:");
                    name= scanner.nextLine();
                    System.out.println("Give initial amount to "+ name +" named new customer:");
                    double initialTransaction= Double.parseDouble(scanner.nextLine());
                    customer= new Customer(name,initialTransaction);
                    if(bank.addCustomer(customer))
                        System.out.println("Process Complete.");
                    else
                        System.out.println("Process interrupted.");
                    break;
                case 4:
                    System.out.println("Enter name of existing customer:");
                    name= scanner.nextLine();
                    System.out.println("Enter transaction amount:");
                    double transactionAmount= Double.parseDouble(scanner.nextLine());
                    if(bank.addTransaction(name,transactionAmount))
                        System.out.println("Process of adding transaction completed.");
                    else
                        System.out.println("unable to add transaction.");
                    break;
                case 5:
                    System.out.println("Enter the index of branch you want to see the customers of :" +
                            "The number of branches available are " + bank.getBank().size());
                    int index= Integer.parseInt(scanner.nextLine());
                    if(bank.printListOfBranch(index))
                        System.out.println("Printing list of customers completed.");
                    else
                        System.out.println("Unable to print list of customers.");
                    break;

                case 6:
                    quit = true;
                    break;

                default:
                    System.out.println("Incorrect choice. Choose from the following:");
                    printInstructions();
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("1.\tTo print instructions.");
        System.out.println("2.\tTo add Branch.");
        System.out.println("3.\tTo add Customer.");
        System.out.println("4.\tTo add Transaction to an existing customer.");
        System.out.println("5.\tTo print list of branch and customers.");
        System.out.println("6.\t To quit.");
    }
}