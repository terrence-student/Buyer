package controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.Impl.MemberServiceImpl;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private MemberServiceImpl msi= new MemberServiceImpl();
	private JPasswordField password;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setTitle("登入畫面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(44, 62, 80));
        panel.setBounds(0, 0, 540, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(101, 80, 87, 43);
		panel.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("新細明體", Font.BOLD, 13));
		username.setColumns(10);
		username.setBounds(191, 82, 186, 43);
		panel.add(username);
		
		JLabel lblNewLabel_1 = new JLabel("密碼:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 23));
		lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(101, 157, 87, 43);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=username.getText().trim();
				String Password=new String(password.getPassword()).trim();
				boolean checkchi;
                int chi;
				
				if (Username.isEmpty() || Password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "帳號或密碼不能為空", "錯誤", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
 
             
                for (int i = 0; i < Username.length(); i++) {
                    chi = (int) Username.charAt(i);
                    
                    checkchi = (chi >= 48 && chi <= 57) || 
                               (chi >= 65 && chi <= 90) || 
                               (chi >= 97 && chi <= 122);  
                    if (!checkchi) {
                        JOptionPane.showMessageDialog(null, "請輸入字母或數字", "錯誤", JOptionPane.ERROR_MESSAGE);
                        return;
                    } 
                }
				
				
				
				Member m=msi.login(Username, Password);
				
				if (m!=null) 
				{
					
					new ChoseUI(m).setVisible(true);
					dispose();
					
				}
				else {
					 JOptionPane.showMessageDialog(null, "帳號或密碼輸入錯誤!", "錯誤", JOptionPane.ERROR_MESSAGE);
                     return;
				}
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 18));
		btnNewButton.setBounds(119, 226, 150, 30);
		btnNewButton.setBackground(new Color(52, 73, 94));
		btnNewButton.setForeground(Color.WHITE);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=username.getText().trim();
				String Password=new String(password.getPassword()).trim();
				Member m=msi.login(Username, Password);
				
			new addMember().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 18));
		btnNewButton_1.setBounds(305, 226, 150, 30);
		btnNewButton_1.setBackground(new Color(52, 73, 94));
		btnNewButton_1.setForeground(Color.WHITE);
		
		panel.add(btnNewButton_1);
		
		password = new JPasswordField();
		password.setFont(new Font("新細明體", Font.BOLD, 13));
		password.setBounds(191, 154, 186, 43);
		panel.add(password);
	}
	
}
