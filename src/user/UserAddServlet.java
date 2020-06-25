package user;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        int auth = Integer.parseInt(request.getParameter("auth"));

        UserInfo user = new UserInfo();
        user.setUserName(name);
        user.setUserPwd(pwd);
        user.setAuth(auth);

        UserDB userBean = new UserDB();
        int count = userBean.insert(user);
        String msg = null;
        if(count == 1){
            msg = "成功添加！";
        }else {
            msg = "添加失败！";
        }
        ObjectMapper obj = new ObjectMapper();
        String str = obj.writeValueAsString(msg);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
