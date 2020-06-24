package grade;

import commom.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class gradeDao {
    private Connection con =null;
    public ArrayList<StudentGrade> searchStuGrade(int sno){
        ArrayList<StudentGrade> grades=new ArrayList<StudentGrade>();
        PreparedStatement pStmt=null;
        ResultSet rs=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("select * from stu_grade where id=?");
            pStmt.setInt(1,sno);
            rs=pStmt.executeQuery();
            while(rs.next()){
                StudentGrade stu=new StudentGrade();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setSex(rs.getInt("sex"));
                stu.setSubject(rs.getInt("subject"));
                stu.setScore(rs.getFloat("score"));
                grades.add(stu);
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
        return grades;

    }
    public ArrayList<StudentGrade> searchAll(){
        ArrayList<StudentGrade> grades=new ArrayList<StudentGrade>();
        PreparedStatement pStmt=null;
        ResultSet rs=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("select * from stu_grade");
            rs=pStmt.executeQuery();
            while(rs.next()){
                StudentGrade stu=new StudentGrade();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setSex(rs.getInt("sex"));
                stu.setSubject(rs.getInt("subject"));
                stu.setScore(rs.getFloat("score"));
                grades.add(stu);
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
        return grades;

    }
    public ArrayList<StudentGrade> searchSubGrade(int subname){
        ArrayList<StudentGrade> grades=new ArrayList<StudentGrade>();
        PreparedStatement pStmt=null;
        ResultSet rs=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("select * from stu_grade where subject=?");
            pStmt.setInt(1,subname);
            rs=pStmt.executeQuery();
            while(rs.next()){
                StudentGrade stu=new StudentGrade();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setSex(rs.getInt("sex"));
                stu.setSubject(rs.getInt("subject"));
                stu.setScore(rs.getFloat("score"));
                grades.add(stu);
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
        return grades;
    }
    public boolean insertStuGrade(StudentGrade stu){
        PreparedStatement pStmt=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("insert into stu_grade values(?,?,?,?,?)");
            pStmt.setInt(1,stu.getId());
            pStmt.setString(2,stu.getName());
            pStmt.setInt(3,stu.getSex());
            pStmt.setInt(4,stu.getSubject());
            pStmt.setFloat(5,stu.getScore());
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
    public boolean deleteStuGrade(int id,int sub){
        PreparedStatement pStmt=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("delete from stu_grade where id=? and subject=?");
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
    public boolean updateStuGrade(StudentGrade stu){
        PreparedStatement pStmt=null;
        try{
            con= DBConnection.getConnection();
            pStmt=con.prepareStatement("update stu_grade set id=?,name=?,sex=?,subject=?, score=? where id=? and subject=?");
            pStmt.setInt(1,stu.getId());
            pStmt.setString(2,stu.getName());
            System.out.println("xiugai"+stu.getName());
            pStmt.setInt(3,stu.getSex());
            pStmt.setInt(4,stu.getSubject());
            pStmt.setFloat(5,stu.getScore());
            pStmt.setInt(6,stu.getId());
            pStmt.setInt(7,stu.getSubject());
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
