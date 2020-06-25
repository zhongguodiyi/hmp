package user;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserAuthEditServlet")
public class UserAuthEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserDB userBean = new UserDB();
        int id = Integer.parseInt(request.getParameter("id"));
        UserInfo user = userBean.GetUserbyId(id);
        int count = userBean.editAuth(user);
        if(count == 1){
            response.sendRedirect(request.getContextPath()+"/user/user_auth.jsp");
        }else {
            System.out.println("修改失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
