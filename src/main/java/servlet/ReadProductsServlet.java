package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import shop.Product;
import shop.UsersAndProducts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@WebServlet("/ReadProductsServlet")
public class ReadProductsServlet extends HttpServlet {
    private final String path = "C:\\Users\\Kamil\\Desktop\\userAndProduct.json";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UsersAndProducts usersAndProducts = objectMapper.readValue(new FileInputStream(path), UsersAndProducts.class);
        List<Product>listOfProducts = usersAndProducts.getProducts();

        req.getSession().setAttribute("productList",listOfProducts);
        RequestDispatcher rd = req.getRequestDispatcher("productList.jsp");
        rd.forward(req,resp);
        /*InputStream inStream = getServletContext().getResourceAsStream("/WEB-INF/userAndProduct.json");
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream,"UTF-8"));

        UsersAndProducts usersAndProducts = gson.fromJson(bufferedReader,UsersAndProducts.class);

        List<Product>listOfProducts = usersAndProducts.getProducts();
        req.getSession().setAttribute("productList",listOfProducts);

        RequestDispatcher rd = req.getRequestDispatcher("productList.jsp");
        rd.forward(req,resp);*/
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
