// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,

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
            switch (opt){
                case 1->{
                    if((rp+1)%size==fp){
                        System.out.println("Queue is full");
                    }
                    else{
                        System.out.printf("Enter Element(int) to enter  ==   ");
                        int temp=sc.nextInt();
                        if(rp==-1){
                            rp=fp=0;
                        }
                        else{
                            rp=(rp+1)%size;
                        }
                        queue[rp]=temp;
                    }
                    break;
                }
                case 2->{
                    if(fp==-1&&rp==-1){
                        System.out.println("Queue is empty!!");
                    }
                    else{
                        System.out.println("Element Dequed is "+queue[fp]);
                        if(fp==rp){
                            fp=rp=-1;
                        }
                        else{
                            fp=(fp+1)%size;
                        }
                    }
                    break;
                }
                case 3->{
                    if(fp==-1){
                        System.out.println("Queue is empty!!");
                    }
                    else if(rp>fp){
                        System.out.printf("Queue :");
                        for(int i=fp;i<=rp;i++){
                            System.out.printf(" "+queue[i]);
                        }
                    }
                    else{
                        System.out.printf("Queue :");
                        for(int k=0;k<=rp;k++){
                            System.out.printf(" "+queue[k]);
                        }
                        for(int i=fp;i<size;i++){
                            System.out.printf(" "+queue[i]);
                        }
                    }
                    System.out.println();
                    break;
                }
                case 4->{

                }
                default -> {
                    System.out.println("Inavlid Menu Option!");
                }
            }
        }while (opt!=4);
    }
}