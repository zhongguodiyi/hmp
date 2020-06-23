package course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CourseListAction")
public class CourseListAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        CourseDB beanDB = new CourseDB();
        request.setCharacterEncoding("UTF-8");
        request.getSession().setAttribute("CourseList",beanDB.getAll());
        response.sendRedirect(request.getContextPath()+"/course/course_list.jsp");
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
