import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Display extends JFrame {

    private JTable employeeTable;
    private DefaultTableModel tableModel;

    private String constring = "jdbc:mysql://localhost:3306/jdbc1";
    private String username = "root";
    private String pass = "";

    public Display() {
        // Set up the JFrame
        setTitle("Employee Data Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create components
        tableModel = new DefaultTableModel();
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Fetch and display employee data
        dispEmployeeData();
    }

    private void dispEmployeeData() {
        try (Connection con = DriverManager.getConnection(constring, username, pass);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM emptb")) {

            // Clear existing rows
            tableModel.setRowCount(0);

            // Add column headers
            tableModel.setColumnIdentifiers(new Object[]{"ID", "Name", "Salary"});

            // Add data to the table
            while (rs.next()) {
                Vector<Object> rowData = new Vector<>();
                rowData.add(rs.getInt("eid"));
                rowData.add(rs.getString("ename"));
                rowData.add(rs.getInt("esal"));
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this appropriately in your application
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Display().setVisible(true);
        });
    }
}
