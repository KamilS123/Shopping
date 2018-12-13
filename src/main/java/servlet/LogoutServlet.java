package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //pobranie ciasteczek
        Cookie[]cookies = req.getCookies();
        for(Cookie cookie : cookies) {
            //jeśli ciasteczko na nazwe user_cookie to ustaw mu age na 0
            if(cookie.getName().equals("user_cookie")) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        //przekieruj do log.js
        resp.sendRedirect("log.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
