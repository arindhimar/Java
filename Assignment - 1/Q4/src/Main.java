import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n1 , n2,n3;


        System.out.printf("Enter value for n1       ");
        n1=sc.nextInt();


        System.out.printf("Enter value for n2       ");
        n2=sc.nextInt();



        System.out.printf("Enter value for n3       ");
        n3=sc.nextInt();

        if(n1==n2&&n2==n3){
            System.out.println("All are equal!!");
        }

        else if(n1>=n2&&n1>=n3){
            if(n1==n2){
                System.out.println("n1 and n2 are largest!!");
            }
            else if(n1==n3){
                System.out.println("n1 and n3 are largest!!");
            }
            else{
                System.out.println("n1 is largest!!");
            }
        }
        else if(n2>=n3&&n2>=n1){
            if(n1==n2){
                System.out.println("n1 and n2 are largest!!");
            }
            else if(n2==n3){
                System.out.println("n2 and n3 are largest!!");
            }
            else{
                System.out.println("n2 is largest!!");
            }
        }
        else if(n3>=n2&&n3>=n1){
            if(n1==n3){
                System.out.println("n1 and n3 are largest!!");
            }
            else if(n2==n3){
                System.out.println("n2 and n3 are largest!!");
            }
            else{
                System.out.println("n3 is largest!!");
            }
        }

    }
}