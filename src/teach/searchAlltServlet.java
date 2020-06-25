package teach;

import teach.teachService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/searchAlltServlet")
public class searchAlltServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        teachService service=new teachService();
        ArrayList<teachInfo> ar=service.searchAll();
        request.getSession().setAttribute("teachAllList",ar);
        response.sendRedirect(request.getContextPath()+"/teach/teach_List.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
