// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import java.util.*;

class Node{
    int value;
    Node next;

    public Node(int temp){
        this.value=temp;
        this.next=null;
    }

}

class Singlyll{
    static Node first;
    static Node last;
    static Scanner sc = new Scanner(System.in);

    public static void insert(){

        System.out.printf("Enter Element int to insert  ==      ");
        int temp=sc.nextInt();
        Node ntemp=new Node(temp);
        if(first==null)
        {
            first=last=ntemp;
        }
        else{
            last.next=ntemp;
            last=ntemp;
        }
    }

    public static void del(){
        if(first==null){
            System.out.println("Linked List is empty!!");
        }
        else{
            System.out.printf("Enter Element to delete  ==  ");
            int val= sc.nextInt();
            int flag=0;
            Node dlp=first;//To hold the previous node
            for(Node dl=first;dl!=null;dl=dl.next){

                if(dl.value==val){
                    flag=1;
                    dlp.next=dl.next;
                }
                dlp=dl;
            }

            //Check if element is deleted!!
            if(flag==1){
                System.out.println("Element Deleted!!");
            }
            else{
                System.out.println("Element Not Deleted!!");
            }
        }
    }

    public static void disp()
    {
        if(first==null){
            System.out.println("Linked List is empty!!");
        }
        else{
            System.out.printf("SLL :");
            for(Node dl=first;dl!=null;dl=dl.next){
                System.out.printf(" "+dl.value);
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void menu()
    {
        System.out.println("Main Menu");
        System.out.println("1 - Insert ");
        System.out.println("2 - Delete ");
        System.out.println("3 - Display ");
        System.out.println("4 - Exit ");
        System.out.printf("Select Menu Option   ==      ");
    }

    public static void main(String[] args) {
        int opt;
        Singlyll sll=new Singlyll();
        Scanner sc = new Scanner(System.in);
        do{
            menu();
            opt=sc.nextInt();

            switch (opt){
                case 1->{
                    sll.insert();

                }
                case 2->{
                    sll.del();

                }
                case 3->{
                    sll.disp();

                }
            }

        }while(opt!=4);
    }
}