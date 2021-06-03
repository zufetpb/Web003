package cn.edu.zufe.web003.servlet.seat;

import cn.edu.zufe.web003.bean.SeatService;
import cn.edu.zufe.web003.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ReturnSeatServlet", urlPatterns = "/ReturnSeatServlet")
public class ReturnSeatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String id = request.getParameter("id");
        String info = "";
        try {
            SeatService.returnSeat(user, Integer.parseInt(id));
            info = "归还成功";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("info",info);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
