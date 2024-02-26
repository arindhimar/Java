import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    private JPanel main;
    private JLabel Name;
    private JLabel Sal;
    private JButton btnInsert;
    private JTextField txtName;
    private JTextField txtSal;
    private JLabel sal;
    private JTextField txtId;
    private JButton btnUpdate;
    private JButton btnDel;
    private JButton btnDisplay;

    private String constring = "jdbc:mysql://localhost:3306/jdbc1";
    private String username = "root";
    private String pass = "";


    public static void main(String[] args) {
        JFrame frame = new JFrame("Insert");
        frame.setContentPane(new Insert().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public  void insertData() throws SQLException {
        Connection con= DriverManager.getConnection(constring,username,pass);
        Statement st=con.createStatement();
        String sql="insert into emptb(ename,esal) values('"+txtName.getText().toString()+"',"+txtSal.getText()+")";

        System.out.println(st.executeUpdate(sql));
    }

    public void deleteData() throws SQLException {
        Connection con= DriverManager.getConnection(constring,username,pass);
        Statement st=con.createStatement();
        String sql="delete from emptb where eid="+txtId.getText();

        System.out.println(st.executeUpdate(sql));
    }

    public  void updateData() throws SQLException {
        Connection con= DriverManager.getConnection(constring,username,pass);
        Statement st=con.createStatement();
        String sql="update emptb set ename='"+txtName.getText()+"',esal="+txtSal.getText()+" where eid="+txtId.getText();

        System.out.println(st.executeUpdate(sql));
    }



    public Insert() {
    btnInsert.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println(txtName.getText().toString());
            try {
                insertData();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    });


        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateData();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteData();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame display= new JFrame();
                display.setVisible(true);  // Make the Display GUI visible

            }
        });
    }
}
