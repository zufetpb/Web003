package cn.edu.zufe.web003.servlet.user;

import cn.edu.zufe.web003.bean.User;
import cn.edu.zufe.web003.bean.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GetUserServlet", urlPatterns = "/GetUserServlet")
public class GetUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        User user = new User();
        try {
            user = UserService.getUserById(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("user",user);
        if("detail".equals(type)){
            request.getRequestDispatcher("/jsp/userInfo.jsp").forward(request, response);
        } else if("update".equals(type)){
            request.getRequestDispatcher("/jsp/userUpdate.jsp").forward(request, response);
        }
    }
}
