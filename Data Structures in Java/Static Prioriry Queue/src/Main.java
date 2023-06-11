// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("Main Menu");
        System.out.println("1 - Enqueue in A ");
        System.out.println("2 - Enqueue in B ");
        System.out.println("3 - Deque");
        System.out.println("4 - Display");
        System.out.println("5 - Exit");
        System.out.printf("Select Menu Option   ==      ");
    }
    public static void main(String[] args) {
        int size1,size2,opt,fp1,fp2,rp1,rp2;
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter size for Queue A   ==      ");
        size1=sc.nextInt();

        System.out.printf("Enter size for Queue B   ==      ");
        size2=sc.nextInt();

        int[] qa=new int[size1];
        int[] qb=new int[size2];

        fp1=fp2=rp1=rp2=-1;

        do {
            menu();
            opt= sc.nextInt();
            switch (opt){
                case 1->{
                    if(rp1==size1-1){
                        System.out.println("Queue A is ful!!");
                    }
                    else{
                        if(fp1==-1){
                            fp1=rp1=0;
                        }
                        else{
                            rp1++;
                        }
                        System.out.printf("Enter Element(int) to insert     ==      ");
                        int temp1=sc.nextInt();
                        qa[rp1]=temp1;
                    }
                    break;
                }
                case 2->{
                    if(rp2==size2-1){
                        System.out.println("Queue A is ful!!");
                    }
                    else{
                        if(fp2==-1){
                            fp2=rp2=0;
                        }
                        else{
                            rp2++;
                        }
                        System.out.printf("Enter Element(int) to insert     ==      ");
                        int temp2=sc.nextInt();
                        qb[rp2]=temp2;
                    }
                    break;
                }
                case 3->{
                    if(fp1==-1&&fp2==-1){
                        System.out.println("Both Queue are empty!!");
                    }
                    else{
                        if(fp1!=-1){
                            System.out.println("Element dequed is "+qa[fp1]);
                            if(fp1==rp1){
                                fp1=rp1=-1;
                            }
                            else {
                                fp1++;
                            }
                        }
                        else{
                            System.out.println("Element dequed is "+qb[fp2]);
                            if(fp2==rp2){
                                fp2=rp2=-1;
                            }
                            else {
                                fp2++;
                            }
                        }
                    }
                    break;
                }
                case 4->{
                    System.out.printf("Queue  A :");
                    if(fp1==-1){
                        System.out.println("Empty!!");
                    }
                    else{
                        for(int i1=fp1;i1<=rp1;i1++){
                            System.out.printf(" "+qa[i1]);
                        }
                    }
                    System.out.println();
                    System.out.printf("Queue  B :");
                    if(fp2==-1){
                        System.out.println("Empty!!");
                    }
                    else{
                        for(int i2=fp2;i2<=rp2;i2++){
                            System.out.printf(" "+qb[i2]);
                        }
                    }
                    System.out.println();
                    break;
                }
                default -> {
                    System.out.println("Invalid Menu Option!!");
                }
            }
        }while(opt!=5);

    }
}