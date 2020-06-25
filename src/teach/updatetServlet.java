package teach;

import grade.StudentGrade;
import grade.gradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/updatetServlet")
public class updatetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] subjects={"Java程序设计","数据库原理","数据结构","Web程序设计"};
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("tName");
        int sub=Integer.parseInt(request.getParameter("subject"));
        int qsub=(int)request.getSession().getAttribute("qsub");
        request.getSession().removeAttribute("qsub");
        teachInfo teach=new teachInfo(id,name,sub);
        teachService service=new teachService();
        request.getSession().setAttribute("flag",4);
        if(service.updateTeaching(teach,qsub)){
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
