import java.sql.*;
import java.util.Scanner;

public class Customer extends User implements Transaction{
    int accno,uid,balacne,tempId,rcid,amount;
    Connection connection;


    void CustomerMenu(){
        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Transfer");
        System.out.println("4 - Show All Transactions!!");
        System.out.println("5 - Display Account Info!!");
        System.out.println("6 - Exit");
    }

    @Override
    public void WithDraw() throws SQLException{
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter amount         ");
         amount = sc.nextInt();


        PreparedStatement statement = connection.prepareStatement("select * from accounttb where aid = "+tempId);

        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            int temp = resultSet.getInt("balance");

            if(temp>=amount){
                statement = connection.prepareStatement("update accounttb set balance = balance - "+amount+" where aid = "+tempId);


                statement.executeUpdate();

                rcid = tempId;
                AddTrans();
            }
            else{
                System.out.println("Insufficient Balance!!");
            }
        }

    }

    @Override
    public void Deposit() throws SQLException{
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter amount         ");
         amount = sc.nextInt();



        PreparedStatement statement = connection.prepareStatement("update accounttb set balance = balance + "+amount+" where aid = "+tempId);


        statement.executeUpdate();

        rcid = tempId;
        AddTrans();
    }

    @Override
    public void Transfer() throws SQLException {
        Scanner sc  = new Scanner(System.in);



        System.out.printf("Enter receiver's accno       ");
        rcid = sc.nextInt();

        PreparedStatement statement = connection.prepareStatement("select * from accounttb where aid = "+rcid);

        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            System.out.printf("Enter amount to transfer         ");
            amount = sc.nextInt();

            statement = connection.prepareStatement("select * from accounttb where aid = "+tempId);

            resultSet = statement.executeQuery();

            if(resultSet.next()){
                if(resultSet.getInt("balance")>=amount){
                    statement = connection.prepareStatement("update accounttb set balance = balance - "+amount+" where aid = "+tempId);

                    statement.executeUpdate();

                    statement = connection.prepareStatement("update accounttb set balance = balance + "+amount+" where aid = "+rcid);

                    statement.executeUpdate();

                    AddTrans();

                }
                else {
                    System.out.println("Less balance!!");
                }
            }
        }
        else{
            System.out.println("Invalid Account Number!!");
        }
    }

    @Override
    public void AddTrans() throws  SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `transactiontb`(`sdid`, `rcid`, `balance`) VALUES ("+tempId+","+rcid+","+amount+")");
        statement.executeUpdate();
    }

    @Override
    public void DisplayTrans() throws SQLException {
        PreparedStatement statement  = connection.prepareStatement("select * from transactiontb where sdid = "+tempId+" or rcid ="+tempId+"");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.println("TID : "+resultSet.getInt("tid")+" SDID : "+resultSet.getInt("sdid")+" RCID : "+resultSet.getInt("rcid")+" Balance : "+resultSet.getInt("balance"));
        }
    }





    void ShowAccount() throws SQLException{
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


    void LoginUser(Connection connection,String uemail,String upass){
        try {
            this.connection = connection;
            PreparedStatement statement = connection.prepareStatement("select * from usertb where uemail = '"+uemail+"' and upass='"+upass+"'");
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                PreparedStatement statement2 = connection.prepareStatement("select * from accounttb where uid = "+rs.getInt("uid"));
                ResultSet rs2 = statement2.executeQuery();

                if (rs2.next()){
                    tempId = rs2.getInt("aid");

                    Scanner sc =  new Scanner(System.in);
                    int opt;
                    do{
                        CustomerMenu();
                        opt = sc.nextInt();

                        switch (opt){
                            case 1:
                                Deposit();
                                break;
                            case 2:
                                WithDraw();
                                break;
                            case 3:
                                Transfer();
                                break;
                            case 4:
                                DisplayTrans();
                                break;
                            case 5:
                                ShowAccount();
                                break;
                        }
                    }while (opt!=6);
                }


            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    void addData(Connection connection,String uname,String uemail,String upass) {
        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `usertb`(`uname`, `uemail`, `upass`) VALUES ('"+uname+"','"+uemail+"','"+upass+"')", Statement.RETURN_GENERATED_KEYS);

            if(statement.executeUpdate()>0){
                ResultSet genKeys =statement.getGeneratedKeys();

                if(genKeys.next()){
                    int temp = genKeys.getInt(1);

                    statement = connection.prepareStatement("INSERT INTO `accounttb`(`uid`, `balance`) VALUES ("+temp+",0)");

                    statement.executeUpdate();

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "UID : "+uid+" Name : "+uname+" Email : "+uemail+" Password : "+upass+"\nACCNo : ";
    }


}
