package login;

import commom.DBConnection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDB implements Serializable {
	private Connection con = null;
	public UserInfo GetUserbyName(String userName) {
		System.out.println("GetUserbyName:userName="+userName);
		UserInfo user=null;
		PreparedStatement pStmt=null;
		ResultSet rs = null;
		try {
			//链接数据库
			con = DBConnection.getConnection();
			//查找指定用户
			pStmt = con.prepareStatement("SELECT * FROM t_user where VC_LOGIN_NAME=?");
			pStmt.setString(1, userName);
			rs = pStmt.executeQuery();
			//对信息进行封装
			if(rs.next()) {
				user=new UserInfo();
				user.setUserID(rs.getInt("N_USER_ID"));
				user.setUserName(rs.getString("VC_LOGIN_NAME"));
				user.setUserPwd(rs.getString("VC_PASSWORD"));
			}
			rs.close();
			pStmt.close();
		}catch(Exception e) {
			System.out.println("获取指定用户信息失败！ Error to fetching the infomation of user!");
			e.printStackTrace();

		}finally {
			DBConnection.closeConnection();
		}
		return user;
	}


	public ArrayList<UserInfo> GetUserInfo() {
		ArrayList<UserInfo> user_list = new ArrayList<>();
		UserInfo user=null;
		PreparedStatement pStmt=null;
		ResultSet rs = null;
		try {
			//链接数据库
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM t_user WHERE VC_LOGIN_NAME like '%user%'");
			//pStmt.setString(1, userName);
			rs = pStmt.executeQuery();
			//遍历封装
			while(rs.next()) {
				user=new UserInfo();
				user.setUserID(rs.getInt("N_USER_ID"));
				user.setUserName(rs.getString("VC_LOGIN_NAME"));
				user.setUserPwd(rs.getString("VC_PASSWORD"));
				user_list.add(user);
			}
			rs.close();
			pStmt.close();
		}catch(Exception e) {
			System.out.println("获取指定用户信息失败！Error to fetching the infomation of user!");
			e.printStackTrace();

		}finally {
			DBConnection.closeConnection();
		}
		return user_list;
	}
}
