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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserListServlet",urlPatterns = "/UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<User> users = new ArrayList<>();
        try {
            users = UserService.getUsers(keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("users",users);
        request.getRequestDispatcher("/jsp/userList.jsp").forward(request,response);
//        response.sendRedirect( request.getContextPath() + "/jsp/userList.jsp");
    }
}
