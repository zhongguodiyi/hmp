package grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/searchStuGradeServlet")
public class searchStuGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        gradeService service=new gradeService();
        ArrayList<StudentGrade> ar=service.searchStuGrade(id);
        if(ar!=null){
            request.getSession().setAttribute("stuGrades",ar);
            response.getWriter().print(true);
        }
        else{
            System.out.println("c");
            response.getWriter().print(false);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
