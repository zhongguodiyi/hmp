package grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/searchSubGradeServlet")
public class searchSubGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int sub=Integer.parseInt(request.getParameter("sub"));
        gradeService service=new gradeService();
        ArrayList<StudentGrade> ar=service.searchSubGrade(sub);
        request.getSession().setAttribute("flag",5);
        if(ar!=null){
            request.getSession().setAttribute("stuGrades",ar);
            response.getWriter().print(true);
        }
        else{
            response.getWriter().print(false);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
