package grade;

import java.util.ArrayList;

public class gradeService {
    gradeDao dao=new gradeDao();
    public ArrayList<StudentGrade> searchAll(){
        return dao.searchAll();
    }
    public boolean addGrade(StudentGrade stu){
        if(dao.insertStuGrade(stu)){
            return true;
        }
        return false;
    }
    public boolean deleteGrade(int id,int sub){
        if(dao.deleteStuGrade(id,sub)){
            return true;
        }
        return false;
    }
    public boolean updateGrade(StudentGrade stu){
        if(dao.updateStuGrade(stu)){
            return true;
        }
        return false;
    }
    public ArrayList<StudentGrade> searchStuGrade(int sno){
        return dao.searchStuGrade(sno);
    }
    public ArrayList<StudentGrade> searchSubGrade(int sub){
        return dao.searchSubGrade(sub);
    }
}
