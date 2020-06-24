package student;

import common.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDB {
    private Connection connection = null;

    public List<StudentInfo> findAll(){

        List<StudentInfo> list = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("select * from t_student");
            resultSet = statement.executeQuery();
            list = new ArrayList<StudentInfo>();
            while (resultSet.next()){
                StudentInfo stduent = new StudentInfo();
                stduent.setId(resultSet.getInt(1));
                stduent.setCode(resultSet.getString(2));
                stduent.setName(resultSet.getString(3));
                stduent.setSex(resultSet.getInt(4));
                stduent.setGrade(resultSet.getInt(5));
                stduent.setMajor(resultSet.getInt(6));
                stduent.setDetail(resultSet.getString(7));
                list.add(stduent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;

    }

    public int insert(StudentInfo studentInfo){
        PreparedStatement statement = null;
        int count = 0;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("insert into t_student values (null,?,?,?,?,?,?)");
            statement.setString(1,studentInfo.getCode());
            statement.setString(2,studentInfo.getName());
            statement.setInt(3,studentInfo.getSex());
            statement.setInt(4,studentInfo.getGrade());
            statement.setInt(5,studentInfo.getMajor());
            statement.setString(6,studentInfo.getDetail());

            count = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    public int update(StudentInfo studentInfo){
        PreparedStatement statement = null;
        int count = 0;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("update t_student set VC_STUDENT_CODE = ?,N_SEX = ?," +
                    "N_GRADE =?,N_MAJOR = ?,VC_DETAIL = ?,VC_STUDENT_NAME =? where N_STUDENT_ID = ?");
            statement.setString(1,studentInfo.getCode());
            statement.setInt(2,studentInfo.getSex());
            statement.setInt(3,studentInfo.getGrade());
            statement.setInt(4,studentInfo.getMajor());
            statement.setString(5,studentInfo.getDetail());
            statement.setString(6,studentInfo.getName());
            statement.setInt(7,studentInfo.getId());
            count = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    public int delete(String code) {
        PreparedStatement statement = null;
        int count = 0;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("delete from t_student where VC_STUDENT_CODE = ?");
            statement.setString(1,code);
            count = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    public StudentInfo findOne(String code){
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        StudentInfo info = new StudentInfo();
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("select * from t_student where VC_STUDENT_CODE = ?");
            statement.setString(1,code);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                info.setId(resultSet.getInt(1));
                info.setCode(resultSet.getString(2));
                info.setName(resultSet.getString(3));
                info.setSex(resultSet.getInt(4));
                info.setGrade(resultSet.getInt(5));
                info.setMajor(resultSet.getInt(6));
                info.setDetail(resultSet.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return info;
    }

}
