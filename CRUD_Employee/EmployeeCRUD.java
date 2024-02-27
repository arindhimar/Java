import java.sql.*;

public class EmployeeCRUD {
    private static final String URL = "jdbc:mysql://localhost/javaempdb";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void main(String args[]){
        try(Connection connection = DriverManager.getConnection(URL,USER,PASS)){
            // Create
            displayRecords(connection);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void createRecord(Connection connection, String name, String email,String pass) throws SQLException {
        String sql = "INSERT INTO emptb (ename, eemail,epass) VALUES ('"+name+"','"+email+"','"+pass+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
    }

    private static void deleteRecord(Connection connection, int id) throws SQLException {
        String sql = "delete from emptb where eid = "+id;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
    }

    private static void updateRecord(Connection connection,int id, String name, String email,String pass) throws SQLException {
        String sql = "UPDATE `emptb` SET `ename`='"+name+"',`eemail`='"+email+"',`epass`='"+pass+"' WHERE eid = "+id;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
    }


    private static void displayRecords(Connection connection)throws SQLException{
        String sql = "SELECT * FROM emptb";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("eid") + ", Name: " + resultSet.getString("ename") + ", Email: " + resultSet.getString("eemail")+ ", Pass: " + resultSet.getString("epass"));
        }
    }



}
