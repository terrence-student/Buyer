package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Dbconnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao {

	public static void main(String[] args) {
		new MemberDaoImpl().delete(1);
		
		
		
		
		
		
		
		//Member m=new Member("m0010","an16516","an161651","1234","台東","09163120");
		//new MemberDaoImpl().selectAll();
		
		//List<Member> l=new MemberDaoImpl().selectById(1);
		//Member m=l.get(0);
		//m.setName("ojgbvspodfjb");
		//m.setAddress("台南");
		
		//new MemberDaoImpl().update(m);
		
		/*for (Member o:l) {
			//System.out.println(o.getId()+"\t"+o.getName());
	}*/
		
	}

	@Override
	public void add(Member m) {
		Connection cn=Dbconnection.getDb();
		
		try {
			String SQL="insert into member(name,username,password)"+
						"values(?,?,?)";
			
			PreparedStatement ps=cn.prepareStatement(SQL);
			
			ps.setString(1,m.getName());
			ps.setString(2,m.getUsername());
			ps.setString(3,m.getPassword());
			
			
			ps.executeUpdate();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> selectAll() {
		Connection cn=Dbconnection.getDb();//連接資料庫
		String SQL="select * from member";//條件 *(所有)，來自member
		List<Member> l=new ArrayList(); //類別Member的List ，實體化(參考類別-附上記憶體空間)
		
		try {
			PreparedStatement ps =cn.prepareStatement(SQL); //預編譯資料庫的程式(update、delete等等...方便管理)
			ResultSet rs=ps.executeQuery();//select查詢是executeQuery 
			
			while(rs.next())  
				//類別動態class:MemberDaoImpl會把資料丟給類別靜態class:Member做儲存，這行的動作就是把存在靜態的變數值，扔回來放進資料庫
				//jframe: 按鈕even-->靜態class-->在別的方法丟進textarea{範例:(.setText(.getText)}
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				
		
				
				
				l.add(m);
			}
			
		}
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public List<Member> selectById(int id) {
		Connection cn=Dbconnection.getDb();
		String SQL="select * from member where id=?";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps =cn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				
				
				l.add(m);
			}
			
		}
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public List<Member> selectMember(String username, String password) {
		Connection cn=Dbconnection.getDb();
		String SQL="select * from member where username=? and password=?";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps =cn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				
				
				l.add(m);
			}
			
		}
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public List<Member> selectByUsername(String username) {
		Connection cn=Dbconnection.getDb();
		String SQL="select * from member where username=?";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps =cn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				
				
				l.add(m);
			}
			
		}
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public void update(Member m) {
		Connection cn=Dbconnection.getDb();
		
		
		
		try {
			// 1. 設置 SQL_SAFE_UPDATES = 0
	        String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
	        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
	        psDisable.executeUpdate();
	        
	        // 2. 執行更新語句
	        String SQL = "UPDATE buyer.member SET name=?, password=? WHERE username=?";
	        PreparedStatement ps = cn.prepareStatement(SQL);
	        ps.setString(1, m.getName());
	        ps.setString(2, m.getPassword());
	        ps.setString(3, m.getUsername());
	        ps.executeUpdate();
	        
	        // 3. 設置 SQL_SAFE_UPDATES = 1
	        String enableSafeUpdates = "SET SQL_SAFE_UPDATES = 1";
	        PreparedStatement psEnable = cn.prepareStatement(enableSafeUpdates);
	        psEnable.executeUpdate();
			
			
			
		}
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	@Override
	public void delete(int id) {
		Connection cn=Dbconnection.getDb();
		String SQL="delete from member where id=?";
		try {
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
