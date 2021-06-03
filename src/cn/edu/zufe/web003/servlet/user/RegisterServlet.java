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

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserService.getUserFromRequest(request);
        try {
            UserService.insert(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("info","恭喜你，注册成功！");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
