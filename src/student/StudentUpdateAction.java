package student;

import commom.MyTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentUpdateAction")
public class StudentUpdateAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        /*int id = Integer.parseInt(request.getParameter("id"));*/
        int id = MyTools.strToint(request.getParameter("id"));

        StudentInfo info = new StudentInfo();
        info.setId(id);
        info.setCode(request.getParameter("code"));
        info.setName(request.getParameter("name"));
        info.setSex(MyTools.strToint(request.getParameter("sex")));
        info.setGrade(MyTools.strToint(request.getParameter("grade")));
        info.setMajor(MyTools.strToint(request.getParameter("major")));
        info.setDetail(request.getParameter("detail"));

        StudentDB db = new StudentDB();
        int i = db.update(info);
        System.out.println("修改：" + i);
        response.sendRedirect("StudentListAction");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
