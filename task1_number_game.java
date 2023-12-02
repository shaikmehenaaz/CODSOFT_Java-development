import java.util.Random;
import java.util.Scanner;

class task1_number_game{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Guess the number game\n");
        num();
        while (true){
            System.out.println("would you like to play again?\nyes or no");
            String a=sc.nextLine();
            again(a);
            if(a.equals("no")){
                break;
            }
        }

    }
    static void num(){
        Scanner sc=new Scanner(System.in);
        Random rd=new Random();
        int comp_num= rd.nextInt(1,100);
        int user_score=0;
        // System.out.println(comp_num);
        for(int i=0;i<5;i++){
        System.out.print("Enter your guess: ");
        int your_num=sc.nextInt();
        if(comp_num>your_num){
            System.out.println("lower than the actual\n");
        }else if(comp_num<your_num){
            System.out.println("higher than the actual\n");
        }else{
            System.out.println("correct guess\n");
            user_score++;
            break;
        }
        }
        System.out.println("user score: "+user_score);
    }
    static void again(String a){
        if(a.equals("yes")){
            num();
        }else{
            System.out.println("good work");
        }
    }
}