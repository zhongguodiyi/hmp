package user;

import com.fasterxml.jackson.databind.ObjectMapper;

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
        ObjectMapper obj = new ObjectMapper();
        String str = obj.writeValueAsString(list);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(str);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
