package room;

import commom.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDB {

    private Connection connection = null;

    public List<Room> findAll(){
        List<Room> list = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            list = new ArrayList<Room>();
            statement = connection.prepareStatement("select * from t_room");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Room room = new Room();
                room.setId(resultSet.getInt(1));
                room.setCode(resultSet.getString(2));
                room.setLocation(resultSet.getString(3));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    public int insert(Room room){
        PreparedStatement preparedStatement = null;
        int count = 0;

        try {
            Connection connection = this.connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("insert into t_room(code,location) values (?,?)");
            preparedStatement.setString(1,room.getCode());
            preparedStatement.setString(2,room.getLocation());
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
            preparedStatement = connection.prepareStatement("delete from t_room where id = ?");
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

    public Room findById(int id){
        Room room = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("select * from t_room where id = ?;");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                room = new Room(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
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
        return room;
    }

    public int update(Room room){
        PreparedStatement statement = null;
        int count = 0;

        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("update t_room set code=?,location=? where id = ?");
            statement.setString(1,room.getCode());
            statement.setString(2,room.getLocation());
            statement.setInt(3,room.getId());
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
