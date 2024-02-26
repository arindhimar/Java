// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import javax.imageio.stream.ImageInputStream;
import java.util.*;
class Library{
    String libName;
    Scanner sc=new Scanner(System.in);
    int authorNo=0;
    public Library()
    {
        System.out.printf("Please enter name for the library    ==      ");
        this.libName=sc.nextLine();
        System.out.println("Library Added");
    }
    public void disp(int temp){
        System.out.println("Library Id : "+(temp+1));
        System.out.println("Library Name : "+this.libName+"\n");
    }
}

class Author extends Library{
    int Libno;
    String authorName;

    public Author(){
        System.out.printf("Please enter name for the Author    ==      ");
        this.authorName=sc.nextLine();
        System.out.println("Author Added");
        authorNo+=1;
    }

    public void addautNo()
    {
        System.out.printf("Select Library Id    ==      ");
        Libno= sc.nextInt();
    }

    public void disp() {
        System.out.println("Library Id : "+this.Libno);
        System.out.println("Author Id : "+this.authorNo);
        System.out.println("Author Name : "+this.authorName);
    }
}

public class Main {
    static Scanner sc=new Scanner(System.in);
    static Library [] libArr=new Library[0];
    static Author [] autArr=new Author[0];
    static void menu(){
        System.out.println("Main Menu");
        System.out.println("1 - Add Library");
        System.out.println("2 - Add Author");
        System.out.println("3 - Add Book");
        System.out.println("4 - Display Library");
        System.out.println("5 - Display Author");
        System.out.println("6 - Display Book");
        System.out.println("7 - Exit");
        System.out.printf("Select Menu Option   ==      ");
    }


    public static void addlib()
    {
        libArr=Arrays.copyOf(libArr,libArr.length+1);
        libArr[libArr.length-1]=new Library();
    }
    public static void dispalllib()
    {
        for(int i=0;i< libArr.length;i++){
            libArr[i].disp(i);
        }
    }

    public static void addAuthor()
    {
        autArr=Arrays.copyOf(autArr,autArr.length+1);
        autArr[autArr.length-1]=new Author();
        dispalllib();
        autArr[autArr.length-1].addautNo();
    }

    public static void dispAllAuthor()
    {
        for(int i=0;i< autArr.length;i++){
            autArr[i].disp();
        }
    }


    public static void main(String[] args) {
        int opt;

        do{
            menu();
            opt=sc.nextInt();

            switch (opt){
                case 1->{
                    addlib();
                    break;
                }
                case 2->{
                    addAuthor();
                }
                case 3->{

                }
                case 4->{
                    dispalllib();
                }
                case 5->{
                    dispAllAuthor();
                }
                case 6->{

                }
                case 7->{
                    System.out.println("Exiting the program.");
                }
                default -> {
                    System.out.println("Invalid option. Please try again.");
                }
            }

        }while(opt!=7);


    }
}