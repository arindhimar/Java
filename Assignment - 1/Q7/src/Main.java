import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int len;
        Scanner sc=new Scanner(System.in);
        System.out.printf("Enter Length         ");
        len=sc.nextInt();
        int[] arr=new int[len];

        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<len;i++){

            if(i+1<arr.length) {
                for (int j = i + 1; j < len; j++) {
                    if (arr[i] == arr[j]) {
                        System.out.println("Duplicate Value  = " + arr[i]);
                    }
                }
            }
        }

    }
}