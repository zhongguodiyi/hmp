package teach;

import grade.StudentGrade;
import grade.gradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addtServlet")
public class addtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String tName=request.getParameter("tName");
        int subject=Integer.parseInt(request.getParameter("subject"));
        teachInfo teach=new teachInfo(id,tName,subject);
        teachService service=new teachService();
        request.getSession().setAttribute("flag",3);
        if(service.addTeaching(teach)){
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
