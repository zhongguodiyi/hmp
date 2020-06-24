package user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int type = Integer.parseInt(request.getParameter("type"));
        UserDB userBean = new UserDB();
        ArrayList<UserInfo> list = new ArrayList<>();
        list = userBean.GetUserInfo(type);
        request.getSession().setAttribute("UserList",list);
        response.sendRedirect(request.getContextPath()+"/user/user_list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
