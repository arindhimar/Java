import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);


        int n1;

        System.out.printf("Enter the number         ");
        n1=sc.nextInt();


        if(n1%2!=0){
            System.out.println("Number is odd!!");
        }
        else
        {
            System.out.println("Number is not odd!!");
        }
    }
}