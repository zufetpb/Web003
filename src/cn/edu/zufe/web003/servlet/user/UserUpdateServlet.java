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

@WebServlet(name = "UserUpdateServlet", urlPatterns = "/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserService.getUserFromRequest(request);
        String info = "";
        try {
            if((int) request.getSession().getAttribute("userId")  == Integer.parseInt(request.getParameter("id"))) {
                UserService.update(Integer.parseInt(request.getParameter("id")), user);
                info = "恭喜你，修改成功！";
            } else {
                info = "对不起没有修改权限! ";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("info",info);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
