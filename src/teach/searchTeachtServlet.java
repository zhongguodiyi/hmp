package teach;

import grade.StudentGrade;
import grade.gradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/searchTeachtServlet")
public class searchTeachtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        teachService service=new teachService();
        ArrayList<teachInfo> ar=service.searchTeaacher(id);
        if(ar!=null){
            request.getSession().setAttribute("teachList",ar);
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
