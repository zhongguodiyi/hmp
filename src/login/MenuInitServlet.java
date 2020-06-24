package login;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MenuInitServlet")
public class MenuInitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //取出id
        int id = Integer.parseInt(request.getParameter("id"));
        UserDB userBean = new UserDB();
        UserInfo user = userBean.GetUserbyId(id);

        int type = user.getAuth();
        //处用户管理外的菜单，要改改这个 下面两个是分流用的管理员菜单
        String menuList =
                "\t{\"main\":\"学生管理\",\"sub\":[\n" +
                "\t\t{\"name\":\"专业信息管理\",\"link\":\"waiting.html\"},\n" +
                "\t\t{\"name\":\"院系信息管理\",\"link\":\"waiting.html\"},\n" +
                "\t\t{\"name\":\"学生信息管理\",\"link\":\"StudentListAction\"}]},\n" +
                "\t{\"main\":\"课程管理\",\"sub\":[{\"name\":\"课程信息管理\",\"link\":\"CourseListAction\"}]},\n" +
                "\t{\"main\":\"成绩管理\",\"sub\":[\n" +
                "\t\t{\"name\":\"学生成绩查询\",\"link\":\"grade/searchStuGrade.jsp\"},\n" +
                "\t\t{\"name\":\"课程成绩查询\",\"link\":\"grade/searchSubGrade.jsp\"},\n" +
                "\t\t{\"name\":\"成绩列表\",\"link\":\"searchAllServlet\"}]}\n" +
                "]";

        String P_menuList = "{\"main\":\"用户信息管理\",\"sub\":[{\"name\":\"个人信息管理\",\"link\":\"\"}]},";

        String A_menuList = "{\"main\":\"用户信息管理\",\"sub\":[\n" +
                "\t\t{\"name\":\"个人信息管理\",\"link\":\"waiting.html\"},\n" +
                "\t\t{\"name\":\"普通用户信息管理\",\"link\":\"waiting.html\"}]},";

        String S_menuList = "{\"main\":\"用户信息管理\",\"sub\":[\n" +
                "\t\t{\"name\":\"个人信息管理\",\"link\":\"waiting.html\"},\n" +
                "\t\t{\"name\":\"普通用户信息管理\",\"link\":\"waiting.html\"},\n" +
                "\t\t{\"name\":\"管理员变更\",\"link\":\"waiting.html\"}]},";

        if(type == 2){
            menuList = "[ \n" + P_menuList + menuList;
        }else if(type == 1){
            menuList = "[ \n" + A_menuList + menuList;
        }else if(type == 0){
            menuList = "[ \n" + S_menuList + menuList;
        }

        ObjectMapper obj = new ObjectMapper();
        String list = obj.writeValueAsString(menuList);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(list);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
