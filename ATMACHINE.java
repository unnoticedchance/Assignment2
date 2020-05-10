import java.util.Scanner;

/**
 A simulation of an automatic teller machine requiring you to login
 with an account number and password (given to you below)
 before giving you a balance which you can deposit into
 or withdraw from.
*/

public class ATMACHINE  {
     static Scanner keyboard = new Scanner(System.in);
     
     static String acctNumber, password, result;
     
     static double oldBalance, newBalance, deposit, withdraw, currentBalance;
     
     static int decide;

public static void main(String[] args) {
    
    for (int run = 0; run < 3; run++) {
        System.out.println("Enter account number");
        acctNumber = keyboard.nextLine();
        System.out.println("Enter account password");
        password = keyboard.nextLine();

        result = checkID(acctNumber, password); //if input does not match what is given below, display error and break
        if (!result.equals("ERROR")) {
            break;
        } 
        
        else if (run == 2) {//you can't try to log in anymore than 3 times
            System.out.println("MAXIMUM TRIES EXCEEDED");
            return;
        }

    }
    menu();
}

public static String checkID(String acctNumber, Object password) {
    String result = "ERROR";
    String a = "44567-5 mypassword 520.36";
    String b = "1234567-6 anotherpassword 48.20";
    String c = "4321-0 betterpassword 96.74";

    if (acctNumber.equals("12345") && password.equals("12345")) {//Input these or any of the following to login the different accounts
        result = "520.36";
    } else if (acctNumber.equals("1234567-6") && password.equals("anotherpassword")) {
        result = "48.20";
    } else if (acctNumber.equals("4321-0") && password.equals("betterpassword")) {
        result = "96.74";
    }
    System.out.println(result);
    return result;
}

public static int menu() {
    System.out.println("Choose one of the following: \n1.Display Balance\n2.Deposit\n3.Withdraw\n4.Log Out\n5.Quit");
    decide = keyboard.nextInt();

    if (decide == 1) {
        displayBalance();
        menu();
        return 1;

    }
    if (decide == 2) {
        deposit();
        menu();
        return 2;

    }
    if (decide == 3) {
        withdraw();
        menu();
        return 3;

    }
    if (decide == 4) {
        System.out.println("You are logged out.");
        menu();
        return 4;

    }
    if (decide == 5) {
        return 5;
        
    }
    if (decide <= 6) {
        System.out.println("System Error");
        menu();
        return 5;
    }
    if (decide >= 1) {
        System.out.println("System Error");
        menu();
        return 6;
    }
    return decide;

}

public static void deposit() //add money to the balance
{
   Scanner input = new Scanner(System.in);
   System.out.println("Enter deposit amount:");
   double amount = input.nextDouble();
   System.out.println("Your deposit amount: " + amount);
   currentBalance += amount;
   System.out.println("Your new balance is: " + currentBalance);
}

public static double displayBalance() { //show current balance
    System.out.println("Total balance is: $" + currentBalance);
    oldBalance = 0.00;
    return 1;
}

public static void withdraw() //take money from the balance
{
   Scanner input = new Scanner(System.in);
   System.out.println("Enter withdrawal amount: ");
   double amount = input.nextDouble();
   System.out.println("Your withdrawal amount: " + amount);
   currentBalance -= amount;
   System.out.println("Your new balance is: " + currentBalance);
}
}
