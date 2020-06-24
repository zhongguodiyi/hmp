package teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TeacherUpdate")
public class TeacherUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("????");
        System.out.println("id="+id);
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String title = request.getParameter("title");

        Teacher teacher = new Teacher(id,code,name,sex,age,title);
        TeacherDB db = new TeacherDB();
        int update = db.update(teacher);

        response.sendRedirect(request.getContextPath()+"/teacher/teacher_list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
