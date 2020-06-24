package grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int sex=Integer.parseInt(request.getParameter("sex"));
        int sub=Integer.parseInt(request.getParameter("subject"));
        float score=Float.parseFloat(request.getParameter("score"));
        StudentGrade stu=new StudentGrade(id,name,sex,sub,score);
        gradeService service=new gradeService();
        request.getSession().setAttribute("flag",1);
        if(service.addGrade(stu)){
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
