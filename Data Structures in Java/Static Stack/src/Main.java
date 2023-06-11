// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void menu()
    {
        System.out.println("Main Menu");
        System.out.println("1 - Push");
        System.out.println("2 - Pop");
        System.out.println("3 - Disp");
        System.out.println("4 - Exit");
        System.out.printf("Select Menu Opiton ==>>      ");
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);


        int opt,size;
        System.out.printf("Enter Size  of Stack :   ");
        size=sc.nextInt();
        int[] arr=new int[size];
        int count=-1;

        do{
            menu();
            opt=sc.nextInt();

            switch (opt)
            {
                case 1:
                    if(count==size-1){
                        System.out.println("Stack is Full!!");
                    }
                    else{
                        System.out.printf("Enter Element(int) to insert  ==      ");
                        int temp = sc.nextInt();

                        arr[++count]=temp;
                    }
                    break;
                case 2:
                    if(count==-1){
                        System.out.println("Stack is Empty!!");
                    }
                    else{
                        System.out.println("Element Popped is "+arr[count--]);
                    }
                    break;
                case 3:
                    for(int i=0;i<=count;i++){
                        System.out.printf(" "+arr[i]+"\n");
                    }
                    break;
            }
        }while(opt!=4);
        System.out.println("Exit!!");
    }
}