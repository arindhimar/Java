import java.sql.SQLException;

public interface Transaction {

    void WithDraw() throws SQLException;
    void Deposit()throws SQLException;

    void Transfer() throws SQLException;

    void AddTrans() throws SQLException;

    void DisplayTrans() throws SQLException;

}
