import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

class Account {
    String name;
    double balance;

    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    double getBalance() {
        return balance;
    }
}

//Had to study a whole day just to understand hashmap API Lmao
public class BankingSystem {
    private static HashMap<String, Account> accounts = new HashMap<>();
    private static final String FILE_PATH = "accounts.txt";

    public static void main(String[] args) throws IOException {
        loadAccounts();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    saveAccounts();
                    exit = true;
                    break;
            }
        }
        scanner.close();
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Initial deposit: ");
        double initialDeposit = scanner.nextDouble();
        accounts.put(name, new Account(name, initialDeposit));
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();

        if (accounts.containsKey(name)) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            accounts.get(name).deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();

        if (accounts.containsKey(name)) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            accounts.get(name).withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();

        if (accounts.containsKey(name)) {
            System.out.println("Balance: " + accounts.get(name).getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    //Had to search this part up
    private static void loadAccounts() throws IOException {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                accounts.put(data[0], new Account(data[0], Double.parseDouble(data[1])));
            }
            reader.close();
        }
    }

    //used for-each for loop here for a more clean code cause I'm currently reading a book about it
    private static void saveAccounts() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
        for (String name : accounts.keySet()) {
            writer.write(name + "," + accounts.get(name).getBalance() + "\n");
        }
        writer.close();
    }
}
