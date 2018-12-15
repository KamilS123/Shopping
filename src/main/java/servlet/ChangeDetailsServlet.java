package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import shop.Product;
import shop.User;
import shop.UsersAndProducts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@WebServlet("/ChangeDetailsServlet")
public class ChangeDetailsServlet extends HttpServlet {
    private final String path = "C:\\Users\\Kamil\\Desktop\\userAndProduct.json";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        UsersAndProducts usersAndProducts = mapper.readValue(new FileInputStream(path),UsersAndProducts.class);

        List<User>userList = usersAndProducts.getUsers();
        List<Product>productList = usersAndProducts.getProducts();
        String name = req.getParameter("name");
        String surName = req.getParameter("surName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        Cookie[]cookies = req.getCookies();
        for(Cookie cookie : cookies) {
            if (cookie.getName().equals("user_cookie")) {
                User user = new User();
            }
        }


        RequestDispatcher rd = req.getRequestDispatcher("log.jsp");
        rd.forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
