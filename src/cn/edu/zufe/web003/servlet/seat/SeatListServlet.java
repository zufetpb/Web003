package cn.edu.zufe.web003.servlet.seat;

import cn.edu.zufe.web003.bean.Seat;
import cn.edu.zufe.web003.bean.SeatService;
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

@WebServlet(name = "SeatListServlet", urlPatterns = "/SeatListServlet")
public class SeatListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Seat> seats = new ArrayList<>();
        try {
            seats = SeatService.getSeats();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("seats",seats);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
