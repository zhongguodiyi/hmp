package room;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RoomList")
public class RoomList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RoomDB db = new RoomDB();
        List<Room> list = db.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(list);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(string);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
