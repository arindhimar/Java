// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void menu(){
        System.out.println("Main Menu");
        System.out.println("1 - Push");
        System.out.println("2 - Pop");
        System.out.println("3 - Display");
        System.out.println("4 - Exit");
    }

    public static void main(String[] args) {
        int opt;
        int[] stack=new int[0];
        Scanner sc = new Scanner(System.in);

        do{
            menu();
            System.out.printf("Select Menu Option   ==      ");
            opt=sc.nextInt();

            switch (opt){
                case 1:
                    System.out.printf("Enter Element(int) to push   ==      ");
                    int temp= sc.nextInt();
                    stack=Arrays.copyOf(stack,stack.length+1);
                    stack[stack.length-1]=temp;
                    break;
                case 2:
                    if(stack.length==0){
                        System.out.println("Stack is empty!!");
                    }
                    else {
                        System.out.println("Element popped is " + stack[stack.length - 1]);
                        stack = Arrays.copyOf(stack, stack.length - 1);
                    }
                    break;
                case 3:
                    if(stack.length==0){
                    System.out.println("Stack is empty!!");
                     }
                    else{
                    for (int i = 0; i < stack.length; i++) {
                        System.out.printf(" " + stack[i]);
                    }
                    System.out.println();
                    }
                    break;
            }

        }while (opt!=4);

    }
}