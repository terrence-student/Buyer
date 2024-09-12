package controller;

import model.Member;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import service.Impl.MemberServiceImpl;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class addMember extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextField username;
    private JTextField password;
    private static MemberServiceImpl msi = new MemberServiceImpl();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    addMember frame = new addMember();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public addMember() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 主面板背景設為柔和淡藍色
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 240, 255)); // 淡藍色背景
        panel.setBounds(0, 0, 484, 461);
        contentPane.add(panel);
        panel.setLayout(null);

        // "請註冊" 標籤
        JLabel lblNewLabel_6 = new JLabel("請註冊");
        lblNewLabel_6.setFont(new Font("微軟正黑體", Font.BOLD, 30));  // 使用更大的字體
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(130, 40, 230, 50);  // 調整標籤大小
        panel.add(lblNewLabel_6);

        // 名字標籤
        JLabel lblNewLabel_1 = new JLabel("名字:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 22));  // 使用更大的字體
        lblNewLabel_1.setBounds(70, 120, 70, 36);
        panel.add(lblNewLabel_1);

        // 名字輸入框
        name = new JTextField();
        name.setFont(new Font("微軟正黑體", Font.PLAIN, 18));  // 更新字體
        name.setColumns(10);
        name.setBounds(150, 120, 214, 36);  // 調整輸入框大小
        panel.add(name);

        // 帳號標籤
        JLabel lblNewLabel_2 = new JLabel("帳號:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 22));  // 使用不同大小的字體
        lblNewLabel_2.setBounds(70, 180, 70, 36);
        panel.add(lblNewLabel_2);

        // 帳號輸入框
        username = new JTextField();
        username.setFont(new Font("微軟正黑體", Font.PLAIN, 18));  // 更新字體
        username.setColumns(10);
        username.setBounds(150, 180, 214, 36);  // 調整輸入框大小
        panel.add(username);

        // 密碼標籤
        JLabel lblNewLabel_3 = new JLabel("密碼:");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 22));  // 使用不同大小的字體
        lblNewLabel_3.setBounds(70, 240, 70, 36);
        panel.add(lblNewLabel_3);

        // 密碼輸入框
        password = new JTextField();
        password.setFont(new Font("微軟正黑體", Font.PLAIN, 18));  // 更新字體
        password.setColumns(10);
        password.setBounds(150, 240, 214, 36);  // 調整輸入框大小
        panel.add(password);

        // 確認按鈕
        JButton btnNewButton = new JButton("確認");
        btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 22));  // 加大按鈕字體
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(153, 204, 255));  // 柔和淺藍色按鈕
        btnNewButton.setBounds(170, 320, 140, 50);  // 調整按鈕大小與位置
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Name = name.getText();
                String Username = username.getText();
                String Password = password.getText();

                if (msi.findByUserName(Username)) {
                    new addMemberError().setVisible(true);
                    dispose();
                }

                Member m = new Member(Name, Username, Password);
                msi.AddMember(m);

                new addMemberSuccess().setVisible(true);
                dispose();
            }
        });
        panel.add(btnNewButton);
    }
}
