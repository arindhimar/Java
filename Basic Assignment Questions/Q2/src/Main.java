// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();

        for(int i=1;i<=n;i++){
            for(int l=1;l<i;l++){
                System.out.printf(" ");
            }
            for(int j=n;j>=i;j--){
                System.out.printf("*");
            }
            for(int k=i;k<n;k++){
                System.out.printf("*");
            }
            System.out.println("");
        }

    }
}