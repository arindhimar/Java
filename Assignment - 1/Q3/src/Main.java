import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String s;

        Scanner sc=new Scanner(System.in);


        System.out.printf("Enter the String             ");
        s=sc.nextLine();


        String rev="";

        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            rev=rev+ch;
        }

        System.out.println(rev);
        if(s.equals(rev)){
            System.out.println("Palindrome!!");
        }
        else{
            System.out.println("Not a Palindrome!!");

        }
    }
}