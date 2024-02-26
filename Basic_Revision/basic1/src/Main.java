// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        int[] arr = new int[5];
//        int[][] twoDArray = new int[3][4];

        ArrayList <Integer> arr = new ArrayList<Integer>();

        Scanner sc= new Scanner(System.in);
        int i;
        for (i = 0; i <5;i++){
            System.out.println("Enter data");
            arr.add(sc.nextInt());
        }

        for (int temp:arr){
            System.out.println("Value "+ temp);
        }

//        System.out.println("Int a :" + a);

    }
}