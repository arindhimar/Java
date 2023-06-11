// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp= new Scanner(System.in);
        int marks[] = new int[5];
        int sum = 0;

        for(int i=0;i<5;i++){
            sum+= inp.nextInt();
        }
//        System.out.println(sum);
        if(sum>60)
        {
            System.out.println("First Div");
        }
        else if (sum>50&&sum<59) {
            System.out.println("Second Div");
        }
        else if (sum>40&&sum<49) {
            System.out.println("Third Div");
        }
        else if (sum<40) {
            System.out.println("Failed");
        }
    }
}