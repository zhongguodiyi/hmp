package teach;

import java.util.ArrayList;

public class teachService {
    teachDao dao=new teachDao();
    public ArrayList<teachInfo> searchAll(){
        return dao.searchAll();
    }
    public boolean addTeaching(teachInfo stu){
        if(dao.insertTeaching(stu)){
            return true;
        }
        return false;
    }
    public boolean deleteTeaching(int id,int sub){
        if(dao.deleteTeaching(id,sub)){
            return true;
        }
        return false;
    }
    public boolean updateTeaching(teachInfo stu,int sub){
        if(dao.updateTeaching(stu,sub)){
            return true;
        }
        return false;
    }
    public ArrayList<teachInfo> searchTeaacher(int id){
        return dao.searchTeacher(id);
    }
    public ArrayList<teachInfo> searchSub(int sub){
        return dao.searchSub(sub);
    }
}
