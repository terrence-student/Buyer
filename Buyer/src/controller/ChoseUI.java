package controller;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Member;
import util.DateCalculator;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class ChoseUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static DateCalculator dc = new DateCalculator();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChoseUI frame = new ChoseUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ChoseUI() {}

    public ChoseUI(Member m) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);  // 擴大框架尺寸
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 主面板背景色設定為柔和淡藍色
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 240, 255)); // 淡藍色
        panel.setBounds(0, 0, 500, 420);
        contentPane.add(panel);
        panel.setLayout(null);

        // 系統選擇下拉選單
        JComboBox<String> system = new JComboBox<>();
        system.setFont(new Font("新細明體", Font.BOLD, 20));  // 字體設為普通大小
        system.setModel(new DefaultComboBoxModel<>(new String[]{
                "apmi600  廠商資料維護系統",
                "aapt110   發票維護系統",
                "apmt110 帳款維護系統"}));
        system.setBounds(120, 167, 300, 40);  // 調整選單位置與大小
        panel.add(system);

        // 歡迎標籤
        JLabel welcome = new JLabel("歡迎您!", SwingConstants.CENTER);  // 設定標籤內容置中
        welcome.setFont(new Font("新細明體", Font.BOLD, 26));  // 字體大小設為24
        welcome.setBounds(91, 79, 312, 40);  // 調整標籤位置與大小
        panel.add(welcome);
        welcome.setText(m.getName() + ",歡迎您!");  // 假設使用者名稱是從 Member 物件取得

        // 確定按鈕
        JButton btnConfirm = new JButton("確定");
        btnConfirm.setFont(new Font("新細明體", Font.BOLD, 20));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setBackground(new Color(153, 204, 255));  // 柔和淺藍色
        btnConfirm.setBounds(113, 228, 120, 40);  // 調整按鈕大小與位置
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedSystem = (String) system.getSelectedItem();
                switch (selectedSystem) {
                    case "apmi600  廠商資料維護系統":
                        new sellerAdd().setVisible(true);
                        break;
                    case "aapt110   發票維護系統":
                        new invoiceAdd().setVisible(true);
                        break;
                    case "apmt110 帳款維護系統":
                        new Manage(m).setVisible(true);
                        break;
                }
            }
        });
        panel.add(btnConfirm);

        // 退出系統按鈕
        JButton btnExit = new JButton("退出系統");
        btnExit.setFont(new Font("新細明體", Font.BOLD, 20));
        btnExit.setForeground(Color.WHITE);
        btnExit.setBackground(new Color(153, 204, 255));  // 柔和淺藍色
        btnExit.setBounds(253, 228, 150, 40);  // 調整按鈕大小與位置
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnExit);

        // 時間顯示標籤
        JLabel lblTime = new JLabel("", SwingConstants.RIGHT);
        lblTime.setFont(new Font("新細明體", Font.PLAIN, 18));  // 調整字體大小
        lblTime.setBounds(323, 360, 140, 30);  // 調整標籤位置與大小
        panel.add(lblTime);

        // 系統標籤
        JLabel lblSystem = new JLabel("系統:");
        lblSystem.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSystem.setForeground(new Color(0, 0, 0));
        lblSystem.setFont(new Font("新細明體", Font.BOLD, 23));
        lblSystem.setBounds(20, 167, 90, 40);  // 調整標籤位置與大小
        panel.add(lblSystem);

        // 設置定時器以每秒更新一次時間標籤
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.updateLabelWithTime(lblTime);
            }
        });
        timer.start();
    }
}
