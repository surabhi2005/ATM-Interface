import java.util.*;
class bankaccount
{
    String name;
    String accountno;
    int balance;
    bankaccount(String name,String accountno,int balance)
    {
        this.name=name;
        this.accountno=accountno;
        this.balance=balance;
    } 
    public void display()
    {
        System.out.println("ACCOUNT DETAILS");
        System.out.println("Name: "+name);
        System.out.println("Account No: "+accountno);
        System.out.println("Balance: "+balance);
    }
}
public class ATMinterface  extends bankaccount{
    ATMinterface(String name,String accountno,int balance)
    {
        super(name,accountno,balance);
    }
    public void details()
    {
        super.display();
    }
    public void deposit(int amount)
    {
        if(amount>0)
        {
        balance+=amount;
        System.out.println("Successfully deposited");
        }
        else{
            System.out.println("Invalid deposit amount. Sorry! Transaction failed."); 
        }
    }
    public int checkbalance()
    {
        return balance;
    }
    public void withdraw(int amount)
    {
        int g=checkbalance();
        if(amount>0 && g>=amount)
        {
            balance-=amount;
            System.out.println("Successfully withdrawn");
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance. Sorry! Transaction failed.");
        } else {
            System.out.println("Invalid withdrawal amount. Sorry! Transaction failed.");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to ATM");
        System.out.print("Enter the account name: ");
        String name=sc.nextLine();
        System.out.print("Enter the account no: ");
        String accountno=sc.nextLine();
        System.out.print("Enter initial balance: ");
        int initialbalance=sc.nextInt();
        ATMinterface at=new ATMinterface(name, accountno, initialbalance);
        char g='y';
        while(g=='y'){
        System.out.println("ATM Transaction");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.CheckBalance");
        System.out.println("4.Account Details");
        System.out.print("Enter the choice:");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                System.out.print("Enter amount to deposit: ");
                int ant=sc.nextInt();
                at.deposit(ant);
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                int amt=sc.nextInt();
                at.withdraw(amt);
                break;
            case 3:
                System.out.println("Current Balance: "+at.checkbalance());
                break;
            case 4:
                at.details();
                break;
            default:
                System.out.println("Invalid Choice");
        }
        System.out.println("Do you want to continue(y/n):");
        g=sc.next().charAt(0);
        }
        sc.close();
    }
    
}
