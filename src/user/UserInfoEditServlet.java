package user;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserInfoEditServlet")
public class UserInfoEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName=request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String msg = null;
        int id = Integer.parseInt(request.getParameter("userId"));

        UserDB userBean = new UserDB();
        UserInfo user = userBean.GetUserbyId(id);
        user.setUserName(userName);
        user.setUserPwd(pwd);
        int count = userBean.update(user);
        System.out.println(count);
        if(count == 1){
            msg="修改成功";
        }else {
            msg="修改失败";
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
