package teacher;

import commom.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDB {

    private Connection connection = null;

    public List<Teacher> findAll(){
        List<Teacher> list = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("select * from t_teacher");
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<Teacher>();
            while (resultSet.next()){
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt(1));
                teacher.setCode(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setSex(resultSet.getString(4));
                teacher.setAge(resultSet.getString(5));
                teacher.setTitle(resultSet.getString(6));
                list.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    public int insert(Teacher teacher){
        PreparedStatement preparedStatement = null;
        int count = 0;

        try {
            Connection connection = this.connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("insert into t_teacher(code,name,sex,age,title) values (?,?,?,?,?)");
            preparedStatement.setString(1,teacher.getCode());
            preparedStatement.setString(2,teacher.getName());
            preparedStatement.setString(3,teacher.getSex());
            preparedStatement.setString(4,teacher.getAge());
            preparedStatement.setString(5,teacher.getTitle());
            count = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return count;
    }

    public int delete(int id){

        PreparedStatement preparedStatement = null;
        int count = 0;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("delete from t_teacher where id = ?");
            preparedStatement.setInt(1,id);
            count = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.closeConnection();
        }
        return count;
    }

    public Teacher findById(int id){
        Teacher teacher = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("select * from t_teacher where id = ?;");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                /*teacher.setId(resultSet.getInt(1));
                teacher.setCode(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setSex(resultSet.getString(4));
                teacher.setAge(resultSet.getString(5));
                teacher.setTitle(resultSet.getString(6));*/
                teacher = new Teacher(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
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
        return teacher;
    }

    public int update(Teacher teacher){
        PreparedStatement statement = null;
        int count = 0;

        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("update t_teacher set code=?,name=?,sex=?,age=?,title=? where id = ?");
            statement.setString(1,teacher.getCode());
            statement.setString(2,teacher.getName());
            statement.setString(3,teacher.getSex());
            statement.setString(4,teacher.getAge());
            statement.setString(5,teacher.getTitle());
            statement.setInt(6,teacher.getId());
            count= statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.closeConnection();
        }
        return count;
    }
}
