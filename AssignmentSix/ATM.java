package AssignmentSix;

import java.util.*;

/*
I. Design an Automated Teller Machine (ATM).

- Create a User class with attributes name, age, address, phoneNumber and bankAccountNumber.

- Create a Atm class with attributes availableAmountInMachine, transactionFee and userData.

- userData should store USER, PASSWORD, and other account details internally in a dataStructure of your choice.

- The constructor should initialize all the attributes.

- The machine should be able to perform these actions.

- Ask for NEW USER or CURRENT USER as the start.

- Create a NEW USER with a unique bankAccountNumber and password.

- CURRENT USER should be able to login using bankAccountNumber and password.

- CURRENT USER should be able to use FORGOT PASSWORD.

- PASSWORD can be resetted by validating the name, age and phoneNumber of the user.

- After login the user should be able to use availableBalance, withDrawal, deposit, recentTransactions, changePassword and exit.

- recentTransaction should display the last 10 transactions, in a format of transactionName - amount. (transactionName is withDrawal or deposit).

- Add a transactionFee for every transaction done and update the availableAmountInMachine.

- Machine should not allow user to withdrawal more amount than his availableBalance.

- You can add additional functions to make it pretty. UI is not required.
 */
class Transaction {
    public String transactionName;
    public Double amount;
    Transaction(String _transactionName, Double _amount) {
        transactionName = _transactionName;
        amount = _amount;
    }
}

class UserTransaction {
    public Queue<Transaction> transactions = new LinkedList<>();
    public double balance = 0;
    UserTransaction(){

    }
    public void addNewTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transactions.size() > 10)
            transactions.poll();
    }

    public void printTransactions(){
        transactions.forEach(it->
                System.out.println(it.transactionName + "-" + it.amount));
    }
}

public class ATM {

    private double availableAmountInMachine;
    private double transactionFee;
    private Map<String, UserTransaction> userTransaction;
    private Map<String, User> userData;

    private void createUser(String bankAccountNumber, String password) {
        System.out.println("Creating User for " + bankAccountNumber);

        User user = new User();
        user.setBankAccountNumber(bankAccountNumber);
        user.setPassword(password);
        userData.put(bankAccountNumber, user);
        userTransaction.put(bankAccountNumber, new UserTransaction());
    }

    ATM(double _availableAmountInMachine, double _transactionFee) {
        this.availableAmountInMachine = _availableAmountInMachine;
        this.transactionFee = _transactionFee;
        userData = new HashMap();
        userTransaction = new HashMap();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("ATM Menu: Please input 'current' for existing user or 'new' for new user.");
            System.out.println("-------------------------------------------------------------------------");

            String input = sc.nextLine();
            switch (input) {
                case "new":
                    System.out.println("============ sign up ===========");
                    System.out.println("Please input a bank account number");
                    String bankAccountNumber = sc.nextLine();
                    while (accountExists(bankAccountNumber)) {
                        System.out.println("[Account Exists]Please input another bank account number");
                        bankAccountNumber = sc.nextLine();
                    }
                    System.out.println("Please input a password");
                    String password = sc.nextLine();
                    createUser(bankAccountNumber, password);

                    System.out.println("Please complete your account information");
                    completeUserInformation(bankAccountNumber, sc);

                    System.out.println("Create new account success!");
                    System.out.println("Returning to the main menu");
                    break;
                case "current":
                    System.out.println("============ Log in ===========");
                    System.out.println("Please input your bank account number");
                    bankAccountNumber = sc.nextLine();
                    while (!accountExists(bankAccountNumber)) {
                        System.out.println("[Account Not Exists]Please input another bank account number");
                        bankAccountNumber = sc.nextLine();
                    }
                    System.out.println("Please input your password");
                    password = sc.nextLine();
                    while (!verifyPassword(bankAccountNumber, password)) {
                        System.out.println("[Password Invalid] Please input your password");
                        System.out.println("If you forgot your password, please input 'reset'");

                        password = sc.nextLine();

                        if (password.equals("reset")) {
                            System.out.println("Please confirm your information");
                            System.out.println("Please input your name");
                            String name = sc.nextLine();
                            System.out.println("Please input your age");
                            int age = Integer.parseInt(sc.nextLine());
                            System.out.println("Please input your phoneNumber");
                            String phoneNumber = sc.nextLine();
                            if (!verifyInformation(bankAccountNumber, name, age, phoneNumber)) {
                                System.out.println("Information verification failed");
                                continue;
                            }
                            System.out.println("Information verification succeed");
                            System.out.println("Please input your new password");
                            password = sc.nextLine();
                            resetPassword(bankAccountNumber, password);
                        }
                    }
                    System.out.println("============ Log in succeeded ===========");
                    System.out.println("Please input the operation you want");
                    System.out.println("'1' to checking available balance");
                    System.out.println("'2' to withdraw ");
                    System.out.println("'3' to deposit ");
                    System.out.println("'4' to check the last 10 transactions ");
                    System.out.println("'5' to change password ");
                    System.out.println("'6' to exit main menu ");


                    String option = sc.nextLine();
                    while (!option.equals("6")) {
                        switch (option) {
                            case "1":
                                System.out.println("Your available balance is");
                                System.out.println(userTransaction.get(bankAccountNumber).balance);
                                System.out.println("ATM available balance is "+ availableAmountInMachine);
                                System.out.println("return to option menu");
                                option = sc.nextLine();
                                break;
                            case "2":
                                System.out.println("Please Input amount of money you want to withdraw");
                                double withdraw = Double.valueOf(sc.nextLine()) + transactionFee;
                                double userBalance = userTransaction.get(bankAccountNumber).balance;
                                if (userBalance < withdraw) {
                                    System.out.println("Sorry you don't have enough money in your account");
                                    System.out.println("return to option menu");
                                    option = sc.nextLine();
                                    break;
                                }

                                if (availableAmountInMachine < withdraw) {
                                    System.out.println("Sorry this ATM doesn't have enough money");
                                    System.out.println("return to option menu");
                                    option = sc.nextLine();
                                    break;
                                }

                                availableAmountInMachine -= withdraw;
                                userTransaction.get(bankAccountNumber).balance -= withdraw;

                                userTransaction.get(bankAccountNumber).addNewTransaction(
                                        new Transaction("withdraw", withdraw)
                                );
                                System.out.println("Withdraw successfully: withdraw " + withdraw + " from account " + bankAccountNumber);

                                System.out.println("return to option menu");
                                option = sc.nextLine();
                                break;
                            case "3":
                                System.out.println("Please Input amount of money you want to deposit");
                                double deposit = Double.valueOf(sc.nextLine()) - transactionFee;
                                userTransaction.get(bankAccountNumber).balance += deposit;
                                availableAmountInMachine += deposit;
                                userTransaction.get(bankAccountNumber).addNewTransaction(
                                        new Transaction("deposit", deposit)
                                );
                                System.out.println("Deposit successfully: deposit " + deposit + " into account " + bankAccountNumber);

                                System.out.println("return to option menu");
                                option = sc.nextLine();

                                break;
                            case "4":
                                System.out.println("Printing your last 10 transactions");
                                userTransaction.get(bankAccountNumber).printTransactions();
                                System.out.println("return to option menu");
                                option = sc.nextLine();
                                break;
                            case "5":
                                System.out.println("Change password for account "+ bankAccountNumber);
                                System.out.println("Please confirm your information");
                                while (true) {
                                    System.out.println("Please input your name");
                                    String name = sc.nextLine();
                                    System.out.println("Please input your age");
                                    int age = Integer.parseInt(sc.nextLine());
                                    System.out.println("Please input your phoneNumber");
                                    String phoneNumber = sc.nextLine();
                                    if (verifyInformation(bankAccountNumber, name, age, phoneNumber)) {
                                        System.out.println("Information verification succeed");
                                        System.out.println("Please input your new password");
                                        password = sc.nextLine();
                                        resetPassword(bankAccountNumber, password);
                                        break;
                                    }
                                    System.out.println("Information verification failed");
                                }
                                System.out.println("return to option menu");

                                option = sc.nextLine();
                                break;
                        }
                    }


                default:
                    System.out.println("Unsupported Option: Returning to the main menu");

            }
        }
    }

    private Boolean accountExists(String bankAccountNumber) {
        return userData.containsKey(bankAccountNumber);
    }

    private void completeUserInformation(String bankAccountNumber, Scanner sc) {
        User user = userData.get(bankAccountNumber);

        System.out.println("Please input your name");
        String name = sc.nextLine();
        System.out.println("Please input your age");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Please input your address");
        String address = sc.nextLine();
        System.out.println("Please input your phoneNumber");
        String phoneNumber = sc.nextLine();

        user.setName(name);
        user.setAge(age);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        System.out.println("Update User information for account " + bankAccountNumber + " success");
    }


    private void resetPassword(String bankAccountNumber, String password) {
        User user = userData.get(bankAccountNumber);
        user.setPassword(password);
        System.out.println("Account " + bankAccountNumber + " Reset password success!");
    }

    private boolean verifyPassword(String bankAccountNumber, String password) {
        User user = userData.get(bankAccountNumber);
        return user.getPassword().equals(password);
    }

    private boolean verifyInformation(String bankAccountNumber, String name, int age, String phoneNumber) {
        User user = userData.get(bankAccountNumber);
        return user.getName().equals(name) && user.getAge() == age && user.getPhoneNumber().equals(phoneNumber);
    }
}
