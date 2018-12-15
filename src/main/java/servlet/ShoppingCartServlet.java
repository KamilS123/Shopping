package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import shop.Product;
import shop.User;
import shop.UsersAndProducts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    private final String pathOut = "C:\\Users\\Kamil\\Desktop\\ShoppingCart.json";
    private final String path = "C:\\Users\\Kamil\\Desktop\\userAndProduct.json";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Long id = null;

         Enumeration iterator = req.getParameterNames();
         while(iterator.hasMoreElements()) {
             String parameterName = (String) iterator.nextElement();
             if(parameterName.contains("produkt_")) {
                 String iden = req.getParameter(parameterName);
                 id = Long.parseLong(iden);
                 break;
             }
         }
         System.out.println("Produkt " + id);

         UsersAndProducts usersAndProducts = mapper.readValue(new FileInputStream(path),UsersAndProducts.class);
         List<Product>listWithProducts = usersAndProducts.getProducts();
         List<User>userList = usersAndProducts.getUsers();

         List<Product>newList = new ArrayList<>();

         for(Product p : listWithProducts) {
             if(id==p.getId()) {
                 newList.add(p);
             }
         }
         usersAndProducts = new UsersAndProducts(newList,userList);
         mapper.writeValue(new FileOutputStream(pathOut),usersAndProducts);

        req.getSession().setAttribute("productCart",newList);
        RequestDispatcher rd = req.getRequestDispatcher("productList.jsp");
        rd.forward(req,resp);
        //resp.sendRedirect("productList.jsp");
                 // znalezc produkt w jsonie po id


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
