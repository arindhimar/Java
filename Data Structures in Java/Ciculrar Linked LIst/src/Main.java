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

class Cicularll{
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
            last.next=first;
        }
        else{
            last.next=ntemp;
            last=ntemp;
            last.next=first;
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
            if(first.next==last.next&&first.value==val){
                first=last=null;
                flag=1;
            }
            else if(first.value==val){
                last.next=first.next;
                first=last.next;
                flag=1;
            } else if (last.value==val) {
                Node ctemp=first;
                do{
                    ctemp=ctemp.next;
                }while(ctemp.next!=last);
                ctemp.next=first;
                last=ctemp;
                flag=1;
            }
            else{
                Node dlp=first;//To hold the previous node
                Node dln=first;
                do{
                    if(dln.value==val){
                        flag=1;
                        dlp.next=dln.next;
                    }
                    dlp=dln;
                    dln=dln.next;
                }while(dln!=first);
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
            System.out.printf("CLL :");
            Node dcll=first;
            do {
                System.out.printf(" "+dcll.value);
                dcll=dcll.next;
            }while(dcll!=first);
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
        Cicularll cll=new Cicularll();
        Scanner sc = new Scanner(System.in);
        do{
            menu();
            opt=sc.nextInt();

            switch (opt){
                case 1->{
                    cll.insert();

                }
                case 2->{
                    cll.del();

                }
                case 3->{
                    cll.disp();

                }
            }

        }while(opt!=4);
    }
}