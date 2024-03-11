import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void MainMenu(){
        System.out.println("1 - Login as Customer");
        System.out.println("2 - Login as Staff");
        System.out.println("3 - Register");
        System.out.println("4 - Exit");
    }

    public static void main(String args[]) throws SQLException {
        int opt;
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        Staff s = new Staff();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bankingapplication","root","");
        do{
            MainMenu();
            System.out.printf("Select Menu Option           ");
            opt = sc.nextInt();

            switch (opt){
                case 1:
                    String uemail,upass;
                    sc.nextLine();
                    System.out.printf("Enter Email          ");
                    uemail=sc.nextLine();
                    System.out.printf("Enter Password          ");
                    upass=sc.nextLine();

                    c.LoginUser(connection,uemail,upass);

                    break;
                case 2:
                    String temail,tpass;
                    sc.nextLine();
                    System.out.printf("Enter Email          ");
                    temail=sc.nextLine();
                    System.out.printf("Enter Password          ");
                    tpass=sc.nextLine();

                    s.LoginUser(connection,temail,tpass);

                    break;
                case 3:
                    int temp;
                    System.out.println("1 - Staff");
                    System.out.println("2 - Customer");
                    System.out.print("Select Account Type       ");
                    temp = sc.nextInt();

                    if(temp==1){
                        String s1,s2,s3;
                        sc.nextLine();
                        System.out.print("Enter Name        ");
                        s1 = sc.nextLine();
                        System.out.print("Enter Email        ");
                        s2 = sc.nextLine();
                        System.out.print("Enter Password        ");
                        s3 = sc.nextLine();
                        s.addData(connection,s1,s2,s3);
                    } else if (temp==2) {
                        String s1,s2,s3;
                        sc.nextLine();

                        System.out.print("Enter Name        ");
                        s1 = sc.nextLine();
                        System.out.print("Enter Email        ");
                        s2 = sc.nextLine();
                        System.out.print("Enter Password        ");
                        s3 = sc.nextLine();
                        c.addData(connection,s1,s2,s3);
                    }
                    else{
                        System.out.println("Invalid Input!!");
                    }

                    break;
                default:
                    System.out.println("Invalid Menu Option!!");
                    break;
            }

        }while (opt!=3);
    }
}
