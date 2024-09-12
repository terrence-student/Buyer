package service.Impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService 
{
	
	///最重要的///
	private static MemberDaoImpl mdi=new MemberDaoImpl();
	
	
	public static void main(String[] args) {
		//Member m=new Member("b1","t1","1234");
		System.out.println(new MemberServiceImpl().login("t1", "1233"));
		//new MemberServiceImpl().AddMember(m);//匿名實體化
		

	}
	
	
	
	
	
	@Override
	public Member login(String username, String password) {
		List<Member> l=mdi.selectMember(username,password);
		Member m=null;
		
		if(l.size()!=0) 
		{
			m=l.get(0);
		}
	 
		
			return m;
		
		
		
	}

	@Override
	public boolean findByUserName(String username) {
		List<Member> l=mdi.selectByUsername(username);
		
		boolean x=false;
		
		if(l.size()!=0) 
		{
			x=true;
		}
	 
		
			return x;
	}

	@Override
	public void AddMember(Member m) {
		mdi.add(m);
		
	
		
	}







}
