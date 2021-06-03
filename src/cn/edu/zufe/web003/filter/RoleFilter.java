package cn.edu.zufe.web003.filter;

import cn.edu.zufe.web003.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "RoleFilter", urlPatterns = "/*")
public class RoleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String[] noFilters = {"login.jsp", "index.jsp", "register.jsp", "RegisterServlet", "VerifyCodeServlet", "LoginServlet", "SeatListServlet", ".json", ".js", ".css", ".ico", ".jpg", ".png"};
        String uri = request.getRequestURI();
        boolean pass = false;
        for (String item : noFilters) {
            if (uri.endsWith(item)) pass = true;
        }
        if (user != null || pass) {
            chain.doFilter(req, resp);
        } else {
            request.setAttribute("info", "请先登录!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
