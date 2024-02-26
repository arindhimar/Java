import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1,n2;

        System.out.print("Enter n1          ");
        n1=sc.nextInt();

        System.out.print("Enter n2          ");
        n2=sc.nextInt();


        System.out.println("Sum of n1 + n2 = "+(n1+n2));
    }
}