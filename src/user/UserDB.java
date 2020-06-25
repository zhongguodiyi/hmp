package user;

import commom.*;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDB implements Serializable {
	private Connection con = null;
	public UserInfo GetUserbyName(String userName) {
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
				user.setAuth(rs.getInt("Authority"));
			}
			rs.close();
			pStmt.close();
		}catch(Exception e) {
			System.out.println("获取指定用户信息失败！");
			e.printStackTrace();

		}finally {
			DBConnection.closeConnection();
		}
		return user;
	}

	public UserInfo GetUserbyId(int userId) {
		UserInfo user=null;
		PreparedStatement pStmt=null;
		ResultSet rs = null;
		try {
			//链接数据库
			con = DBConnection.getConnection();
			//查找指定用户
			pStmt = con.prepareStatement("SELECT * FROM t_user where N_USER_ID=?");
			pStmt.setInt(1, userId);
			rs = pStmt.executeQuery();
			//对信息进行封装
			if(rs.next()) {
				user=new UserInfo();
				user.setUserID(rs.getInt("N_USER_ID"));
				user.setUserName(rs.getString("VC_LOGIN_NAME"));
				user.setUserPwd(rs.getString("VC_PASSWORD"));
				user.setAuth(rs.getInt("Authority"));
			}
			rs.close();
			pStmt.close();
		}catch(Exception e) {
			System.out.println("获取指定用户信息失败！");
			e.printStackTrace();

		}finally {
			DBConnection.closeConnection();
		}
		return user;
	}
	public int update(UserInfo user){
		PreparedStatement pStmt=null;
		int count=0;
		try {
			con=DBConnection.getConnection();
			pStmt = con.prepareStatement("UPDATE t_user SET VC_LOGIN_NAME=?,VC_PASSWORD=? WHERE N_USER_ID=?");
			pStmt.setString(1,user.getUserName());
			pStmt.setString(2,user.getUserPwd());
			pStmt.setInt(3,user.getUserID());

			count=pStmt.executeUpdate();
			pStmt.close();
		} catch (Exception e) {
			System.out.println("修改用户信息失败！");
			e.printStackTrace();
		} finally{
			DBConnection.closeConnection();
		}
		return count;
	}

	public int editAuth(UserInfo user){
		PreparedStatement pStmt=null;
		int count=0;
		try {
			con=DBConnection.getConnection();
			pStmt = con.prepareStatement("UPDATE t_user SET Authority=? WHERE N_USER_ID=?");
			if(user.getAuth() == 1){
				pStmt.setInt(1,2);
			}else {
				pStmt.setInt(1,1);
			}
			pStmt.setInt(2,user.getUserID());
			count=pStmt.executeUpdate();
			pStmt.close();
		} catch (Exception e) {
			System.out.println("修改权限失败！");
			e.printStackTrace();
		} finally{
			DBConnection.closeConnection();
		}
		return count;
	}

	public int delete(int id){
		PreparedStatement pStmt = null;
		int count=0;
		try{
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("DELETE from t_user WHERE N_USER_ID = ?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();

			pStmt.close();
		}catch(Exception e){
			System.out.println("删除失败");
			e.printStackTrace();
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}

	public int insert(UserInfo user) {
		PreparedStatement pStmt=null;
		int count=0;
		try {
			con=DBConnection.getConnection();
			pStmt = con.prepareStatement("INSERT INTO t_user(VC_LOGIN_NAME,VC_PASSWORD,Authority) VALUES(?,?,?)");
			//TODO 预编译SQL语句参数的设置
			pStmt.setString(1,user.getUserName());
			pStmt.setString(2,user.getUserPwd());
			pStmt.setInt(3,user.getAuth());

			count=pStmt.executeUpdate();
			pStmt.close();
		} catch (Exception e) {
			System.out.println("添加用户失败！");
			e.printStackTrace();
		} finally{
			DBConnection.closeConnection();
		}
		return count;
	}
	public ArrayList<UserInfo> GetUserInfo(int type) {
		ArrayList<UserInfo> user_list = new ArrayList<>();
		UserInfo user=null;
		PreparedStatement pStmt=null;
		ResultSet rs = null;
		try {
			//链接数据库
			con = DBConnection.getConnection();
			if(type == 1){
				pStmt = con.prepareStatement("SELECT * FROM t_user WHERE Authority = 2");
			}else if(type == 0){
				pStmt = con.prepareStatement("SELECT * FROM t_user WHERE Authority != 0");
			}

			//pStmt.setString(1, userName);
			rs = pStmt.executeQuery();
			//遍历封装
			while(rs.next()) {
				user=new UserInfo();
				user.setUserID(rs.getInt("N_USER_ID"));
				user.setUserName(rs.getString("VC_LOGIN_NAME"));
				user.setUserPwd(rs.getString("VC_PASSWORD"));
				user.setAuth(rs.getInt("Authority"));
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
