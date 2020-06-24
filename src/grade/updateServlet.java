package grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] subjects={"Java程序设计","数据库原理","数据结构","Web程序设计"};
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int sex=0;
        if(request.getParameter("sex").equals("女")){
            sex=1;
        }
        String Sub=request.getParameter("subject");
        int sub=0;
        for(int i=0;i<subjects.length;i++){
            if(Sub.equals(subjects[i])){
                sub=i;
                break;
            }
        }
        float score=Float.parseFloat(request.getParameter("score"));
        StudentGrade stu=new StudentGrade(id,name,sex,sub,score);
        gradeService service=new gradeService();
        request.getSession().setAttribute("flag",3);
        if(service.updateGrade(stu)){
            response.sendRedirect("grade/resSuccessShow.jsp");
        }
        else{
            response.sendRedirect("grade/resFailShow.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
