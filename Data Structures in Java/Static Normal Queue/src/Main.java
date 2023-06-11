// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.// \


import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("Main Menu");
        System.out.println(" 1 - Enque");
        System.out.println(" 2 - Deque");
        System.out.println(" 3 - Display");
        System.out.println(" 4 - Exit");
        System.out.print("Select Menu Option      ==>>        ");
    }

    public static void main(String[] args) {
        int opt,size,fp=-1,rp=-1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Queue     ==      ");
        size=sc.nextInt();

        int[] queue=new int[size];

        do{
            menu();
            opt=sc.nextInt();
            switch (opt) {
                case 1 -> {
//                    System.out.println(rp);
                    if (rp == size - 1) {
                        System.out.println("Queue Is full!!");
                    } else {
                        System.out.printf("Enter Element(int) ==    ");
                        int temp = sc.nextInt();
                        queue[++rp] = temp;
                        if (fp == -1)
                            fp = 0;
                    }
                }
                case 2 -> {
                    if (fp == -1 && rp == -1) {
                        System.out.println("Queue is empty!!");
                    } else {
                        System.out.println("Element Dequed is " + queue[fp]);
                        if (fp == rp) {
                            fp=rp=-1;
                        }
                        else{
                            fp++;
                        }
                    }
                }
                case 3 -> {
                    if (fp == -1 && rp == -1) {
                        System.out.println("Queue is empty!!");
                    } else {
                        System.out.printf("Queue :");
                        for (int i = fp; i <= rp; i++) {
                            System.out.printf(" " + queue[i]);
                        }
                        System.out.println();
                    }
                }
                case 4 -> {
                    break;
                }
                default -> {
                    System.out.println("Invalid Menu Option!!");
                }
            }
        }while (opt!=4);


    }
}