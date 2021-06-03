package cn.edu.zufe.web003.servlet.user;

import cn.edu.zufe.web003.bean.User;
import cn.edu.zufe.web003.bean.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String verifyCode = request.getParameter("verifyCode");

        HttpSession session = request.getSession();

        User user = null;
        try {
            user = UserService.login(userName,passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user != null && session.getAttribute("verifyCode").equals(verifyCode.toLowerCase())){
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", userName);
            request.setAttribute("info", "Welcome " + userName);

        } else{
            if(session.getAttribute("verifyCode").equals(verifyCode.toLowerCase())){
                request.setAttribute("info", "Wrong user name or password, please try again!");
            } else{
                request.setAttribute("info", "Verification code error please try again!");
            }
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
