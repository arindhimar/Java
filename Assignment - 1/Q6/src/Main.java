import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc=new Scanner(System.in);


        int n1,n2;

        System.out.printf("Enter value for n1       ");
        n1=sc.nextInt();

        System.out.printf("Enter value for n2       ");
        n2=sc.nextInt();

        System.out.printf("Odd numbers      ");
        for(int i=n1;i<=n2;i++){
            if(i%2!=0){
                System.out.print("\t"+i);
            }
        }
    }
}