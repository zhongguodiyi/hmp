package course;
import java.sql.*;
import java.util.ArrayList;
import commom.DBConnection;
public class CourseDB {
    private Connection con = null;
    /* 获取所有课程信息 */
    public ArrayList<CourseInfo> getAll() {
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<CourseInfo> studentList=new ArrayList<CourseInfo>();
        try {
            con=DBConnection.getConnection();
            sql=con.createStatement();
            //TODO 1 执行查询语句获取所有课程信息
            rs = sql.executeQuery("SELECT * FROM t_course");
            //TODO 2 循环遍历课程信息结果集，将每条记录保存为一个课程信息对象，并把课程信息对象添加到数组studentList中
            while(rs.next()){

                CourseInfo course = new CourseInfo();
                course.setCourseID(rs.getInt("N_COURSE_ID"));
                course.setName(rs.getString("VC_COURSE_NAME"));
                course.setType(rs.getInt("N_TYPE"));
                course.setCredit(rs.getFloat("F_CREDIT"));
                course.setGrade(rs.getInt("N_GRADE"));
                course.setMajor(rs.getInt("N_MAJOR"));
                course.setDetail(rs.getString("VC_DETAIL"));

                studentList.add(course);
            }
            rs.close();
            sql.close();
        } catch (Exception e) {
            System.out.println("获取所有课程信息失败！");
        } finally{
            DBConnection.closeConnection();
        }
        return studentList;
    }

    public int insert(CourseInfo course) {
        PreparedStatement pStmt=null;
        int count=0;
        try {
            con=DBConnection.getConnection();
            pStmt = con.prepareStatement("INSERT INTO t_course(VC_COURSE_NAME,N_TYPE,F_CREDIT,N_GRADE,N_MAJOR,VC_DETAIL) VALUES(?,?,?,?,?,?)");
            //TODO 预编译SQL语句参数的设置
            pStmt.setString(1,course.getName());
            pStmt.setInt(2,course.getType());
            pStmt.setFloat(3,course.getCredit());
            pStmt.setInt(4,course.getGrade());
            pStmt.setInt(5,course.getMajor());
            pStmt.setString(6,course.getDetail());

            count=pStmt.executeUpdate();
            pStmt.close();
        } catch (Exception e) {
            System.out.println("添加课程失败！");
            e.printStackTrace();
        } finally{
            DBConnection.closeConnection();
        }
        return count;
    }
    public int update(CourseInfo course) {
        PreparedStatement pStmt=null;
        int count=0;
        try {
            con=DBConnection.getConnection();
            pStmt = con.prepareStatement("UPDATE t_course SET N_TYPE=?,F_CREDIT=?,N_GRADE=?,N_MAJOR=?,VC_DETAIL=? WHERE N_COURSE_ID=?");
            //TODO 预编译SQL语句参数的设置
            pStmt.setInt(1,course.getType());
            pStmt.setFloat(2,course.getCredit());
            pStmt.setInt(3,course.getGrade());
            pStmt.setInt(4,course.getMajor());
            pStmt.setString(5,course.getDetail());
            pStmt.setInt(6,course.getCourseID());

            count=pStmt.executeUpdate();
            pStmt.close();
        } catch (Exception e) {
            System.out.println("修改课程失败！");
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
            pStmt = con.prepareStatement("DELETE from t_course WHERE N_COURSE_ID = ?");
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

}

