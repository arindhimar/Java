// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.sql.SQLOutput;
import java.util.Arrays;
import  java.util.Scanner;

public class Main {

    static void menu(){
        System.out.println("1 - Add Element");
        System.out.println("2 - Delete Element");
        System.out.println("3 - Display Elements");
        System.out.println("4 - Exit");
        System.out.printf("Select Menu Option ==>>      ");
    }

    public static void main(String[] args) {
        int n,temp;
        int[] arr=new int[0];
        Scanner inp = new Scanner(System.in);
        do{
            menu();
            n= inp.nextInt();

            switch (n)
            {
                case 1:
//                    arr=new int[arr.length+1];
                    System.out.printf("Enter The new Element    ==>>    ");
                    temp = inp.nextInt();
                    arr=Arrays.copyOf(arr,arr.length+1);
                    arr[arr.length-1]=temp;
//                    System.out.println(arr.length);
                    break;
                case 2:
                    System.out.printf("Enter The Element to Delete    ==>>    ");
                    temp = inp.nextInt();
                    int[] narr=new int[arr.length];
                    int j=0;
                    int count=0;
                    for(int k=0;k<arr.length;k++){
                        //Keep track if element found or not using j as flag && incrementing k to skip it
                        if(arr[k]==temp){
                            k++;
                            j=1;
                        }
                        narr[count++]=arr[k];

                    }

                    if(j==1){
                        arr=narr;
                        arr=Arrays.copyOf(narr,narr.length-1);
                    }
                    else{
                        System.out.println("No such Element found!!");
                    }


                    break;
                case 3:
                    for(int i=0;i<arr.length;i++){
                        System.out.println("Element at index " + i +" = " + arr[i]);
                    }
                    break;
            }

        }while(n!=4);

        System.out.printf("Program Terminated");

    }
}