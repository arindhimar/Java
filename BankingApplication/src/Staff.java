import java.sql.*;
import java.util.Scanner;

public class Staff extends User implements Transaction{
    Connection connection;
    int sdid,rcid,amount;

    void LoginUser(Connection connection,String uemail,String upass){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from usertb where uemail = '"+uemail+"' and upass='"+upass+"'");
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                this.connection = connection;
                int opt;
                Scanner sc = new Scanner(System.in);
                do{
                    StaffMenu();
                    opt = sc.nextInt();

                    switch (opt){
                        case 1:
                            SearchAccount();
                            break;
                        case 2:
                            DisplayTrans();
                            break;
                        case 3:
                            Deposit();
                            break;
                        case 4:
                            WithDraw();
                            break;
                        case 5:
                            Transfer();
                            break;
                    }

                }while (opt!=6);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    void SearchAccount() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter Account number to search           ");
        int tempId = sc.nextInt();

        PreparedStatement statement = connection.prepareStatement("select * from usertb where uid in (select uid from accounttb where aid = "+tempId+")");

        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            System.out.println("UID : "+resultSet.getInt("uid")+" Name : "+resultSet.getString("uname")+" Email : "+resultSet.getString("uemail")+" Password : "+resultSet.getString("upass"));
        }

        statement = connection.prepareStatement("select * from accounttb where aid = "+tempId);

        resultSet = statement.executeQuery();

        if(resultSet.next()){
            System.out.println("AID : "+resultSet.getInt("aid")+" Balance : "+resultSet.getInt("balance"));
        }
    }



    void StaffMenu(){
        System.out.println("1 - Search customer profile by account no.");
        System.out.println("2 - View All Transactions");
        System.out.println("3 - Deposit");
        System.out.println("4 - Withdraw");
        System.out.println("5 - Transfer");
        System.out.println("6 - LogOut");
    }


    @Override
    void addData(Connection connection,String uname,String uemail,String upass) {
        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `usertb`(`uname`, `uemail`, `upass`) VALUES ('"+uname+"','"+uemail+"','"+upass+"')", Statement.RETURN_GENERATED_KEYS);

            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void WithDraw() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter User AID       :           ");
        rcid = sc.nextInt();

        PreparedStatement statement = connection.prepareStatement("select * from accounttb where aid = "+rcid);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            System.out.printf("Enter Amount to withdraw          ");
            amount = sc.nextInt();

            if(resultSet.getInt("balance")>=amount){

                statement = connection.prepareStatement("update accounttb set balance=balance-"+amount+" where aid = "+rcid);

                if(statement.executeUpdate()>0) {
                    sdid = rcid;
                    AddTrans();

                }
            }
            else
                System.out.println("Low balance!!");

        }
        else
            System.out.println("Invalid Account number!!");
    }

    @Override
    public void Deposit() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter User AID       :           ");
        rcid = sc.nextInt();

        PreparedStatement statement = connection.prepareStatement("select * from accounttb where aid = "+rcid);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            System.out.printf("Enter Amount to deposit          ");
            amount = sc.nextInt();

            statement = connection.prepareStatement("update accounttb set balance=balance+"+amount+" where aid = "+rcid);

            if(statement.executeUpdate()>0){
                sdid = rcid;
                AddTrans();
            }

        }
        else
            System.out.println("Invalid Account number!!");

    }

    @Override
    public void Transfer() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Receivers AID       :           ");
        rcid = sc.nextInt();

        System.out.printf("Enter Senders AID       :           ");
        sdid = sc.nextInt();

        PreparedStatement statement = connection.prepareStatement("select * from accounttb where aid = "+rcid);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){

            statement = connection.prepareStatement("select * from accounttb where aid = "+sdid);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.printf("Enter Amount to transfer          ");
                amount = sc.nextInt();

                if(resultSet.getInt("balance")>=amount){
                    statement = connection.prepareStatement("update accounttb set balance=balance+"+amount+" where aid = "+rcid);
                    statement.executeUpdate();

                    statement = connection.prepareStatement("update accounttb set balance=balance-"+amount+" where aid = "+sdid);
                    statement.executeUpdate();

                    AddTrans();

                }
                else
                    System.out.println("Low balance!!");


            }
            else
                System.out.println("Invalid Account number!!");
        }
        else
            System.out.println("Invalid Account number!!");
    }

    @Override
    public void AddTrans() throws SQLException {
//        System.out.println("insert into transactiontb (rcid,sdid,balance) values ("+sdid+","+rcid+"+"+amount+")");
        PreparedStatement statement = connection.prepareStatement("insert into transactiontb (rcid,sdid,balance) values ("+sdid+","+rcid+","+amount+")");

        statement.executeUpdate();
    }

    @Override
    public void DisplayTrans() throws SQLException {
        PreparedStatement statement = connection.prepareStatement( "select * from transactiontb");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.println("TID : "+resultSet.getInt("tid")+"RCID : "+resultSet.getInt("rcid")+" SDID : "+resultSet.getInt("sdid")+" Balance : "+resultSet.getInt("balance"));
        }
    }
}
