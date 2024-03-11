import java.sql.*;


abstract class User {
    int uid = 0;
    String uname,upass,uemail;


    abstract void addData(Connection connection,String uname,String uemail,String upass);


    abstract void  LoginUser(Connection connection,String uemail,String upass);
}
