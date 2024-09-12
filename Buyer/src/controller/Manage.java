package controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import model.Accountant;
import model.Invoice;
import model.Member;
import service.Impl.AccountantServiceImpl;
import service.Impl.InvoiceServiceImpl;
import service.Impl.SellerServiceImpl;
import util.DateCalculator;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;




public class Manage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField costName;
	private JTextField payType;
	private JTextField department;
	private JTextField productNumber;
	private JTextField item;
	private JTextField productName;
	private JTextField amount;
	private JTextField unit;
	private JTextField price;
	private JTextArea exchangeRate;
	private static AccountantServiceImpl asi=new AccountantServiceImpl();
	private static InvoiceServiceImpl isi=new InvoiceServiceImpl();
	private static SellerServiceImpl ssi=new SellerServiceImpl();
	private JTextField invoice;
	private static DateCalculator dc=new DateCalculator();
	private JTextField payDate;
	private JTable table;
	private DefaultTableModel tableModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage frame = new Manage();
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
	
	public Manage() {}
	public Manage(Member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 829);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 contentPane.setBackground(new Color(240, 248, 255)); // 淡藍色背景
		 
		  // 設定標籤樣式
	        Font labelFont = new Font("Microsoft YaHei", Font.BOLD, 18);
	        Color labelColor = new Color(70, 130, 180); // 淡藍色
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder()); // 雕刻边框
		panel.setBounds(9, 0, 1112, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		 panel.setBackground(new Color(240, 248, 255));
		 
		
		JLabel lblNewLabel = new JLabel("請購人員:");
		lblNewLabel.setFont(labelFont);
		lblNewLabel.setForeground(labelColor);
		lblNewLabel.setBounds(46, 29, 106, 30);
		panel.add(lblNewLabel);
		
		JTextArea pRBuyer = new JTextArea();
		pRBuyer.setEditable(false);
		pRBuyer.setBounds(143, 30, 144, 30);
		panel.add(pRBuyer);
		
		JLabel lblNewLabel_1 = new JLabel("請款廠商:");
		 lblNewLabel_1.setFont(labelFont);
	     lblNewLabel_1.setForeground(labelColor);
	     lblNewLabel_1.setBounds(322, 29, 106, 30);
		panel.add(lblNewLabel_1);
		
		JTextArea invoiceCompany = new JTextArea();
		invoiceCompany.setEditable(false);
		 invoiceCompany.setBounds(419, 30, 144, 30);
		panel.add(invoiceCompany);
		
		JLabel lblNewLabel_1_1 = new JLabel("統一編號:");
		 lblNewLabel_1_1.setFont(labelFont);
	        lblNewLabel_1_1.setForeground(labelColor);
	        lblNewLabel_1_1.setBounds(322, 75, 106, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("請購部門:");
		lblNewLabel_2.setFont(labelFont);
        lblNewLabel_2.setForeground(labelColor);
        lblNewLabel_2.setBounds(46, 75, 106, 30);
		panel.add(lblNewLabel_2);
		
		department = new JTextField();
		department.setEditable(false);
		department.setColumns(10);
        department.setBounds(143, 75, 144, 30);
		panel.add(department);
		
		JLabel lblNewLabel_9_1 = new JLabel("發票號碼:");
		lblNewLabel_9_1.setForeground(new Color(70, 130, 180));
		lblNewLabel_9_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel_9_1.setBounds(649, 29, 106, 30);
		panel.add(lblNewLabel_9_1);
		
		invoice = new JTextField();
		invoice.setColumns(10);
		invoice.setBounds(746, 29, 144, 30);
		panel.add(invoice);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(9, 184, 344, 341);
		panel_1.setBorder(new EtchedBorder()); // 雕刻边框
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 248, 255));
		
		JLabel lblNewLabel_3 = new JLabel("帳款類別:");
		lblNewLabel_3.setFont(labelFont);
	    lblNewLabel_3.setForeground(labelColor);
	    lblNewLabel_3.setBounds(10, 10, 106, 30);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("類別名稱:");
		lblNewLabel_4.setFont(labelFont);
	    lblNewLabel_4.setForeground(labelColor);
	    lblNewLabel_4.setBounds(10, 55, 106, 30);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("幣別:");
		lblNewLabel_5.setFont(labelFont);
        lblNewLabel_5.setForeground(labelColor);
        lblNewLabel_5.setBounds(10, 100, 106, 30);
		panel_1.add(lblNewLabel_5);
		
		JTextArea currency = new JTextArea();
		currency.setEditable(false);
		currency.setBounds(107, 100, 144, 30);
		panel_1.add(currency);
		
		JLabel lblNewLabel_6 = new JLabel("匯率:");
		lblNewLabel_6.setFont(labelFont);
        lblNewLabel_6.setForeground(labelColor);
        lblNewLabel_6.setBounds(10, 145, 106, 30);
		panel_1.add(lblNewLabel_6);
		
		exchangeRate = new JTextArea();
		exchangeRate.setEditable(false);
		exchangeRate.setBounds(107, 145, 144, 30);
		panel_1.add(exchangeRate);
		
		JLabel lblNewLabel_7 = new JLabel("稅別:");
		lblNewLabel_7.setFont(labelFont);
        lblNewLabel_7.setForeground(labelColor);
        lblNewLabel_7.setBounds(10, 190, 106, 30);
		panel_1.add(lblNewLabel_7);
		
		JTextArea taxType = new JTextArea();
		taxType.setEditable(false);
		taxType.setBounds(107, 190, 144, 30);
		panel_1.add(taxType);
		
		JLabel lblNewLabel_8 = new JLabel("稅率:");
		 lblNewLabel_8.setFont(labelFont);
	     lblNewLabel_8.setForeground(labelColor);
	     lblNewLabel_8.setBounds(10, 235, 106, 30);
		panel_1.add(lblNewLabel_8);
		
		JTextArea taxRate = new JTextArea();
		taxRate.setEditable(false);
		taxRate.setBounds(107, 235, 144, 30);
		panel_1.add(taxRate);
		
		JLabel lblNewLabel_9 = new JLabel("發票號碼:");
		lblNewLabel_9.setFont(labelFont);
        lblNewLabel_9.setForeground(labelColor);
        lblNewLabel_9.setBounds(10, 275, 106, 30);
		panel_1.add(lblNewLabel_9);
		
		costName = new JTextField();
		
		
		JComboBox costType = new JComboBox();
		costType.setEnabled(false);
		costType.setFont(new Font("新細明體", Font.BOLD, 12));
		costType.setModel(new DefaultComboBoxModel(new String[] {"雜項費用", "維修費用", "設備費用", "代客付費"}));
		costType.setBounds(107, 14, 144, 30);
		panel_1.add(costType);
		
		JTextArea invoiceoutput = new JTextArea();
		invoiceoutput.setEditable(false);
		invoiceoutput.setBounds(107, 275, 144, 30);
		panel_1.add(invoiceoutput);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(363, 184, 379, 341);
		panel_1_1.setBorder(new EtchedBorder()); // 雕刻边框
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(240, 248, 255));
		
		JLabel lblNewLabel_3_1 = new JLabel("付款方式:");
		lblNewLabel_3_1.setFont(labelFont);
		lblNewLabel_3_1.setForeground(labelColor);
		lblNewLabel_3_1.setBounds(10, 10, 106, 30);
		panel_1_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("類別:");
		lblNewLabel_4_1.setFont(labelFont);
		lblNewLabel_4_1.setForeground(labelColor);
		lblNewLabel_4_1.setBounds(10, 55, 106, 30);
		panel_1_1.add(lblNewLabel_4_1);
		
		payType = new JTextField();
		
		JLabel lblNewLabel_5_1 = new JLabel("應付款日:");
		lblNewLabel_5_1.setFont(labelFont);
		lblNewLabel_5_1.setForeground(labelColor);
		lblNewLabel_5_1.setBounds(10, 100, 106, 30);
		panel_1_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("允許票別:");
		lblNewLabel_6_1.setFont(labelFont);
		lblNewLabel_6_1.setForeground(labelColor);
		lblNewLabel_6_1.setBounds(10, 145, 106, 30);
		panel_1_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("票到期日:");
		lblNewLabel_7_1.setFont(labelFont);
		lblNewLabel_7_1.setForeground(labelColor);
		lblNewLabel_7_1.setBounds(10, 190, 106, 30);
		panel_1_1.add(lblNewLabel_7_1);
		
		JTextArea payExpireDate = new JTextArea();
		
		payExpireDate.setFont(new Font("新細明體", Font.BOLD, 12));
		payExpireDate.setEditable(false);
		payExpireDate.setBounds(107, 190, 144, 30);
		panel_1_1.add(payExpireDate);
		
		JLabel lblNewLabel_8_1 = new JLabel("付款處理:");
		lblNewLabel_8_1.setFont(labelFont);
		lblNewLabel_8_1.setForeground(labelColor);
		lblNewLabel_8_1.setBounds(10, 235, 106, 30);
		panel_1_1.add(lblNewLabel_8_1);
		
		JTextArea payState = new JTextArea();
		payState.setEditable(false);
		payState.setBounds(107, 235, 144, 30);
		panel_1_1.add(payState);
		
		JComboBox payWay = new JComboBox();
		payWay.setEnabled(false);
		payWay.setFont(new Font("新細明體", Font.BOLD, 12));
		payWay.setModel(new DefaultComboBoxModel(new String[] {"當月結30天", "當月結60天", "次月結30天", "次月結60天", "次月結90天", "TT"}));
		payWay.setBounds(107, 14, 144, 30);
		panel_1_1.add(payWay);
		
		JComboBox paymentType = new JComboBox();
		paymentType.setEnabled(false);
		paymentType.setFont(new Font("新細明體", Font.BOLD, 12));
		paymentType.setModel(new DefaultComboBoxModel(new String[] {"現金", "支票", "本票"}));
		paymentType.setBounds(107, 145, 144, 30);
		panel_1_1.add(paymentType);
		
		payDate = new JTextField();
		
		payDate.setFont(new Font("新細明體", Font.BOLD, 12));
		payDate.setEditable(false);
		payDate.setColumns(10);
		payDate.setBounds(107, 100, 144, 30);
		panel_1_1.add(payDate);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(752, 184, 369, 341);
		panel_1_2.setBorder(new EtchedBorder()); // 雕刻边框
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(240, 248, 255));
		
		JLabel lblNewLabel_3_2 = new JLabel("本幣:");
		lblNewLabel_3_2.setFont(labelFont);
		lblNewLabel_3_2.setForeground(labelColor);
		lblNewLabel_3_2.setBounds(10, 10, 106, 30);
		panel_1_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("稅額:");
		lblNewLabel_4_2.setFont(labelFont);
		lblNewLabel_4_2.setForeground(labelColor);
		lblNewLabel_4_2.setBounds(10, 55, 106, 30);
		panel_1_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("合計:");
		lblNewLabel_5_2.setFont(labelFont);
		lblNewLabel_5_2.setForeground(labelColor);
		lblNewLabel_5_2.setBounds(10, 100, 106, 30);
		panel_1_2.add(lblNewLabel_5_2);
		
		JTextArea sum = new JTextArea();
		sum.setEditable(false);
		sum.setBounds(107, 100, 144, 30);
		panel_1_2.add(sum);
		
		JLabel lblNewLabel_6_2 = new JLabel("已付:");
		lblNewLabel_6_2.setFont(labelFont);
		lblNewLabel_6_2.setForeground(labelColor);
		lblNewLabel_6_2.setBounds(10, 145, 106, 30);
		panel_1_2.add(lblNewLabel_6_2);
		
		JTextArea paid = new JTextArea();
		paid.setEditable(false);
		paid.setBounds(107, 145, 144, 30);
		panel_1_2.add(paid);
		
		JLabel lblNewLabel_7_2 = new JLabel("未付:");
		lblNewLabel_7_2.setFont(labelFont);
		lblNewLabel_7_2.setForeground(labelColor);
		lblNewLabel_7_2.setBounds(10, 190, 106, 30);
		panel_1_2.add(lblNewLabel_7_2);
		
		JTextArea nonPayment = new JTextArea();
		nonPayment.setEditable(false);
		nonPayment.setBounds(107, 190, 144, 30);
		panel_1_2.add(nonPayment);
		
		JTextArea tax = new JTextArea();
		tax.setEditable(false);
		tax.setBounds(107, 55, 144, 30);
		panel_1_2.add(tax);
		
		JTextArea useCurrency = new JTextArea();
		useCurrency.setEditable(false);
		useCurrency.setBounds(107, 14, 144, 30);
		panel_1_2.add(useCurrency);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 545, 705, 235);
		panel_2.setBorder(new EtchedBorder()); // 雕刻边框
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 248, 255));
		
		JLabel lblNewLabel_3_3 = new JLabel("項次");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(labelFont);
		lblNewLabel_3_3.setForeground(labelColor);
		lblNewLabel_3_3.setBounds(6, 2, 61, 38);
		lblNewLabel_3_3.setBorder(new LineBorder(Color.GRAY, 1)); // 黑色边框，宽度为 2 像素
		panel_2.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4_2 = new JLabel("產品編號");
		lblNewLabel_3_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_2.setFont(labelFont);
		lblNewLabel_3_4_2.setForeground(labelColor);
		lblNewLabel_3_4_2.setBounds(66, 2, 127, 38);
		lblNewLabel_3_4_2.setBorder(new LineBorder(Color.GRAY, 1)); // 黑色边框，宽度为 2 像素
		panel_2.add(lblNewLabel_3_4_2);
		
		productNumber = new JTextField();
		productNumber.setEditable(false);
		productNumber.setColumns(10);
		productNumber.setBounds(66, 39, 128, 28);
		panel_2.add(productNumber);
		
		item = new JTextField();
		
		
		item.setHorizontalAlignment(SwingConstants.CENTER);
		item.setEditable(false);
		item.setColumns(10);
		item.setBounds(6, 39, 62, 28);
		panel_2.add(item);
		
		JLabel lblNewLabel_3_4_2_1 = new JLabel("產品名稱");
		lblNewLabel_3_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_2_1.setForeground(new Color(70, 130, 180));
		lblNewLabel_3_4_2_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel_3_4_2_1.setBorder(new LineBorder(Color.GRAY, 1));
		lblNewLabel_3_4_2_1.setBounds(192, 2, 127, 38);
		panel_2.add(lblNewLabel_3_4_2_1);
		
		productName = new JTextField();
		productName.setEditable(false);
		productName.setColumns(10);
		productName.setBounds(192, 39, 128, 28);
		panel_2.add(productName);
		
		JLabel lblNewLabel_3_4_2_2 = new JLabel("數量");
		lblNewLabel_3_4_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_2_2.setForeground(new Color(70, 130, 180));
		lblNewLabel_3_4_2_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel_3_4_2_2.setBorder(new LineBorder(Color.GRAY, 1));
		lblNewLabel_3_4_2_2.setBounds(318, 2, 127, 38);
		panel_2.add(lblNewLabel_3_4_2_2);
		
		amount = new JTextField();
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		amount.setEditable(false);
		amount.setColumns(10);
		amount.setBounds(318, 39, 128, 28);
		panel_2.add(amount);
		
		JLabel lblNewLabel_3_4_2_1_1 = new JLabel("單位");
		lblNewLabel_3_4_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_2_1_1.setForeground(new Color(70, 130, 180));
		lblNewLabel_3_4_2_1_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel_3_4_2_1_1.setBorder(new LineBorder(Color.GRAY, 1));
		lblNewLabel_3_4_2_1_1.setBounds(444, 2, 127, 38);
		panel_2.add(lblNewLabel_3_4_2_1_1);
		
		unit = new JTextField();
		unit.setHorizontalAlignment(SwingConstants.CENTER);
		unit.setEditable(false);
		unit.setColumns(10);
		unit.setBounds(444, 39, 128, 28);
		panel_2.add(unit);
		
		JLabel lblNewLabel_3_4_2_1_1_1 = new JLabel("單價");
		lblNewLabel_3_4_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_2_1_1_1.setForeground(new Color(70, 130, 180));
		lblNewLabel_3_4_2_1_1_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel_3_4_2_1_1_1.setBorder(new LineBorder(Color.GRAY, 1));
		lblNewLabel_3_4_2_1_1_1.setBounds(570, 2, 127, 38);
		panel_2.add(lblNewLabel_3_4_2_1_1_1);
		
		price = new JTextField();
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(570, 39, 128, 28);
		panel_2.add(price);
		
		JTextArea companyNumber = new JTextArea();
		companyNumber.setEditable(false);
		companyNumber.setBounds(419, 75, 144, 30);
		panel.add(companyNumber);
		
		// 在 panel_2 添加 JTable
		
		panel_2.setBounds(10, 545, 705, 235);
		panel_2.setBorder(new EtchedBorder()); // 雕刻边框
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 248, 255));

		// 設定 JTable 和 DefaultTableModel
		String[] columnNames = {"項次", "產品編號", "產品名稱", "數量", "單位", "單價"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 93, 691, 132);
		panel_2.add(scrollPane);

		// 添加时间标签并启动定时器
        JLabel lblNewLabel_10 = new JLabel("");
        lblNewLabel_10.setFont(new Font("新細明體", Font.BOLD, 19));
        lblNewLabel_10.setBounds(973, 749, 127, 31);
        contentPane.add(lblNewLabel_10);
     // 设置定时器以每秒更新一次 JLabel
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.updateLabelWithTime(lblNewLabel_10);
            }
        });
        timer.start();
        

  
		
		
		
		/*=====================================================================================*/
		JButton Exit = new JButton("退出系統");
		JButton searchAccount = new JButton("查詢帳款");
		JButton renewAccount = new JButton("更新帳款");
		JButton delete = new JButton("作廢帳款");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   //刪除帳款
				String Invoice=invoice.getText();
				asi.DeleteByInvoice(Invoice);
				JOptionPane.showMessageDialog(null,"該帳款已刪除!","通知",JOptionPane.WARNING_MESSAGE);
					invoice.setText("");
					pRBuyer.setText("");
					department.setText("");
					invoiceCompany.setText("");
					companyNumber.setText("");
					
					costType.setSelectedItem("");
					costName.setText("");
					currency.setText("");
					exchangeRate.setText("");
					taxType.setText("");
					taxRate.setText("");
					invoiceoutput.setText("");
					
					
					payType.setText("");
					payDate.setText("");
					
					payExpireDate.setText("");
					payState.setText("");
					
					useCurrency.setText("");
					tax.setText("");
					sum.setText("");
					paid.setText("");
					nonPayment.setText("");
					
					item.setText("");	      
					productNumber .setText(""); 
					productName.setText("");   
					amount.setText("");       
					unit.setText("");	           
					price.setText(""); 
					tableModel.setRowCount(0);
					delete.setEnabled(false);
			}
		});
		renewAccount.setEnabled(false);
		JButton addAccount = new JButton("快速建立帳款");
		
		searchAccount.addActionListener(new ActionListener() {   					//查詢帳款
			public void actionPerformed(ActionEvent e) {
			
				if(invoice.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null,"請填寫發票號碼!","警告",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
				if(!isi.checkInvoice(invoice.getText())) {
        			JOptionPane.showMessageDialog(null,"發票號碼不存在，請重新確認!","警告",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
				
				String Invoice=invoice.getText().trim();
				List<Accountant> l=new ArrayList();
				boolean x=asi.checkInvoice(Invoice);
				if(!x) 
				{
					JOptionPane.showMessageDialog(null,"該發票號碼尚未建立帳款，請先建立帳款!","警告",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
				else 
				{	delete.setEnabled(true);
					addAccount.setEnabled(false);
					renewAccount.setEnabled(true);
					l=asi.selectByInvoice(Invoice);
					// 清空表格中的資料
					tableModel.setRowCount(0);
					
					for(Accountant o:l) 
					{
						pRBuyer.setText(o.getPRBuyer());
						department.setText(o.getDepartment());
						invoiceCompany.setText(o.getInvoiceCompany());
						companyNumber.setText(o.getCompanyNumber());
						
						costType.setSelectedItem(o.getCostType());
						costName.setText(o.getCostName());
						currency.setText(o.getCurrency());
						exchangeRate.setText(String.valueOf(o.getExchangeRate()));
						taxType.setText(o.getTaxType());
						taxRate.setText(String.valueOf(o.getTaxRate()));
						invoiceoutput.setText(o.getInvoice());
						
						payWay.setSelectedItem(o.getPayWay());
						payType.setText(o.getPayType());
						payDate.setText(o.getPayDate());
						paymentType.setSelectedItem(o.getPaymentType());
						payExpireDate.setText(o.getPayExpireDate());
						payState.setText(o.getPayState());
						
						useCurrency.setText((o.getUseCurrency()).toString());
						tax.setText(o.getTax().toString());
						sum.setText(o.getSum().toString());
						paid.setText(o.getPaid().toString());
						nonPayment.setText(o.getNonpayment().toString());
						
						// 新增帳款資料到 JTable
						tableModel.addRow(new Object[]{
							o.getItem(),
							o.getProductNumber(),
							o.getProductName(),
							o.getAmount(),
							o.getUnit(),
							o.getPrice()
						});
						
						
					}
				}
				
				
			}
		});
		
		renewAccount.addActionListener(new ActionListener() {                //更新帳款
			public void actionPerformed(ActionEvent e) {
				Exit.setText("新增結束");
				
				boolean checkout=false;
				boolean isConfirming = "確認".equals(renewAccount.getText());
				
				if (!isConfirming) {
				delete.setEnabled(false);
				searchAccount.setEnabled(false);
				renewAccount.setText("確認");
				invoice.setEditable(false);
				department.setEditable(true);
				costType.setEnabled(true);
				costName.setEditable(true);
				payWay.setEnabled(true);
				payType.setEditable(true);
				payDate.setEditable(true);
				paymentType.setEnabled(true);
				payExpireDate.setEditable(true);
				item.setEditable(true);
				productNumber.setEditable(true);
				productName.setEditable(true);
				amount.setEditable(true);
				unit.setEditable(true);
				price.setEditable(true);
				}
				
				else
				{	
					try {
					/*不會動到*/
					String PRBuyer=pRBuyer.getText().trim();
					String InvoiceCompany=invoiceCompany.getText().trim();
					String CompanyNumber=companyNumber.getText().trim();
					String Currency=currency.getText().trim();
					Double ExchangeRate=Double.parseDouble(exchangeRate.getText().trim());
					String TaxType=taxType.getText().trim(); 
					Double TaxRate=Double.parseDouble(taxRate.getText().trim());
					String Invoice=invoice.getText().trim();
					String PayState=payState.getText().trim();
					Integer UseCurrency=Integer.parseInt(useCurrency.getText().trim());
					Integer Tax=Integer.parseInt(tax.getText().trim());
					Integer Sum=Integer.parseInt(sum.getText().trim());
					Integer Paid=Integer.parseInt(paid.getText().trim());
					Integer NonPayment=Integer.parseInt(nonPayment.getText().trim());
					/*會動到*/
					String Department=department.getText().trim();
					String CostType=costType.getSelectedItem().toString();
					String CostName=costName.getText().trim();
					String PayWay=payWay.getSelectedItem().toString();
					String PayType=payType.getText().trim();
					String PayDate=payDate.getText().trim();
					String PaymentType=paymentType.getSelectedItem().toString();
					String PayExpireDate=payExpireDate.getText().trim();
					Integer Item=Integer.parseInt(item.getText().trim());
					String ProductNumber=productNumber.getText().trim();
					String ProductName=productName.getText().trim();
					Integer Amount=Integer.parseInt(amount.getText().trim());
					String Unit=unit.getText().trim();
					Integer Price=Integer.parseInt(price.getText().trim());
					
					
					/*=================宣告Account物件變數===================*/
					Accountant a=new Accountant(PRBuyer,Department,InvoiceCompany,CompanyNumber,
							CostType,CostName,Currency,ExchangeRate,TaxType,TaxRate,Invoice,
							PayWay,PayType,PayDate,PaymentType,PayExpireDate,PayState,
							UseCurrency,Tax,Sum,Paid,NonPayment,
							Item,ProductNumber,ProductName,Amount,Unit,Price);
					
					
					
					List<Accountant> l= new ArrayList();
					l=asi.selectByInvoice(Invoice);
					
					List<Accountant> l2= new ArrayList();
					l2=asi.selectByInvoiceForProduct(Invoice, Item);
					
					List<Accountant> l3= new ArrayList();
					
					
					boolean hasChanges = false;
					boolean haveToChange=false;
					
					for (Accountant o :l2) 
					{
						if (!ProductNumber.equals(o.getProductNumber())) {
					        a.setProductNumber(ProductNumber);
					        hasChanges = true;
					        System.out.println("ProductNumber: " + ProductNumber);
					    }
					    if (!ProductName.equals(o.getProductName())) {
					        a.setProductName(ProductName);
					        hasChanges = true;
					        System.out.println("ProductName: " + ProductName);
					    }
					    if (!Amount.equals(o.getAmount())) {
					        a.setAmount(Amount);
					        hasChanges = true;
					        System.out.println("Amount: " + Amount);
					    }
					    if (!Unit.equals(o.getUnit())) {
					        a.setUnit(Unit);
					        hasChanges = true;
					        System.out.println("Unit: " + Unit);
					    }
					    if (!Price.equals(o.getPrice())) {
					        a.setPrice(Price);
					        hasChanges = true;
					        System.out.println("Price: " + Price);
					    } 
					}
					
					for(int i=1;i<=l.size();i++) {
						l3=asi.selectByInvoiceForProduct(Invoice, i);
						Accountant ao=l3.get(0);
						System.out.println(i);
							if(!Department.equals(ao.getDepartment()))
							{
								haveToChange =true;
								ao.setDepartment(Department);
								asi.UpdateAccountByInvoiceAndItem(ao);
							}
							
							if(!CostType.equals(ao.getCostType()))
							{
								haveToChange =true;
								ao.setCostType(CostType);
								asi.UpdateAccountByInvoiceAndItem(ao);
							}
							if(!CostName.equals(ao.getCostName()))
							{
								haveToChange =true;
								ao.setCostName(CostName);
								asi.UpdateAccountByInvoiceAndItem(ao);
							}
							if(!PayWay.equals(ao.getPayWay()))
							{	
								haveToChange =true;
								ao.getPayWay();
								asi.UpdateAccountByInvoiceAndItem(ao);
							}
							if(!PayType.equals(ao.getPayType()))
							{	
								haveToChange =true;
								ao.getPayType();
								asi.UpdateAccountByInvoiceAndItem(ao);
							}
							if(!PayDate.equals(ao.getPayDate()))
							{									
								haveToChange =true;
								ao.getPayDate();
								asi.UpdateAccountByInvoiceAndItem(ao);
							}
							if(!PaymentType.equals(ao.getPaymentType()))
							{	
								haveToChange =true;
								ao.getPaymentType();
								asi.UpdateAccountByInvoiceAndItem(ao);
							}
							if(!PayExpireDate.equals(ao.getPayExpireDate()))
							{	
								haveToChange =true;
								ao.getPayExpireDate();
								asi.UpdateAccountByInvoiceAndItem(ao);
							}
							}
					
					
					System.out.println("haveToChange:\t"+haveToChange);
					System.out.println("hasChanges:\t"+hasChanges);
					
					
					
					
					 if (!hasChanges&&!haveToChange) 
					 {
	                        // 自定義按鈕選項
	                        Object[] options = {"繼續", "離開"};

	                        // 顯示對話框
	                        int result = JOptionPane.showOptionDialog(
	                                null,
	                                "資料沒有發現更動\n請問是否要繼續更新呢?",
	                                "通知",
	                                JOptionPane.YES_NO_OPTION,
	                                JOptionPane.WARNING_MESSAGE,
	                                null,
	                                options,
	                                options[0]
	                        );
	                        
	                        if (result == JOptionPane.NO_OPTION) 
	                        {
	                        	renewAccount.setText("更新帳款");
	                        	searchAccount.setEnabled(true);
	                        	addAccount.setEnabled(true);
	                        	renewAccount.setEnabled(false);
	            				invoice.setEditable(true);
	            				department.setEditable(false);
	            				costType.setEnabled(false);
	            				costName.setEditable(false);
	            				payWay.setEnabled(false);
	            				payType.setEditable(false);
	            				payDate.setEditable(false);
	            				paymentType.setEnabled(false);
	            				payExpireDate.setEditable(false);
	            				item.setEditable(false);
	            				productNumber.setEditable(false);
	            				productName.setEditable(false);
	            				amount.setEditable(false);
	            				unit.setEditable(false);
	            				price.setEditable(false);
	            				
	            				//資料消除區
	        					
	        					invoice.setText("");
	        					pRBuyer.setText("");
	        					department.setText("");
	        					invoiceCompany.setText("");
	        					companyNumber.setText("");
	        					
	        					costType.setSelectedItem("");
	        					costName.setText("");
	        					currency.setText("");
	        					exchangeRate.setText("");
	        					taxType.setText("");
	        					taxRate.setText("");
	        					invoiceoutput.setText("");
	        					
	        					
	        					payType.setText("");
	        					payDate.setText("");
	        					
	        					payExpireDate.setText("");
	        					payState.setText("");
	        					
	        					useCurrency.setText("");
	        					tax.setText("");
	        					sum.setText("");
	        					paid.setText("");
	        					nonPayment.setText("");
	        					
	        					item.setText("");	      
	        					productNumber .setText(""); 
	        					productName.setText("");   
	        					amount.setText("");       
	        					unit.setText("");	           
	        					price.setText(""); 
	                        	
	        					tableModel.setRowCount(0);
	                       		Exit.setText("退出系統");
	            				
	            				
	            				
	                        }}
					 		else if(haveToChange&&!hasChanges)
					 		{
					 			JOptionPane.showMessageDialog(null, "更新成功!", "通知", JOptionPane.INFORMATION_MESSAGE);
					 			checkout=true;		
					 				
					 		}
					 		
					 		else if(!haveToChange && hasChanges)	
				 			{	
					 			JOptionPane.showMessageDialog(null, "更新成功!", "通知", JOptionPane.INFORMATION_MESSAGE);
					 			asi.UpdateAccountByInvoiceAndItemForProduct(a);
					 			checkout=true;	
					 		}	
					 		else if(haveToChange && hasChanges)
					 		{
					 			JOptionPane.showMessageDialog(null, "更新成功!", "通知", JOptionPane.INFORMATION_MESSAGE);
					 			asi.UpdateAccountByInvoiceAndItemForProduct(a);
					 			
					 			checkout=true;
					 			
					 			
					 		}	
					 			
					 			
					 			
					 		 } catch (NumberFormatException ex) {
					                JOptionPane.showMessageDialog(null, "請確認數值欄位輸入正確！", "錯誤", JOptionPane.ERROR_MESSAGE);
					                return;
					            } catch (Exception ex) {
					                JOptionPane.showMessageDialog(null, "發生錯誤: " + ex.getMessage(), "錯誤", JOptionPane.ERROR_MESSAGE);
					                return;
					            }
					 	}
				if(checkout) {			
					renewAccount.setText("更新帳款");
                	searchAccount.setEnabled(true);
                	addAccount.setEnabled(true);
                	renewAccount.setEnabled(false);
    				invoice.setEditable(true);
    				department.setEditable(false);
    				costType.setEnabled(false);
    				costName.setEditable(false);
    				payWay.setEnabled(false);
    				payType.setEditable(false);
    				payDate.setEditable(false);
    				paymentType.setEnabled(false);
    				payExpireDate.setEditable(false);
    				item.setEditable(false);
    				productNumber.setEditable(false);
    				productName.setEditable(false);
    				amount.setEditable(false);
    				unit.setEditable(false);
    				price.setEditable(false);
    				
    				//資料消除區
					
					invoice.setText("");
					pRBuyer.setText("");
					department.setText("");
					invoiceCompany.setText("");
					companyNumber.setText("");
					
					costType.setSelectedItem("");
					costName.setText("");
					currency.setText("");
					exchangeRate.setText("");
					taxType.setText("");
					taxRate.setText("");
					invoiceoutput.setText("");
					
					
					payType.setText("");
					payDate.setText("");
					
					payExpireDate.setText("");
					payState.setText("");
					
					useCurrency.setText("");
					tax.setText("");
					sum.setText("");
					paid.setText("");
					nonPayment.setText("");
					
					item.setText("");	      
					productNumber .setText(""); 
					productName.setText("");   
					amount.setText("");       
					unit.setText("");	           
					price.setText(""); 
                	
					tableModel.setRowCount(0);
               		Exit.setText("退出系統");
					}
}
			
			
			
		});
		
		
		
																				//建立帳款
		addAccount.setBounds(900, 75, 167, 38);
		panel.add(addAccount);
		addAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit.setText("取消建立");
				List<Invoice> invoiceL=new ArrayList();
				
				
				
				if (invoice.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "請填寫發票號碼!", "警告", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (!isi.checkInvoice(invoice.getText())) {
					JOptionPane.showMessageDialog(null, "發票號碼不存在，請重新確認!", "警告", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				
				boolean checkButtonEven=addAccount.getText().equals("建立完成"); 
				String Invoice=invoice.getText();
				invoiceL=isi.selectAllByInvoice(Invoice);
				if(!checkButtonEven)   
				{	
					addAccount.setText("建立完成");
					// 啟用相關欄位
					
					//panel1
					department.setEditable(true);					
					//panel2
					costType.setEnabled(true);
					//panel3
					payWay.setEnabled(true);
					paymentType.setEnabled(true);
					//panel5
					item.setEditable(true);   
					productNumber.setEditable(true); 	
					productName.setEditable(true);   		
					amount.setEditable(true);   
					unit.setEditable(true); 
					price.setEditable(true);
					
					//功能關閉
					searchAccount.setEnabled(false);
					invoice.setEditable(false);
					
					/*====================建立初始值=============================*/
														   //panel 1
					pRBuyer.setText(m.getName());
					
					for(Invoice o:invoiceL) 
					{
						invoiceCompany.setText(o.getCompanyShortName());
						companyNumber.setText(o.getCompanyNumber());
						
					}
					
															//panel 2
					String CostName=costName.getText();
					currency.setText("TWD");
					String Currency=currency.getText();
					exchangeRate.setText("1.0");
					Double ExchangeRate=Double.parseDouble(exchangeRate.getText());
					taxType.setText("應稅");
					String TaxType=taxType.getText();
					taxRate.setText("0.05");
					Double TaxRate=Double.parseDouble(taxRate.getText());
					invoiceoutput.setText(invoice.getText());
					
					
					for(Invoice o:invoiceL) {										//panel4
						useCurrency.setText(o.getMoney().toString());							
						int a_set = (int) Math.round(o.getMoney() * 0.05);
						tax.setText(String.valueOf(a_set));				
						sum.setText(o.getMoneyInTxt().toString());				
						paid.setText("0");
						nonPayment.setText(o.getMoneyInTxt().toString());
						}
					
					payState.setText("否");                    //panel3
					
					
				
				}
				
					
				try {
					if (checkButtonEven) {
						// 檢查是否有必填欄位未填寫
						if (department.getText().isEmpty() || productNumber.getText().isEmpty() || productName.getText().isEmpty() || amount.getText().isEmpty() || unit.getText().isEmpty() || price.getText().isEmpty()) {
							throw new Exception("請填寫所有必要欄位");
						}
				
				String PRBuyer=pRBuyer.getText();							//panel 1
				String Department=department.getText().trim();

				
				String InvoiceCompany=invoiceCompany.getText();
				String CompanyNumber=companyNumber.getText().trim();
				
				
																//panel 2
				String CostType=costType.getSelectedItem().toString();
				switch (CostType) 
				{
					case"雜項費用":
						costName.setText("K001");
						break;
						
					case"維修費用":
						costName.setText("K002");
						break;
					case"設備費用":
						costName.setText("K003");
						break;
					case"代客付費":
						costName.setText("K004");
						break;
				}
				String CostName=costName.getText();
				String Currency=currency.getText();
				Double ExchangeRate=Double.parseDouble(exchangeRate.getText());
				String TaxType=taxType.getText();
				Double TaxRate=Double.parseDouble(taxRate.getText());
				
				
				
				
				
																//panel 3
				String PayWay=payWay.getSelectedItem().toString();
				String PayType=null;
				String PayExpireDate=null;
				String PayDate=null;
				
				
				String getdate=null;
				for (Invoice o:invoiceL) {getdate=o.getInvoiceDate();}
				switch(PayWay) 
				{
					case "當月結30天":
						payType.setText("A001");
						PayType=payType.getText();
						
						payDate.setText(dc.calculatePaymentDate(getdate, PayType));
						PayDate=payDate.getText();
						payExpireDate.setText(PayDate);
						
						break;
						
					case "當月結60天":
						payType.setText("A002");
						PayType=payType.getText();
						payDate.setText(dc.calculatePaymentDate(getdate, PayType));
						
						
						break;
					case "次月結30天":
						payType.setText("A003");
						PayType=payType.getText();
						payDate.setText(dc.calculatePaymentDate(getdate, PayType));
						
						
						break;
					case "次月結60天":
						payType.setText("A004");
						PayType=payType.getText();
						payDate.setText(dc.calculatePaymentDate(getdate, PayType));
						
						
						break;
					case "次月結90天":
						payType.setText("A005");
						PayType=payType.getText();
						payDate.setText(dc.calculatePaymentDate(getdate, PayType));
						
						
						break;
					case "TT":
						payType.setText("A006");
						PayType=payType.getText();
						payDate.setText("");
						payExpireDate.setText("");
						payDate.setEditable(true);
						payExpireDate.setEditable(true);
						
						break;
					
				}
				
				PayDate=payDate.getText();
				PayExpireDate=payExpireDate.getText();
				String PaymentType=paymentType.getSelectedItem().toString();
				payExpireDate.setText(PayDate);
				String PayState=payState.getText();
				
				
				
				
																				//panel4						
				Integer UseCurrency=Integer.parseInt(useCurrency.getText());
				Integer Tax=Integer.parseInt(tax.getText());
				Integer Sum=Integer.parseInt(sum.getText());
				Integer Paid=Integer.parseInt(paid.getText());													
				Integer NonPayment=Integer.parseInt(nonPayment.getText());				
				
				
				
																				//panel5
				List<Accountant> AccountantL=new ArrayList();
				AccountantL=asi.selectByInvoice(invoice.getText());
				
				item.setText((String.valueOf( AccountantL.size()+1)));
				
				Integer Item=Integer.parseInt(item.getText());
				String ProductNumber=productNumber.getText();
				String ProductName=productName.getText();
				Integer Amount=Integer.parseInt(amount.getText());
				String Unit=unit.getText();
				Integer Price=Integer.parseInt(price.getText());
				
				
				
				
					
				
				
				
				
				/*=================宣告Account物件變數===================*/
				Accountant a=new Accountant(PRBuyer,Department,InvoiceCompany,CompanyNumber,
						CostType,CostName,Currency,ExchangeRate,TaxType,TaxRate,Invoice,
						PayWay,PayType,PayDate,PaymentType,PayExpireDate,PayState,
						UseCurrency,Tax,Sum,Paid,NonPayment,
						Item,ProductNumber,ProductName,Amount,Unit,Price);
				
                
                	
                	JOptionPane.showMessageDialog(null, "帳款建立成功!", "通知", JOptionPane.INFORMATION_MESSAGE);
                	asi.addAccount(a);
                	
					}} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "數量或價格必須為數字格式", "錯誤", JOptionPane.ERROR_MESSAGE);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "錯誤", JOptionPane.ERROR_MESSAGE);
					}
                	
			}
			
                
				
				
				
				
				
				
				
			
		});
		addAccount.setFont(new Font("新細明體", Font.BOLD, 12)); 
		
		
		searchAccount.setFont(new Font("新細明體", Font.BOLD, 12));
		searchAccount.setBounds(900, 24, 167, 38);
		panel.add(searchAccount);
		
		
		renewAccount.setFont(new Font("新細明體", Font.BOLD, 12));
		renewAccount.setBounds(900, 123, 167, 38);
		panel.add(renewAccount);
		
		
		
		Exit.setFont(new Font("新細明體", Font.BOLD, 12));
		Exit.setBounds(836, 701, 167, 38);
		contentPane.add(Exit);
		
		
		
		costName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(addAccount.getText().equals("建立完成")||renewAccount.getText().equals("確認")) {
				String CostType=costType.getSelectedItem().toString();
				switch (CostType) 
				{
					case"雜項費用":
						costName.setText("K001");
						break;
						
					case"維修費用":
						costName.setText("K002");
						break;
					case"設備費用":
						costName.setText("K003");
						break;
					case"代客付費":
						costName.setText("K004");
						break;
				}}
				
				
				
			}
		});
		costName.setEditable(false);
		costName.setColumns(10);
		costName.setBounds(107, 55, 144, 30);
		panel_1.add(costName);
		
		payType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(addAccount.getText().equals("建立完成")||renewAccount.getText().equals("確認")) {
				String Invoice=invoice.getText();
				List<Invoice> invoiceL2=new ArrayList();
				invoiceL2=isi.selectAllByInvoice(Invoice);

				String PayWay=payWay.getSelectedItem().toString();
								String PayType=null;
								String PayExpireDate=null;
								String PayDate=null;
								
								
								String getdate=null;
								for (Invoice o:invoiceL2) {getdate=o.getInvoiceDate();}
								switch(PayWay) 
								{
									case "當月結30天":
										payType.setText("A001");
									
										
										break;
										
									case "當月結60天":
										payType.setText("A002");
										
										
										
										break;
									case "次月結30天":
										payType.setText("A003");
									
										
										
										break;
									case "次月結60天":
										payType.setText("A004");
										
										
										
										break;
									case "次月結90天":
										payType.setText("A005");
										
										
										
										break;
									case "TT":
										payType.setText("A006");
										
										payDate.setText("");
										payExpireDate.setText("");
										payDate.setEditable(true);
										payExpireDate.setEditable(true);
										
										break;
									
								}
				
				}
			}
		});
		payType.setEditable(false);
		payType.setColumns(10);
		payType.setBounds(107, 55, 144, 30);
		panel_1_1.add(payType);
		
		
		delete.setEnabled(false);
		delete.setFont(new Font("新細明體", Font.BOLD, 12));
		delete.setBounds(836, 633, 167, 38);
		contentPane.add(delete);
		
	
		
		payDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(addAccount.getText().equals("建立完成")||renewAccount.getText().equals("確認")) {
					String Invoice=invoice.getText();
					List<Invoice> invoiceL2=new ArrayList();
					invoiceL2=isi.selectAllByInvoice(Invoice);

				String PayWay=payWay.getSelectedItem().toString();
								String PayType=null;
								String PayExpireDate=null;
								String PayDate=null;
								
								
								String getdate=null;
								for (Invoice o:invoiceL2) {getdate=o.getInvoiceDate();}
								switch(PayWay) 
								{
									case "當月結30天":
										
										PayType=payType.getText();
										
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										
										
										
										break;
										
									case "當月結60天":
										
										PayType=payType.getText();
										
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										
										
										break;
									case "次月結30天":
										
										PayType=payType.getText();
										
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										
										
										break;
									case "次月結60天":
										
										PayType=payType.getText();
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										
										
										break;
									case "次月結90天":
										
										PayType=payType.getText();
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										
										
										break;
									case "TT":
										
										
										payDate.setText("");
										payExpireDate.setText("");
										payDate.setEditable(true);
										payExpireDate.setEditable(true);
										
										break;}}}});
		
		payExpireDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(addAccount.getText().equals("建立完成")||renewAccount.getText().equals("確認")) {
					String Invoice=invoice.getText();
					List<Invoice> invoiceL2=new ArrayList();
					invoiceL2=isi.selectAllByInvoice(Invoice);

				String PayWay=payWay.getSelectedItem().toString();
								String PayType=null;
								String PayExpireDate=null;
								String PayDate=null;
								
								
								String getdate=null;
								for (Invoice o:invoiceL2) {getdate=o.getInvoiceDate();}
								switch(PayWay) 
								{
									case "當月結30天":
										
										PayType=payType.getText();
										
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										PayDate=payDate.getText();
										payExpireDate.setText(PayDate);
										
										
										break;
										
									case "當月結60天":
										
										PayType=payType.getText();
										
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										PayDate=payDate.getText();
										payExpireDate.setText(PayDate);
										
										break;
									case "次月結30天":
										
										PayType=payType.getText();
										
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										PayDate=payDate.getText();
										payExpireDate.setText(PayDate);
										
										break;
									case "次月結60天":
										
										PayType=payType.getText();
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										PayDate=payDate.getText();
										payExpireDate.setText(PayDate);
										
										break;
									case "次月結90天":
										
										PayType=payType.getText();
										payDate.setText(dc.calculatePaymentDate(getdate, PayType));
										PayDate=payDate.getText();
										payExpireDate.setText(PayDate);
										
										break;
									case "TT":
										
										
										payDate.setText("");
										payExpireDate.setText("");
										payDate.setEditable(true);
										payExpireDate.setEditable(true);
										
										break;}}
				
				
			}
		});
		
		item.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(addAccount.getText().equals("建立完成")) 
				{	
					List<Accountant> AccountantL=new ArrayList();
					AccountantL=asi.selectByInvoice(invoice.getText());
					
					item.setText((String.valueOf( AccountantL.size()+1)));
				}
				
					
					
				
				
			}
		});
		
		item.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(renewAccount.getText().equals("確認")) 
				{	
					List<Accountant> AccountantL=new ArrayList();
					AccountantL=asi.selectByInvoice(invoice.getText());
					List<Accountant> l2= new ArrayList();
					l2=asi.selectByInvoiceForProduct(invoice.getText(), Integer.parseInt(item.getText()));
					
					
					for(Accountant o:l2) 
					{
						
						
							if(o.getItem()==Integer.parseInt(item.getText())) 
							{
								productNumber.setText(o.getProductNumber());
								productName.setText(o.getProductName());
								amount.setText(o.getAmount().toString());
								unit.setText(o.getUnit());
								price.setText(o.getPrice().toString());
								
							
						}
					}
					
				}
				
				
			}
		});
		
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=-1;
				
				if(addAccount.getText().equals("建立完成")) {
        			
        			
        			// 自定义按钮的选项
                   Object[] options = {"繼續建立", "取消建立"};
                   
                   // 显示带有自定义按钮的对话框
                   result=JOptionPane.showOptionDialog(
                           null,
                           "是否確定要取消建立呢?\n",
                           "警告",
                           JOptionPane.YES_NO_OPTION,
                           JOptionPane.WARNING_MESSAGE,
                           null,  // 使用默认图标
                           options,  // 自定义按钮文本
                           options[0]  // 默认选中的按钮
                   );
                   if (result==1) {
                	addAccount.setText("快速建立帳款");
                	
                	
                	
					//panel1
					department.setEditable(false);					
					
					
					//panel2
					costType.setEnabled(false);
					
					//panel3
					payWay.setEnabled(false);
					paymentType.setEnabled(false);
					
					//panel5
					item.setEditable(false);   
					productNumber.setEditable(false); 	
					productName.setEditable(false);   		
					amount.setEditable(false);   
					unit.setEditable(false); 
					price.setEditable(false);
					
					//功能開啟
					searchAccount.setEnabled(true);
					invoice.setEditable(true);
					
					
					//資料消除區
					
					invoice.setText("");
					pRBuyer.setText("");
					department.setText("");
					invoiceCompany.setText("");
					companyNumber.setText("");
					
					costType.setSelectedItem("");
					costName.setText("");
					currency.setText("");
					exchangeRate.setText("");
					taxType.setText("");
					taxRate.setText("");
					invoiceoutput.setText("");
					
					
					payType.setText("");
					payDate.setText("");
					
					payExpireDate.setText("");
					payState.setText("");
					
					useCurrency.setText("");
					tax.setText("");
					sum.setText("");
					paid.setText("");
					nonPayment.setText("");
					
					item.setText("");	      
					productNumber .setText(""); 
					productName.setText("");   
					amount.setText("");       
					unit.setText("");	           
					price.setText(""); 
                	
                	
               		Exit.setText("退出系統");
               		return;
                   }}
				
				if(renewAccount.getText().equals("確認")) { 
				 
                       // 自定義按鈕選項
                       Object[] options = {"繼續", "離開"};

                       // 顯示對話框
                       result = JOptionPane.showOptionDialog(
                               null,
                               "資料沒有發現更動\n請問是否要繼續更新呢?",
                               "通知",
                               JOptionPane.YES_NO_OPTION,
                               JOptionPane.WARNING_MESSAGE,
                               null,
                               options,
                               options[0]
                       );
                       
                       if (result == JOptionPane.NO_OPTION) 
                       {
                       	renewAccount.setText("更新帳款");
                       	searchAccount.setEnabled(true);
                       	addAccount.setEnabled(true);
                       	renewAccount.setEnabled(false);
           				invoice.setEditable(true);
           				department.setEditable(false);
           				costType.setEnabled(false);
           				costName.setEditable(false);
           				payWay.setEnabled(false);
           				payType.setEditable(false);
           				payDate.setEditable(false);
           				paymentType.setEnabled(false);
           				payExpireDate.setEditable(false);
           				item.setEditable(false);
           				productNumber.setEditable(false);
           				productName.setEditable(false);
           				amount.setEditable(false);
           				unit.setEditable(false);
           				price.setEditable(false);
           				
           				//資料消除區
       					
       					invoice.setText("");
       					pRBuyer.setText("");
       					department.setText("");
       					invoiceCompany.setText("");
       					companyNumber.setText("");
       					
       					costType.setSelectedItem("");
       					costName.setText("");
       					currency.setText("");
       					exchangeRate.setText("");
       					taxType.setText("");
       					taxRate.setText("");
       					invoiceoutput.setText("");
       					
       					
       					payType.setText("");
       					payDate.setText("");
       					
       					payExpireDate.setText("");
       					payState.setText("");
       					
       					useCurrency.setText("");
       					tax.setText("");
       					sum.setText("");
       					paid.setText("");
       					nonPayment.setText("");
       					
       					item.setText("");	      
       					productNumber .setText(""); 
       					productName.setText("");   
       					amount.setText("");       
       					unit.setText("");	           
       					price.setText(""); 
                       	
       					tableModel.setRowCount(0);
                      		Exit.setText("退出系統");
                      		return;
                       }}
				
				else if(Exit.getText().equals("退出系統"))
				{
					dispose();
				}
				
			}
		});
		
	}
}
