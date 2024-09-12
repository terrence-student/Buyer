package controller;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TABLETEST extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

    // Sample fields for demonstration, you would replace these with your actual fields
    private JTextField invoice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TABLETEST frame = new TABLETEST();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TABLETEST() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Create table model with column names in Chinese
        String[] columnNames = {"項次", "產品編號", "產品名稱", "數量", "單位", "單價"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create table and set its model
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 560, 300);
        contentPane.add(scrollPane);

        // Example of a search button to simulate data addition
        JButton searchAccount = new JButton("Search");
        searchAccount.setBounds(10, 10, 100, 30);
        contentPane.add(searchAccount);

        // Example of a text field for invoice input
        invoice = new JTextField();
        invoice.setBounds(120, 10, 200, 30);
        contentPane.add(invoice);

        searchAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Example of adding data to the table
                addDataToTable();
            }
        });
    }

    private void addDataToTable() {
        // Example data for demonstration
        // Replace this with actual data retrieval logic
        String item = "1";
        String productNumber = "P001";
        String productName = "Product Name";
        String amount = "10";
        String unit = "pcs";
        String price = "100.00";

        // Add a new row with the example data
        tableModel.addRow(new Object[]{item, productNumber, productName, amount, unit, price});
    }
}
