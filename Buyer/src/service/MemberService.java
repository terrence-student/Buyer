package service;

import java.util.List;

import model.Member;

public interface  MemberService {
	
		Member login(String username,String password );//把資料庫的資料抓出來查，做1.成功:跳入第二個畫面、2.失敗就跳出視窗
		
		boolean findByUserName(String username);//把資料庫的資料抓出來查，有沒有相同的帳號
		
	
		
		void AddMember(Member m); //把Member靜態class的變數值，丟出來放進資料庫

	
	
}
