package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import shop.Product;
import shop.UsersAndProducts;

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
import java.util.List;

@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
    private final String path = "C:\\Users\\Kamil\\Desktop\\ShoppingCart.json";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Product products = mapper.readValue(new FileInputStream(path),Product.class);
        List<Product>listWithProducts = new ArrayList<>(Arrays.asList(new Product(products.getId(),products.getName(),products.getDescription(),products.getPrice(),products.getQuantity())));

        Product product = new Product();
        product.getId();
        product.getDescription();
        product.getName();
        product.getPrice();
        product.getQuantity();

        listWithProducts.add(product);
        mapper.writeValue(new FileOutputStream(path),listWithProducts);

        req.setAttribute("productCart",listWithProducts);
        resp.sendRedirect("productList.jsp");
    }
}
