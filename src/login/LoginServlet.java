package login;

import com.fasterxml.jackson.databind.ObjectMapper;
import user.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String result = null;
        //System.out.println(name);
        //System.out.println(pwd);
        UserDB userBean = new UserDB();
        UserInfo user = userBean.GetUserbyName(name);
        ObjectMapper obj = new ObjectMapper();
        if (user == null) {
            result="1";
            result= obj.writeValueAsString(result);
        }else if(!user.getUserPwd().equals(pwd)){
            result="2";
            result= obj.writeValueAsString(result);
        }else{
            request.getSession().setAttribute("user",user);
            result=obj.writeValueAsString(user);
        }

        //System.out.println("result:"+result);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(result);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
