package student;

import commom.MyTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentInsertAction")
public class StudentInsertAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        StudentInfo info = new StudentInfo();
        info.setCode(request.getParameter("code"));
        info.setName(request.getParameter("name"));
        info.setSex(MyTools.strToint(request.getParameter("sex")));
        info.setGrade(MyTools.strToint(request.getParameter("grade")));
        info.setMajor(MyTools.strToint(request.getParameter("major")));
        info.setDetail(request.getParameter("detail"));

        StudentDB db = new StudentDB();
        int count = db.insert(info);
        response.sendRedirect("StudentListAction");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
