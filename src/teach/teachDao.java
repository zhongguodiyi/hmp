package teach;

import commom.DBConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teachDao {
    private Connection con =null;
    public ArrayList<teachInfo> searchTeacher(int id){
        ArrayList<teachInfo> ar=new ArrayList<teachInfo>();
        PreparedStatement pStmt=null;
        ResultSet rs=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("select * from t_teaching where id=?");
            pStmt.setInt(1,id);
            rs=pStmt.executeQuery();
            while(rs.next()){
                teachInfo teach=new teachInfo();
                teach.setId(rs.getInt("id"));
                teach.settName(rs.getString("tName"));
                teach.setSubject(rs.getInt("subject"));
                ar.add(teach);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.closeConnection();
            try{
                pStmt.close();
                rs.close();
            }catch(SQLException a){
                a.printStackTrace();
            }
        }
        return ar;

    }
    public ArrayList<teachInfo> searchAll(){
        ArrayList<teachInfo> ar=new ArrayList<teachInfo>();
        PreparedStatement pStmt=null;
        ResultSet rs=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("select * from t_teaching");
            rs=pStmt.executeQuery();
            while(rs.next()){
                teachInfo teach=new teachInfo();
                teach.setId(rs.getInt("id"));
                teach.settName(rs.getString("tName"));
                teach.setSubject(rs.getInt("subject"));
                ar.add(teach);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.closeConnection();
            try{
                pStmt.close();
                rs.close();
            }catch(SQLException a){
                a.printStackTrace();
            }
        }
        return ar;

    }
    public ArrayList<teachInfo> searchSub(int subname){
        ArrayList<teachInfo> ar=new ArrayList<teachInfo>();
        PreparedStatement pStmt=null;
        ResultSet rs=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("select * from t_teaching where subject=?");
            pStmt.setInt(1,subname);
            rs=pStmt.executeQuery();
            while(rs.next()){
                teachInfo teach=new teachInfo();
                teach.setId(rs.getInt("id"));
                teach.settName(rs.getString("tName"));
                teach.setSubject(rs.getInt("subject"));
                ar.add(teach);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.closeConnection();
            try{
                pStmt.close();
                rs.close();
            }catch(SQLException a){
                a.printStackTrace();
            }
        }
        return ar;
    }
    public boolean insertTeaching(teachInfo teach){
        PreparedStatement pStmt=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("insert into t_teaching values(?,?,?)");
            pStmt.setInt(1,teach.getId());
            pStmt.setString(2,teach.gettName());
            pStmt.setInt(3,teach.getSubject());
            int count=pStmt.executeUpdate();
            if(count>0){
                return true;
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            DBConnection.closeConnection();
            try {
                pStmt.close();
            } catch (SQLException a) {
                a.printStackTrace();
            }
        }
    }
    public boolean deleteTeaching(int id,int sub){
        PreparedStatement pStmt=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("delete from t_teaching where id=? and subject=?");
            pStmt.setInt(1,id);
            pStmt.setInt(2,sub);
            int count=pStmt.executeUpdate();
            if(count>0){
                return true;
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            DBConnection.closeConnection();
            try {
                pStmt.close();
            } catch (SQLException a) {
                a.printStackTrace();
            }
        }
    }
    public boolean updateTeaching(teachInfo teach,int sub){
        PreparedStatement pStmt=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("update t_teaching set subject=? where id=? and subject=?");
            pStmt.setInt(1,teach.getSubject());
            pStmt.setInt(2,teach.getId());
            pStmt.setInt(3,sub);
            int count=pStmt.executeUpdate();
            if(count>0){
                return true;
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            DBConnection.closeConnection();
            try {
                pStmt.close();
            } catch (SQLException a) {
                a.printStackTrace();
            }
        }
    }
}
