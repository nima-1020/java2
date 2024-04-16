//Alphabet.java
public class Alphabet extends Thread {
    public void run() {
        try {
            for (char i = 'a'; i <= 'z'; i++) {
                System.out.println(i);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) {
        Alphabet p = new Alphabet();
        p.start();
    }
}
EmployeDetails.java
  import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EmployeeDetails extends JFrame implements ActionListener {
    private JLabel labelEno, labelEName, labelDesignation, labelSalary;
    private JTextField textEno, textEName, textDesignation, textSalary;
    private JButton btnSave;
    
    public EmployeeDetails() {
        setTitle("Employee Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelEno = new JLabel("Employee Number:");
        textEno = new JTextField(20);
        
        labelEName = new JLabel("Employee Name:");
        textEName = new JTextField(20);
        
        labelDesignation = new JLabel("Designation:");
        textDesignation = new JTextField(20);
        
        labelSalary = new JLabel("Salary:");
        textSalary = new JTextField(20);
        
        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(labelEno);
        panel.add(textEno);
        panel.add(labelEName);
        panel.add(textEName);
        panel.add(labelDesignation);
        panel.add(textDesignation);
        panel.add(labelSalary);
        panel.add(textSalary);
        panel.add(new JLabel());
        panel.add(btnSave);
        
        add(panel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new EmployeeDetails();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            saveEmployeeDetails();
        }
    }
    
    private void saveEmployeeDetails() {
        int eno = Integer.parseInt(textEno.getText());
        String eName = textEName.getText();
        String designation = textDesignation.getText();
        double salary = Double.parseDouble(textSalary.getText());
        
        try {
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "", "");
            String query = "INSERT INTO employee VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, eno);
            preparedStatement.setString(2, eName);
            preparedStatement.setString(3, designation);
            preparedStatement.setDouble(4, salary);
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Employee details saved successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save employee details.");
            }
            
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
