package teach;

import grade.gradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletetServlet")
public class deletetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String ssub=request.getParameter("sub");
        System.out.println(ssub);
        String[] subjects={"Java程序设计","数据库原理","数据结构","Web程序设计"};
        int sub=0;
        for(int i=0;i<subjects.length;i++){
            if(ssub.equals(subjects[i])){
                sub=i;
                break;
            }
        }
        teachService service=new teachService();
        if(service.deleteTeaching(id,sub)){
            response.getWriter().print(true);
        }
        else{
            response.getWriter().print(false);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
