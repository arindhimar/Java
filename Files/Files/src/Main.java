// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;
import java.applet.*;
import java.io.*;


class Employee implements Serializable{
    int empNO;
    String empName;
    float empSal;



    Employee(int tempNO,String empName,float tempSal){
        this.empNO=tempNO;
        this.empName=empName;
        this.empSal=tempSal;
    }

    @Override
    public String toString() {
        return
                "ID : "+ empNO+"\nName : "+empName+"\nSalary : "+empSal;
    }
}

public class Main {

    public static void menu(){
        System.out.println("1 - Insert");
        System.out.println("2 - Display");
        System.out.println("3 - Search");
        System.out.println("4 - Delete");
        System.out.println("5 - Update");
        System.out.println("0 - Exit");

    }

    public static void main(String[] args) throws Exception {

        int opt=0,temp,flag;
        Scanner sc=new Scanner(System.in);
        ArrayList arr=new ArrayList<Employee>();
        //Files
        File file=new File("Employee.txt");
        ListIterator l = null;



        ObjectOutputStream oos=null;//for writing into the file
        ObjectInputStream ois=null;//for reading from the file

        if(file.isFile()){//checks if the file already exists!!
            ois=new ObjectInputStream(new FileInputStream(file));

            arr= (ArrayList<Employee>) ois.readObject();//reads the object from the file , also requires type casting

            ois.close();
        }


        do{
            menu();
            opt=sc.nextInt();

            switch (opt){
                case 1:
                    int ct=0;
                    System.out.print("Enter count of employees to enter  ");
                    ct= sc.nextInt();
                    sc.nextLine();

                    for (int i=0;i<ct;i++){
                        int tempNo;
                        String tempName;
                        float tempSal;

                        System.out.print("Enter Employee No  ");
                        tempNo=sc.nextInt();
                        sc.nextLine();//to consume the next line character
                        System.out.print("Enter Employee Name  ");
                        tempName=sc.nextLine();
                        System.out.print("Enter Employee Salary  ");
                        tempSal=sc.nextFloat();

                        arr.add(new Employee(tempNo,tempName,tempSal));
                    }

                    oos=new ObjectOutputStream(new FileOutputStream(file));

                    oos.writeObject(arr);

                    oos.close();

                    break;

                case 2:
                    l=arr.listIterator();
                    System.out.println("========================================================");
                    while (l.hasNext()){
                        System.out.println(l.next());
                        System.out.println("========================================================");

                    }

//                    System.out.println(arr);
                    break;

                case 3:
                    System.out.printf("Enter The Id to Search        ");
                     temp=sc.nextInt();

                     flag=0;

                    for (Object e : arr){
                        if(e instanceof Employee emp && emp.empNO==temp){
                            System.out.println(emp);
                            flag=1;
                        }
                    }

                    if(flag==0){
                        System.out.println("No data found!!");
                    }

                    break;

                case 4:
                    System.out.printf("Enter The Id to delete        ");
                    temp=sc.nextInt();

                    flag=0;

                    l=arr.listIterator();
//                    System.out.println("========================================================");
                    while (l.hasNext()){

                        Employee emp= (Employee) l.next();

                        if(emp.empNO==temp){
                            l.remove();
                            flag=1;
                        }



//                        System.out.println(l.next());
//                        System.out.println("========================================================");

                    }

                    oos=new ObjectOutputStream(new FileOutputStream(file));

                    oos.writeObject(arr);

                    oos.close();


                    if(flag==0){
                        System.out.println("No data found!!");
                    }

                    break;

                case 5:
                    System.out.printf("Enter The Id to Update        ");
                    temp=sc.nextInt();

                    flag=0;

                    l=arr.listIterator();
//                    System.out.println("========================================================");
                    while (l.hasNext()){

                        Employee emp= (Employee) l.next();

                        if(emp.empNO==temp){
                            sc.nextLine();//to consume the next line character
                            System.out.print("Enter Employee Name  ");
                            emp.empName=sc.nextLine();
                            System.out.print("Enter Employee Salary  ");
                            emp.empSal=sc.nextFloat();
                            flag=1;
                        }

//                        System.out.println(l.next());
//                        System.out.println("========================================================");

                    }

                    oos=new ObjectOutputStream(new FileOutputStream(file));

                    oos.writeObject(arr);

                    oos.close();


                    if(flag==0){
                        System.out.println("No data found!!");
                    }

                    break;

            }

        }while (opt!=0);

    }
}