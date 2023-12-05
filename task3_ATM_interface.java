import java.util.Scanner;

abstract class Accounts{
    int balance;
    int accno;
    String name;
    String address;
    abstract public void withdrawl(int amount);
    abstract public void deposit(int amount);
    void display(){
    }
}
class SavingsAccount extends Accounts{
    int roi;
    public SavingsAccount(int accno, int balance, int roi){
        this.accno=accno;
        this.balance=balance;
        this.roi=roi;
    }
    public void calcamt(int balance){
        System.out.println(roi*balance);
    }
    void display(){
        System.out.println(balance+(balance*roi/100));
    }
    public void withdrawl(int amount){
        System.out.println(balance-amount);
    }
    public void deposit(int amount){
        System.out.println(balance+amount);
    }
}
class CurrentAccount extends Accounts{
    int draftLimit;
    public CurrentAccount(int accno, int balance, int draftLimit) {
        this.accno = accno;
        this.balance = balance;
        this.draftLimit = draftLimit;
    }
    void display(){
        System.out.println(draftLimit);
    }
    public void deposit(int amount){
        System.out.println(balance+amount);
    }
    public void withdrawl(int amount){
        System.out.println(balance-amount);
    }
}
public class task3_ATM_interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("");
        int accno = sc.nextInt();

        System.out.print("");
        int balance = sc.nextInt();

        System.out.print("");
        String name = sc.nextLine();
        name=sc.nextLine();

        System.out.print("");
        String add = sc.nextLine();
        System.out.println(accno + " " + name + " " + balance + " " + add);
        // 1-savings , 2-current
        System.out.print("");
        int N = sc.nextInt();

        if (N == 1) {
            System.out.print("");
            int roi = sc.nextInt();
            System.out.print("");
            int N1 = sc.nextInt();
            SavingsAccount sa = new SavingsAccount(accno,balance,roi);
            sa.display();
            if(N==1){
                System.out.print("");
                int amount_depo = sc.nextInt();
                sa.deposit(amount_depo);
            }else if(N==2){
                System.out.print("");
                int amount_with = sc.nextInt();
                sa.withdrawl(amount_with);
            }
        } else if (N == 2) {
            System.out.print("");
            int draft_limit = sc.nextInt();
            System.out.print("");
            int N1 = sc.nextInt();
            CurrentAccount ca = new CurrentAccount(accno,balance,draft_limit);
            ca.display();
            if(N==1){
                System.out.print("");
                int amount_depo = sc.nextInt();
                ca.deposit(amount_depo);
            }else if(N==2){
                System.out.print("");
                int amount_with = sc.nextInt();
                ca.withdrawl(amount_with);
            }
        }

    }
}

