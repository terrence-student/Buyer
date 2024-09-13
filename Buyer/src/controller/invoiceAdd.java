package controller;
import model.Invoice;
import model.Seller;
import service.Impl.AccountantServiceImpl;
import service.Impl.InvoiceServiceImpl;
import service.Impl.SellerServiceImpl;
import util.DateCalculator;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;



public class invoiceAdd extends JFrame {
	

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField invoice;
    private JTextField invoiceDate;
    private JTextField money;
    private JTextField shortName;
    
    private static AccountantServiceImpl ais=new AccountantServiceImpl();
    private static InvoiceServiceImpl isi = new InvoiceServiceImpl();
    private static SellerServiceImpl ssi=new SellerServiceImpl();
    private JTextField moneyInTxt;
    private JTextField companyNumber;
    private JTextField companyShortName;
    private static DateCalculator dc=new DateCalculator();
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    invoiceAdd frame = new invoiceAdd();
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
    public invoiceAdd() {
        setTitle("發票管理系統");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 754);
        
        // Setting a bright background color
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 250, 205));  // Light yellow
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Panel settings
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 239, 213));  // Lighter cream color
        panel.setBounds(50, 50, 700, 657);
        contentPane.add(panel);
        panel.setLayout(null);
        
        // Label for Invoice Number
        JLabel lblNewLabel_1 = new JLabel("發票號碼:");
        lblNewLabel_1.setBounds(86, 89, 150, 36);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1.setForeground(Color.DARK_GRAY);
        panel.add(lblNewLabel_1);
        
        invoice = new JTextField();
        invoice.setBounds(246, 89, 200, 36);
        invoice.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
        panel.add(invoice);
        
        // Label for Invoice Date
        JLabel lblNewLabel_1_1 = new JLabel("發票日期:");
        lblNewLabel_1_1.setBounds(86, 239, 150, 36);
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
        panel.add(lblNewLabel_1_1);
        
        invoiceDate = new JTextField();
        invoiceDate.setEditable(false);
        invoiceDate.setBounds(246, 239, 200, 36);
        invoiceDate.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
        panel.add(invoiceDate);
        
        // Invoice type dropdown
        JLabel lblInvoiceType = new JLabel("發票類型:");
        lblInvoiceType.setBounds(86, 289, 150, 36);
        lblInvoiceType.setHorizontalAlignment(SwingConstants.CENTER);
        lblInvoiceType.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblInvoiceType.setForeground(Color.DARK_GRAY);
        panel.add(lblInvoiceType);
        
        JComboBox<String> invoiceType = new JComboBox<>();
        invoiceType.setBounds(246, 289, 200, 36);
        invoiceType.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
        invoiceType.setModel(new DefaultComboBoxModel<>(new String[] {"手開發票", "電子發票", "免開發票"}));
        panel.add(invoiceType);
        
        // Label for Money
        JLabel lblMoney = new JLabel("金額(未含稅):");
        lblMoney.setBounds(86, 339, 150, 36);
        lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
        lblMoney.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblMoney.setForeground(Color.DARK_GRAY);
        panel.add(lblMoney);
        
        money = new JTextField();
        money.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		
        		try 
        		{
        			int Money=Integer.parseInt(money.getText());
        		}
        		catch(java.lang.NumberFormatException e1) 
        		{
        			JOptionPane.showMessageDialog(null, "請輸入正確的金額!", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
        		}
        		
        	}
        });
        money.setEditable(false);
        money.setBounds(246, 339, 200, 36);
        money.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
        panel.add(money);
        
        
        
        JLabel lblMoney_1 = new JLabel("金額(含稅):");
        lblMoney_1.setBounds(86, 389, 150, 36);
        lblMoney_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblMoney_1.setForeground(Color.DARK_GRAY);
        lblMoney_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        panel.add(lblMoney_1);
        
        
        
        
        
        
   /*============================================================================*/  
        JButton Exit = new JButton("離開");
        Exit.setBounds(50, 490, 120, 50);
        JButton serchByInvoice = new JButton("查詢");
        serchByInvoice.setBounds(464, 89, 130, 36);
        JButton RenewInvoice = new JButton("更新發票");
        JButton selectDates = new JButton("選擇日期");
        selectDates.setEnabled(false);
        RenewInvoice.setEnabled(false);
        JButton delete = new JButton("刪除發票");
        delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {                  /* ============刪除發票區============= */
        	String Invoice=invoice.getText();
        		if(ais.checkInvoice(Invoice)) 
        		{
        			JOptionPane.showMessageDialog(null, "該發票已建立帳款，故無法刪除發票", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
        		}
        		else 
        		{
        			isi.DeleteByInvoice(Invoice);
        			JOptionPane.showMessageDialog(null,"該發票已刪除!","通知",JOptionPane.PLAIN_MESSAGE);
        			
                	
                	companyNumber.setText(""); 			
        			companyShortName.setText("");   	
                	invoiceDate.setText("");
                	invoice.setText("");
                    money.setText("");
                    moneyInTxt.setText("");
                    invoiceType.setEnabled(false);
                    delete.setEnabled(false);
                    RenewInvoice.setEnabled(false);
        			
        		}
        		
        		
        	}
        });
        
                                                                                     /* ============新增發票區============= */
        JButton addInvoice = new JButton("新增發票");
        addInvoice.setBounds(350, 490, 120, 50);
        addInvoice.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
                
                serchByInvoice.setEnabled(false);
                RenewInvoice.setEnabled(false);
                
                boolean checkButtonEven = addInvoice.getText().equals("新增");
                if (!checkButtonEven) {
                	addInvoice.setText("新增");
                	selectDates.setEnabled(true);
                	companyNumber.setEditable(true);
                	companyNumber.setText("");
        			companyShortName.setEditable(true);
        			companyShortName.setText("");
                	invoiceDate.setEditable(true);
                	invoiceDate.setText("");
                	invoice.setText("");
                    invoiceType.setEnabled(true);
                    money.setEditable(true);
                    money.setText("");
                    moneyInTxt.setText("");
                    
                    Exit.setText("取消新增");
                }
                
                
               
                if(checkButtonEven) {
                
                if ( invoice.getText().isEmpty()||companyNumber.getText().isEmpty()|| invoiceDate.getText().isEmpty()||money.getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "請全部填寫完成!", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                // Collect data
                String Invoice = invoice.getText().trim();
                String CompanyNumber=companyNumber.getText();
                
                if(!ssi.checkSellerNumber(CompanyNumber))
                {
                	JOptionPane.showMessageDialog(null, "廠商不存在，請重新確認!", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                else 
                {	
                	List<Seller> l=new ArrayList();
                	l=ssi.selectAllByNumber(CompanyNumber);
                	for(Seller o:l)
                	companyShortName.setText(o.getShortName());
                	
                }
                
                String CompanyShortName=companyShortName.getText();
                String InvoiceDate = invoiceDate.getText().trim();
                String InvoiceType = invoiceType.getSelectedItem().toString();
                Integer Money = Integer.parseInt(money.getText().trim());
                Integer MoneyInTxt=(int)Math.round((Money*1.05));
                
               
                // Create Invoice and add it to the system
                Invoice inv = new Invoice(Invoice,CompanyNumber,CompanyShortName,InvoiceDate,InvoiceType, Money, MoneyInTxt);
                
                if (isi.checkInvoice(Invoice)) {
                    JOptionPane.showMessageDialog(null, "已存在發票，請重新輸入!", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                else {
                JOptionPane.showMessageDialog(null, "發票新增成功!", "通知", JOptionPane.INFORMATION_MESSAGE);
                isi.newInvoiceAdd(inv);
                
                serchByInvoice.setEnabled(true);
                selectDates.setEnabled(false);
            	invoice.setText("");
            	companyNumber.setEditable(false);
            	companyNumber.setText("");
    			companyShortName.setEditable(false);
    			companyShortName.setText("");
            	invoiceDate.setText("");
            	invoiceDate.setEditable(false);
            	money.setText("");
            	money.setEditable(false);
            	moneyInTxt.setText("");
            	invoiceType.setEnabled(false);
            	Exit.setText("離開");
            	RenewInvoice.setEnabled(false);
            	addInvoice.setText("新增發票");
            	
                }
                
                }
        	}
        	
        });
        addInvoice.setForeground(new Color(17, 17, 17));
        addInvoice.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        addInvoice.setBackground(new Color(100, 149, 237));
        panel.add(addInvoice);
        
                                                                                /*---------------------搜索發票區---------------*/
        serchByInvoice.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(invoice.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null,"請填寫發票號碼!","警告",JOptionPane.WARNING_MESSAGE);
        			return;
        		}	
        		String Invoice=invoice.getText().trim();
        		
        		List<Invoice> l=new ArrayList();
        		boolean x2=isi.checkInvoice(Invoice);
        		
        		
        		if (!x2) 
        		{
        			JOptionPane.showMessageDialog(null,"發票不存在，請重新確認!","警告",JOptionPane.WARNING_MESSAGE);
        		return;
        		}
        		else {
        				l=isi.selectAllByInvoice(Invoice);
        			for (Invoice o:l) 
        			{	
        				companyNumber.setText(o.getCompanyNumber());
        				companyShortName.setText(o.getCompanyShortName());
        				invoiceDate.setText(o.getInvoiceDate());
        				invoiceType.setSelectedItem(o.getInvoiceType());
        				money.setText(o.getMoney().toString());
        				moneyInTxt.setText(o.getMoneyInTxt().toString());
        		
        		
        		
        	
        				RenewInvoice.setEnabled(true);
        				delete.setEnabled(true);
        			}
        	}
        		
        		
        	}
        });
        serchByInvoice.setForeground(new Color(17, 17, 17));
        serchByInvoice.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        serchByInvoice.setBackground(new Color(100, 149, 237));
        panel.add(serchByInvoice);
        
     // Confirmation button
        
        RenewInvoice.setBounds(200, 490, 120, 50);
        RenewInvoice.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        RenewInvoice.setBackground(new Color(100, 149, 237));  // Light blue
        RenewInvoice.setForeground(new Color(17, 17, 17));
        																/*-------------------更新發票內容--------------------*/
        RenewInvoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Exit.setText("結束更新");
                if (companyNumber.getText().isEmpty() || invoiceDate.getText().isEmpty() || money.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "請全部填寫完成!", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if(ais.checkInvoice(invoice.getText())) 
        		{
        			JOptionPane.showMessageDialog(null, "該發票已建立帳款，故無法對該發票作更動", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
        		}
                
                
                boolean isConfirming = "確認".equals(RenewInvoice.getText());
                
                if (!isConfirming) {
                    // 設置為編輯狀態
                    selectDates.setEnabled(true);
                    delete.setEnabled(false);
                    RenewInvoice.setText("確認");
                    companyNumber.setEditable(true);
                    companyShortName.setEditable(true);
                    invoice.setEnabled(false);
                    serchByInvoice.setEnabled(false);
                    addInvoice.setEnabled(false);
                    invoiceDate.setEditable(true);
                    invoiceType.setEnabled(true);
                    money.setEditable(true);
                    
                    
                } else {
                    // 確認狀態下的處理
                    String Invoice = invoice.getText().trim();
                    String CompanyNumber = companyNumber.getText().trim();
                    String CompanyShortName = companyShortName.getText().trim();
                    String InvoiceDate = invoiceDate.getText().trim();
                    String InvoiceType = invoiceType.getSelectedItem().toString();
                    Integer Money = Integer.parseInt(money.getText().trim());
                    Integer MoneyInTxt = (int) Math.round(Money * 1.05);

                    Invoice inv = new Invoice(Invoice, CompanyNumber, CompanyShortName, InvoiceDate, InvoiceType, Money, MoneyInTxt);
                    List<Invoice> l = isi.selectAllByInvoice(Invoice);

                    boolean hasChanges = false;

                    for (Invoice o : l) {
                        if (!CompanyNumber.equals(o.getCompanyNumber())) {
                            inv.setCompanyNumber(CompanyNumber);
                            hasChanges = true;
                        }

                        if (!CompanyShortName.equals(o.getCompanyShortName())) {
                            inv.setCompanyShortName(CompanyShortName);
                            hasChanges = true;
                        }

                        if (!InvoiceDate.equals(o.getInvoiceDate())) {
                            inv.setInvoiceDate(InvoiceDate);
                            hasChanges = true;
                        }

                        if (!InvoiceType.equals(o.getInvoiceType())) {
                            inv.setInvoiceType(InvoiceType);
                            hasChanges = true;
                        }

                        if (!Money.equals(o.getMoney())) {
                            inv.setMoney(Money);
                            hasChanges = true;
                        }
                        
                        if (!MoneyInTxt.equals(o.getMoneyInTxt())) {
                            inv.setMoneyInTxt((int) Math.round(Money * 1.05));
                            hasChanges = true;
                        }
                    }

                    if (!hasChanges) {
                        // 自定义按钮的选项
                        Object[] options = {"繼續", "離開"};

                        // 显示带有自定义按钮的对话框
                        int result = JOptionPane.showOptionDialog(
                                null,
                                "資料沒有發現更動\n請問是否要繼續更新呢?",
                                "通知",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]
                        );

                        if (result == JOptionPane.NO_OPTION) {
                            RenewInvoice.setText("更新發票");
                            serchByInvoice.setEnabled(true);
                            addInvoice.setEnabled(true);
                            selectDates.setEnabled(false);
                            invoice.setEnabled(true);
                            invoice.setText("");
                            companyNumber.setEditable(false);
                            companyNumber.setText("");
                            companyShortName.setEditable(false);
                            companyShortName.setText("");
                            invoiceDate.setEditable(false);
                            invoiceDate.setText("");
                            invoiceType.setEnabled(false);
                            money.setEditable(false);;
                            money.setText("");
                            moneyInTxt.setEditable(false);
                            moneyInTxt.setText("");
                            RenewInvoice.setEnabled(false);
                            Exit.setText("離開");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "更新成功!", "通知", JOptionPane.INFORMATION_MESSAGE);
                        isi.UpdateInvoice(inv);
                        // 在成功更新後，將按鈕狀態和界面元素重設為初始狀態
                        RenewInvoice.setText("更新發票");
                        serchByInvoice.setEnabled(true);
                        addInvoice.setEnabled(true);
                        selectDates.setEnabled(false);
                        invoice.setEnabled(true);
                        invoice.setText("");
                        companyNumber.setEditable(false);
                        companyNumber.setText("");
                        companyShortName.setEditable(false);
                        companyShortName.setText("");
                        invoiceDate.setEditable(false);
                        invoiceDate.setText("");
                        invoiceType.setEnabled(false);
                        money.setEditable(false);;
                        money.setText("");
                        moneyInTxt.setEnabled(false);
                        moneyInTxt.setText("");
                        RenewInvoice.setEnabled(false);
                        Exit.setText("離開");
                    }
                }
            }
        });

        
        panel.add(RenewInvoice);
                                                                       /*-------------------退出畫面--------------------*/
        Exit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int result=-1;
        		if(addInvoice.getText().equals("新增")) {
        			
        			
        			// 自定义按钮的选项
                   Object[] options = {"繼續新增", "取消新增"};
                   
                   // 显示带有自定义按钮的对话框
                   result=JOptionPane.showOptionDialog(
                           null,
                           "是否確定要取消新增呢?\n",
                           "通知",
                           JOptionPane.YES_NO_OPTION,
                           JOptionPane.QUESTION_MESSAGE,
                           null,  // 使用默认图标
                           options,  // 自定义按钮文本
                           options[0]  // 默认选中的按钮
                   );
                   if (result==1) {
                	addInvoice.setText("新增發票");
                	selectDates.setEnabled(false);
                	companyNumber.setEditable(false);
                	companyShortName.setEditable(false);
                	invoiceDate.setEditable(false);
                	invoiceType.setEditable(false);
                	money.setEditable(false);       	
                	invoice.setText("");
                	companyNumber.setText("");
                	companyShortName.setText("");
                	invoiceDate.setText("");
                	money.setText("");
                	moneyInTxt.setText("");
                	serchByInvoice.setEnabled(true);
                	
               		Exit.setText("離開");
                   }}
        		
        		
        		else if(RenewInvoice.getText().equals("確認")) 
        		{
        			 // 自定义按钮的选项
                    Object[] options = {"繼續", "離開"};
                    
                    // 显示带有自定义按钮的对话框
                    result = JOptionPane.showOptionDialog(
                            null,
                            "資料沒有發現更動\n請問是否要繼續更新呢?",
                            "通知",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,  // 使用默认图标
                            options,  // 自定义按钮文本
                            options[0]  // 默认选中的按钮
                    );
                    // 输出结果
                    if (result==1) {
                    	RenewInvoice.setText("更新發票");
                    	selectDates.setEnabled(false);
                    	serchByInvoice.setEnabled(true);
                    	addInvoice.setEnabled(true);
                    	invoice.setEnabled(true);
                    	invoice.setText("");
                    	companyNumber.setEditable(false);
                    	companyShortName.setEditable(false);
                    	companyNumber.setText("");
                    	companyShortName.setText("");
                    	invoiceDate.setEditable(false);
                    	invoiceDate.setText("");
                    	invoiceType.setEnabled(false);
                    	money.setEditable(false);
                    	money.setText("");
                    	moneyInTxt.setEditable(false);
                    	moneyInTxt.setText("");
                    	RenewInvoice.setEnabled(false);
                		Exit.setText("離開");
                		
                    	
            	 }}
        		else{
        			
        			dispose();
        			}
        		
        		
        	}
        });
        Exit.setForeground(new Color(17, 17, 17));
        Exit.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        Exit.setBackground(new Color(100, 149, 237));
        panel.add(Exit);
        
        moneyInTxt = new JTextField();
        moneyInTxt.setEditable(false);
        moneyInTxt.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 if(RenewInvoice.getText().equals("確認")||addInvoice.getText().equals("新增")) {
                 
                 try 
         		{
                	 Integer Money = Integer.parseInt(money.getText().trim());
                	 Integer MoneyInTxt=(int)Math.round((Money*1.05));
                     moneyInTxt.setText(MoneyInTxt.toString());
         		}
         		catch(java.lang.NumberFormatException e1) 
         		{
         			JOptionPane.showMessageDialog(null, "請輸入正確的金額!", "警告", JOptionPane.WARNING_MESSAGE);
                     return;
         		}
                 
                
        		 }
        		
        	}
        });
        moneyInTxt.setFont(new Font("微軟正黑體 Light", Font.BOLD, 18));
        moneyInTxt.setBounds(246, 389, 200, 36);
        panel.add(moneyInTxt);
        
        JLabel lblNewLabel_22 = new JLabel("廠商統一編號:");
        lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_22.setForeground(Color.DARK_GRAY);
        lblNewLabel_22.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_22.setBounds(86, 139, 150, 36);
        panel.add(lblNewLabel_22);
        
        companyNumber = new JTextField();
        companyNumber.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
        companyNumber.setEditable(false);
        companyNumber.setBounds(246, 139, 200, 36);
        panel.add(companyNumber);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("公司簡稱:");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setForeground(Color.DARK_GRAY);
        lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1_1_2.setBounds(86, 189, 150, 36);
        panel.add(lblNewLabel_1_1_2);
        
        companyShortName = new JTextField();
        companyShortName.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(!companyNumber.getText().isEmpty()) 
        		{
        			String CompanyShortName=companyShortName.getText().trim();
        			isi.selectByNumber(companyNumber.getText());
        		}
        		
        	}
        });
        companyShortName.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
        companyShortName.setEditable(false);
        companyShortName.setBounds(246, 189, 200, 36);
        panel.add(companyShortName);
        
       
        selectDates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 創建新的 JFrame 並設定其參數
                JFrame dateFrame = new JFrame("選擇日期");
                dateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // 設定關閉窗口行為
                dateFrame.setSize(300, 300);  // 設定窗口大小
                
                // 傳入回調，當選擇日期時，回調會將日期設置到 invoiceDate
                DatesAdd da = new DatesAdd(selectedDate -> {
                    invoiceDate.setText(selectedDate);  // 將選擇的日期設定到 invoiceDate
                    dateFrame.dispose();  // 關閉日期選擇窗口
                });
                
                dateFrame.getContentPane().add(da);
                dateFrame.setVisible(true);
            }
        });
        selectDates.setForeground(new Color(17, 17, 17));
        selectDates.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        selectDates.setBackground(new Color(100, 149, 237));
        selectDates.setBounds(464, 239, 130, 36);
        panel.add(selectDates);
        
        
        delete.setEnabled(false);
        delete.setForeground(new Color(17, 17, 17));
        delete.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        delete.setBackground(new Color(100, 149, 237));
        delete.setBounds(500, 490, 120, 50);
        panel.add(delete);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 19));
        lblNewLabel.setBounds(560, 611, 130, 36);
        panel.add(lblNewLabel);
     // 设置定时器以每秒更新一次 JLabel
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dc.updateLabelWithTime(lblNewLabel);
            }
        });
        timer.start();
        
        
    }
}
