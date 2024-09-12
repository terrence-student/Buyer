package controller;
import javax.swing.*;

import model.Seller;
import service.Impl.SellerServiceImpl;
import util.DateCalculator;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class sellerAdd extends JFrame {
	private JTextField fax;
	private JTextField companyNumber;
	static SellerServiceImpl ssi=new SellerServiceImpl();
	private static DateCalculator dc=new DateCalculator();
    public sellerAdd() {
        setTitle("廠商基本資料");
        setSize(524, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);  // 设置为绝对布局
        
        // 設定背景顏色
        getContentPane().setBackground(new Color(224, 240, 255));

        // 統一字體樣式
        Font font = new Font("新細明體", Font.BOLD, 14);
        
        // 创建标签和文本框
        JLabel companyNameLabel = new JLabel("廠商名稱:");
        companyNameLabel.setBounds(30, 146, 100, 25);  // 设置位置和大小
        getContentPane().add(companyNameLabel);

        JTextField companyName = new JTextField();
        companyName.setEditable(false);
        companyName.setBounds(130, 146, 150, 25);
        getContentPane().add(companyName);

        JLabel companyShortNameLabel = new JLabel("廠商簡稱:");
        companyShortNameLabel.setBounds(30, 94, 100, 25);
        getContentPane().add(companyShortNameLabel);

        JTextField companyShortName = new JTextField();
        companyShortName.setBounds(130, 94, 150, 25);
        getContentPane().add(companyShortName);

        JLabel addressLabel = new JLabel("發票地址:");
        addressLabel.setBounds(30, 384, 100, 25);
        getContentPane().add(addressLabel);

        JTextField invoiceAddress = new JTextField();
        invoiceAddress.setEditable(false);
        invoiceAddress.setBounds(130, 384, 350, 25);
        getContentPane().add(invoiceAddress);

        JLabel postalCodeLabel = new JLabel("郵遞區號:");
        postalCodeLabel.setBounds(30, 196, 100, 25);
        getContentPane().add(postalCodeLabel);

        JTextField postCode = new JTextField();
        postCode.setEditable(false);
        postCode.setBounds(130, 196, 150, 25);
        getContentPane().add(postCode);

        JLabel contactNameLabel = new JLabel("聯絡人:");
        contactNameLabel.setBounds(30, 236, 100, 25);
        getContentPane().add(contactNameLabel);

        JTextField contactPerson = new JTextField();
        contactPerson.setEditable(false);
        contactPerson.setBounds(130, 236, 150, 25);
        getContentPane().add(contactPerson);

        JLabel phoneLabel = new JLabel("連絡電話:");
        phoneLabel.setBounds(300, 196, 61, 25);
        getContentPane().add(phoneLabel);

        JTextField phone = new JTextField();
        phone.setEditable(false);
        phone.setBounds(371, 196, 109, 25);
        getContentPane().add(phone);

        JLabel emailLabel = new JLabel("電子信箱:");
        emailLabel.setBounds(30, 294, 100, 25);
        getContentPane().add(emailLabel);

        JTextField email = new JTextField();
        email.setEditable(false);
        email.setBounds(130, 294, 350, 25);
        getContentPane().add(email);

        JLabel deliveryAddressLabel = new JLabel("公司地址:");
        deliveryAddressLabel.setBounds(30, 339, 100, 25);
        getContentPane().add(deliveryAddressLabel);

        JTextField companyAddress = new JTextField();
        companyAddress.setEditable(false);
        companyAddress.setBounds(130, 339, 350, 25);
        getContentPane().add(companyAddress);

        // 表格
        String[] columnNames = {"統一編號", "廠商", "發票", "聯絡人", "聯絡電話"};
        Object[][] data = {};

        
        
        
        JLabel phoneLabel_1 = new JLabel("傳真號碼:");
        phoneLabel_1.setBounds(300, 236, 61, 25);
        getContentPane().add(phoneLabel_1);
        
        fax = new JTextField();
        fax.setEditable(false);
        fax.setBounds(371, 236, 109, 25);
        getContentPane().add(fax);
        
        JLabel companyNameLabel_1 = new JLabel("統一編號:");
        companyNameLabel_1.setBounds(30, 39, 61, 25);
        getContentPane().add(companyNameLabel_1);
        
        companyNumber = new JTextField();
        companyNumber.setBounds(130, 39, 150, 25);
        getContentPane().add(companyNumber);
        
        JComboBox invoiceType = new JComboBox();
        invoiceType.setFont(new Font("新細明體", Font.BOLD, 15));
        invoiceType.setEnabled(false);
        invoiceType.setModel(new DefaultComboBoxModel(new String[] {"手開發票", "電子發票", "免開發票"}));
        invoiceType.setBounds(371, 147, 109, 23);
        getContentPane().add(invoiceType);
        
        JLabel companyNameLabel_1_1 = new JLabel("發票類型:");
        companyNameLabel_1_1.setBounds(300, 146, 61, 25);
        getContentPane().add(companyNameLabel_1_1);

        setVisible(true);
        
        /*================================================================*/
        JButton RenewCompanyData = new JButton("更新廠商資料");
        RenewCompanyData.setEnabled(false);
        JButton serchNumber = new JButton("查詢");
        JButton serchShortName = new JButton("查詢");
        JButton Exit = new JButton("離開");
        
        
        JButton addCompany = new JButton("新增廠商");
        addCompany.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		

                Exit.setText("取消新增");

                boolean checkButtonEven = addCompany.getText().equals("新增");
                
                // Initial setup for adding a new company
                if (!checkButtonEven) {
                    addCompany.setText("新增");
                    serchNumber.setEnabled(false);
                    serchShortName.setEnabled(false);
                    companyNumber.setText("");
                    companyShortName.setText("");
                    postCode.setEditable(true);
                    postCode.setText("");
                    phone.setEditable(true);
                    phone.setText("");
                    companyName.setEditable(true);
                    companyName.setText("");
                    contactPerson.setEditable(true);
                    contactPerson.setText("");
                    fax.setEditable(true);
                    fax.setText("");
                    email.setEditable(true);
                    email.setText("");
                    companyAddress.setEditable(true);
                    companyAddress.setText("");
                    invoiceAddress.setEditable(true);
                    invoiceAddress.setText("");
                    invoiceType.setEnabled(true);
                }
                
                                                                                        /* ============新增區============= */

                // Validate fields: companyNumber and companyShortName should not be empty
                else if (checkButtonEven && companyNumber.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "請填寫廠商統一編號!", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (checkButtonEven && (companyShortName.getText().isEmpty() || companyName.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "請填寫廠商名字和簡稱!", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // If no validation errors, create a new seller object
                if (checkButtonEven) {
                    String CompanyName = companyName.getText().trim();
                    String CompanyNumber = companyNumber.getText().trim();
                    String CompanyShortName = companyShortName.getText().trim();
                    Integer PostCode = postCode.getText().isEmpty() ? 0 : Integer.parseInt(postCode.getText().trim());
                    String Phone = phone.getText().trim();
                    String ContactPerson = contactPerson.getText().trim();
                    String Fax = fax.getText().trim();
                    String Email = email.getText().trim();
                    String CompanyAddress = companyAddress.getText().trim();
                    String InvoiceAddress = invoiceAddress.getText().trim();
                    String InvoiceType = invoiceType.getSelectedItem().toString();

                    Seller s = new Seller(CompanyNumber, CompanyName, CompanyShortName, InvoiceType, PostCode, ContactPerson, Email, Phone, Fax, CompanyAddress, InvoiceAddress);

                    // Check if the seller already exists
                    if (ssi.checkSellerNumber(CompanyNumber)) {
                        JOptionPane.showMessageDialog(null, "已存在廠商，請重新輸入!", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "新增成功!", "通知", JOptionPane.INFORMATION_MESSAGE);
                        ssi.newSellerAdd(s);
                       
                        companyNumber.setText("");
                        companyShortName.setText("");
                        companyName.setText("");
                        postCode.setText("");
                        phone.setText("");
                        contactPerson.setText("");
                        fax.setText("");
                        email.setText("");
                        companyAddress.setText("");
                        invoiceAddress.setText("");
                        
                    }
                }
        	}
        });
        addCompany.setBounds(349, 457, 120, 55);
        addCompany.setBackground(new Color(153, 204, 255));
        addCompany.setFont(font);
        getContentPane().add(addCompany);
        
    
        
       
        serchNumber.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(companyNumber.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null,"請填寫廠商統一編號!","警告",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		
        		
        		String CompanyNumber=companyNumber.getText().isEmpty()? "":companyNumber.getText().trim();
        		
        		List<Seller> l=new ArrayList();
        		
        		
        		l=ssi.selectAllByNumber(CompanyNumber);
        		if (l.size()==0) 
        		{
        			JOptionPane.showMessageDialog(null,"廠商不存在，請重新確認!","警告",JOptionPane.WARNING_MESSAGE);
        		return;
        		}
        		else {
        	for (Seller o:l) 
        	{
        		companyShortName.setText(o.getShortName());
        		companyName.setText(o.getCompanyName());
        		invoiceType.setSelectedItem(o.getInvoiceType());
        		postCode.setText(o.getPostCode().toString());
        		phone.setText(o.getPhone());
        		contactPerson.setText(o.getContactPerson());
        		fax.setText(o.getFax());
        		email.setText(o.getEmail());
        		companyAddress.setText(o.getCompanyAddress());
        		invoiceAddress.setText(o.getInvoiceAddress());
        		RenewCompanyData.setEnabled(true);
        	}
        	}
        		
        	}});
        serchNumber.setBounds(300, 40, 87, 23);
        serchNumber.setBackground(new Color(153, 204, 255)); 
        serchNumber.setFont(font);
        getContentPane().add(serchNumber);
        
        
        serchShortName.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(companyShortName.getText().isEmpty()) 
        		{	
        			JOptionPane.showMessageDialog(null,"請填寫廠商簡稱!","警告",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		String CompanyShortName=companyShortName.getText().isEmpty()? "":companyShortName.getText().trim();
        		List<Seller> l=new ArrayList();
        		
        		l=ssi.selectAllByShortname(CompanyShortName);
        		if (l.size()==0) {
        			JOptionPane.showMessageDialog(null,"廠商不存在，請重新確認!","警告",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		else {
        	for (Seller o:l) 
        	{
        		companyNumber.setText(o.getCompanynumber());
        		companyShortName.setText(o.getShortName());
        		companyName.setText(o.getCompanyName());
        		invoiceType.setSelectedItem(o.getInvoiceType());
        		postCode.setText(o.getPostCode().toString());
        		phone.setText(o.getPhone());
        		contactPerson.setText(o.getContactPerson());
        		fax.setText(o.getFax());
        		email.setText(o.getEmail());
        		companyAddress.setText(o.getCompanyAddress());
        		invoiceAddress.setText(o.getInvoiceAddress());        		
        	}
        	}
        	}
        });
        serchShortName.setBounds(300, 95, 87, 23);
        serchShortName.setBackground(new Color(153, 204, 255));
        serchShortName.setFont(font);
        getContentPane().add(serchShortName);
        
        																								/*更新資料區*/
        RenewCompanyData.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Exit.setText("取消更新");
        		boolean checkbottoneven=RenewCompanyData.getText()=="確認"?true:false;
        		if (!checkbottoneven) {
        		RenewCompanyData.setText("確認");
        		
        		addCompany.setEnabled(false);
        		serchNumber.setEnabled(false);
        		serchShortName.setEnabled(false);
        		companyNumber.setEditable(false);
        		companyShortName.setEditable(false);
        		postCode.setEditable(true);
        		phone.setEditable(true);
        		contactPerson.setEditable(true);
        		fax.setEditable(true);
        		email.setEditable(true);
        		companyAddress.setEditable(true);
        		invoiceAddress.setEditable(true);
        		invoiceType.setEnabled(true);
        		}
        		if(checkbottoneven){
        		/* 修改廠商資料  */
        		String CompanyNumber=companyNumber.getText().isEmpty()? "":companyNumber.getText().trim();
        		String CompanyName=companyName.getText().isEmpty()? "": companyName.getText().trim();
        		String CompanyShortName=companyShortName.getText().isEmpty()? "":companyShortName.getText().trim();
        		
        		Integer PostCode=postCode.getText().isEmpty()? 0:Integer.parseInt(postCode.getText().trim());
        		String Phone =phone.getText().isEmpty()? "":phone.getText().trim();
        		String ContactPerson=contactPerson.getText().isEmpty()? "":contactPerson.getText().trim();
        		String Fax=fax.getText().isEmpty()? "":fax.getText().trim();
        		String Email=email.getText().isEmpty()? "":email.getText().trim();
        		String CompanyAddress=companyAddress.getText().isEmpty()? "":companyAddress.getText().trim();
        		String InvoiceAddress=invoiceAddress.getText().isEmpty()? "":invoiceAddress.getText().trim();
        		String InvoiceType=invoiceType.getSelectedItem().toString();
        		
        		
        		Seller s=new Seller(CompanyNumber,CompanyName,CompanyShortName,InvoiceType,PostCode,ContactPerson
        				,Email,Phone,Fax,CompanyAddress,InvoiceAddress);
        		
        		
        		List<Seller> l=new ArrayList();
        		
        		l=ssi.selectAllByNumber(CompanyNumber);
        		
        		
        	boolean x=false;
        	
        	for (Seller o:l) 
        	{
        		if (!InvoiceType.equals(o.getInvoiceType()))
        		{
        			s.setInvoiceType(InvoiceType);
        			x=true;
        		}	
        		if(!PostCode.equals(o.getPostCode()))
        		{
        			s.setPostCode(PostCode);
        			x=true;
        		}	
        		if(!Phone.equals(o.getPhone()))
        		{	s.setPhone(Phone);
        			x=true;
        		}	
        		if(!ContactPerson.equals(o.getContactPerson()))
        		{
        			s.setContactPerson(ContactPerson);
        			x=true;
        		}	
        		if(!Fax.equals(o.getFax()))
        		{	
        			s.setFax(Fax);
        			x=true;
        		}	
        		if(!Email.equals(o.getEmail()))
        		{
        			s.setEmail(Email);
        			x=true;
        		}	
        		if(!CompanyAddress.equals(o.getCompanyAddress()))
        		{
        			s.setCompanyAddress(CompanyAddress);
        			x=true;
        		}	
        		if(!InvoiceAddress.equals(o.getInvoiceAddress())) 
        		{
        			s.setInvoiceAddress(InvoiceAddress);
        			x=true;
        		}
        	}
        	
        	int result=0;
        	if(!x) {
        		 // 自定义按钮的选项
                Object[] options = {"繼續", "離開"};
                
                // 显示带有自定义按钮的对话框
                result = JOptionPane.showOptionDialog(
                        null,
                        "資料沒有發現更動\n請問是否要繼續更新呢?",
                        "通知",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,  // 使用默认图标
                        options,  // 自定义按钮文本
                        options[0]  // 默认选中的按钮
                );
        	}
        	else 
        	{	
        		JOptionPane.showMessageDialog(null, "更新成功!", "通知", JOptionPane.INFORMATION_MESSAGE);
        		ssi.UpdateSeller(s);
        	}
                
                
                   
                // 输出结果
                if (result==1) {
                	RenewCompanyData.setText("更新廠商資料");
                	addCompany.setEnabled(true);
            		serchNumber.setEnabled(true);
            		serchShortName.setEnabled(true);
            		companyNumber.setEditable(true);
            		companyShortName.setEditable(true);
            		invoiceType.setEditable(false);
            		postCode.setEditable(false);
            		phone.setEditable(false);
            		contactPerson.setEditable(false);
            		fax.setEditable(false);
            		email.setEditable(false);
            		companyAddress.setEditable(false);
            		invoiceAddress.setEditable(false);
            		invoiceType.setEnabled(false);
            		RenewCompanyData.setEnabled(false);
            		Exit.setText("離開");
            		
                	
        	}
        	}
        	}
        });
        RenewCompanyData.setBounds(191, 457, 130, 55);
        RenewCompanyData.setBackground(new Color(153, 204, 255));
        RenewCompanyData.setFont(font);
        getContentPane().add(RenewCompanyData);
        // 底部按钮
        
        Exit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int result=-1;
        		if(RenewCompanyData.getText().equals("確認")) {
        			
        			
        			// 自定义按钮的选项
                   Object[] options = {"繼續更新", "取消更新"};
                   
                   // 显示带有自定义按钮的对话框
                   result=JOptionPane.showOptionDialog(
                           null,
                           "是否確定要取消更新呢?\n",
                           "警告",
                           JOptionPane.YES_NO_OPTION,
                           JOptionPane.WARNING_MESSAGE,
                           null,  // 使用默认图标
                           options,  // 自定义按钮文本
                           options[0]  // 默认选中的按钮
                   );
                   if (result==1) {
                   	RenewCompanyData.setText("更新廠商資料");
                   	addCompany.setEnabled(true);
               		serchNumber.setEnabled(true);
               		serchShortName.setEnabled(true);
               		companyNumber.setEditable(true);
               		companyShortName.setEditable(true);
               		invoiceType.setEditable(false);
               		postCode.setEditable(false);
               		phone.setEditable(false);
               		contactPerson.setEditable(false);
               		fax.setEditable(false);
               		email.setEditable(false);
               		companyAddress.setEditable(false);
               		invoiceAddress.setEditable(false);
               		invoiceType.setEnabled(false);
               		RenewCompanyData.setEnabled(false);
               		Exit.setText("離開");
                   }}
        		
        		else if(addCompany.getText().equals("新增")) 
        		{
        			// 自定义按钮的选项
                    Object[] options = {"繼續新增", "取消新增"};
                    
                    // 显示带有自定义按钮的对话框
                    result=JOptionPane.showOptionDialog(
                            null,
                            "是否確定要取消新增呢?\n",
                            "警告",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,  // 使用默认图标
                            options,  // 自定义按钮文本
                            options[0]  // 默认选中的按钮
                    );
                    if (result==1) {
                    	
                    	companyNumber.setText("");
                        companyShortName.setText("");
                        companyName.setText("");
                        postCode.setText("");
                        phone.setText("");
                        contactPerson.setText("");
                        fax.setText("");
                        email.setText("");
                        companyAddress.setText("");
                        invoiceAddress.setText("");
                       	addCompany.setEnabled(true);
                   		serchNumber.setEnabled(true);
                   		serchShortName.setEnabled(true);
                   		companyNumber.setEditable(true);
                   		companyShortName.setEditable(true);
                   		invoiceType.setEditable(false);
                   		postCode.setEditable(false);
                   		phone.setEditable(false);
                   		contactPerson.setEditable(false);
                   		fax.setEditable(false);
                   		email.setEditable(false);
                   		companyAddress.setEditable(false);
                   		invoiceAddress.setEditable(false);
                   		invoiceType.setEnabled(false);
                   		RenewCompanyData.setEnabled(false);
                   		addCompany.setText("新增廠商");
                   		Exit.setText("離開");
                   		
                       }}
        		
        		else{
        			new ChoseUI().setVisible(true);
        			dispose();
        			}
        		
        		
        	}
        });
        Exit.setBounds(48, 457, 112, 55);
        Exit.setBackground(new Color(153, 204, 255));
        Exit.setFont(font);
        getContentPane().add(Exit);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 19));
        lblNewLabel.setBounds(366, 528, 132, 23);
        getContentPane().add(lblNewLabel);
        
        
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dc.updateLabelWithTime(lblNewLabel);
            }
        });
        timer.start();
		
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(sellerAdd::new);
    }
}


