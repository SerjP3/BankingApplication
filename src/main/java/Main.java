import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount user1 = new BankAccount("Antonia", "I001278DF");
        user1.showMenu();
    }
}
        class BankAccount{
            int balance;
            int previousTransaction;
            String customerName;
            String customerId;

            BankAccount(String cname, String cId){
                customerId = cId;
                customerName = cname;
            }

            void deposit(int amount){
                    balance = balance + amount;
                    previousTransaction = amount;
            }

            void withdraw(int amount){
                if(balance != 0){
                    balance -= amount;
                    previousTransaction = amount;
                }
            }

            void getPreviousTransaction(){
                if(previousTransaction > 0){
                    System.out.println("Deposited: " + previousTransaction);
                }
                else if(previousTransaction < 0){
                    System.out.println("Withdrawn: " + Math.abs(previousTransaction));
                }
                else
                    System.out.println("No transaction occurred.");
            }

            void showMenu(){
                char option = '\0';
                Scanner input = new Scanner(System.in);
                System.out.println("Welcome " + customerName);
                System.out.println("Your id is: " + customerId);
                System.out.println("\n");
                System.out.println("A. Check balance");
                System.out.println("B. Deposit");
                System.out.println("C. Withdraw");
                System.out.println("D. Previous Transaction");
                System.out.println("E. Exit");

                do{
                    System.out.println("====================================================================");
                    System.out.println("Enter an option");
                    System.out.println("====================================================================");
                    option = input.next().charAt(0);
                    System.out.println("\n");

                    switch(option){
                        case 'a':
                            System.out.println("____________________________________________________________");
                            System.out.println("Balance: " + balance);
                            System.out.println("____________________________________________________________");
                            System.out.println("\n");
                            break;
                        case 'b':
                            System.out.println("____________________________________________________________");
                            System.out.println("Enter an amount to deposit:");
                            System.out.println("____________________________________________________________");
                            int amount = input.nextInt();
                            deposit(amount);
                            System.out.println("\n");
                            break;
                        case 'c':
                            System.out.println("____________________________________________________________");
                            System.out.println("Enter an amount to withdraw:");
                            System.out.println("____________________________________________________________");
                            int amount2 = input.nextInt();
                            withdraw(amount2);
                            System.out.println("\n");
                            break;
                        case 'd':
                            System.out.println("____________________________________________________________");
                            getPreviousTransaction();
                            System.out.println("____________________________________________________________");
                            System.out.println("\n");
                            break;
                        case 'e':
                            System.out.println("************************************************************");
                            break;
                        default:
                            System.out.println("Invalid option!" + "\n" + "Please try again");
                            break;
                    }
                }
                while(option != 'e');
                System.out.println("Thank you!");
            }
        }

