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
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
    private final String path = "C:\\Users\\Kamil\\Desktop\\userAndProduct.json";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //pobranie danych od użytkownika
        String newName = req.getParameter("create_name");
        String newSurname = req.getParameter("create_surname");
        String newUserName = req.getParameter("create_userName");
        String newPassword = req.getParameter("create_password");

        //odczyt danych
        ObjectMapper mapper = new ObjectMapper();
        //InputStream inStream = getServletContext().getResourceAsStream(path);
        UsersAndProducts usersAndProducts = mapper.readValue(new FileInputStream(path), UsersAndProducts.class);

        //utworzenie listy z urzytkownikami i produktami
        List<User>listOfUsers = new ArrayList<>((usersAndProducts.getUsers()));
        List<Product>listOfProducts = new ArrayList<>(usersAndProducts.getProducts());
        User newUser = new User(listOfUsers.size()+1,newUserName,newPassword,0,newName,newSurname,"user");

        //dodanie nowego użytkownika do listOfUsers
        listOfUsers.add(newUser);

        //utworzenie nowego obiektu UsersAndProducts przez dodanie listOfProducts i listOfUsers
        usersAndProducts = new UsersAndProducts(listOfProducts,listOfUsers);
        mapper.writeValue(new FileOutputStream(path),usersAndProducts);

        //przekierowanie do createUser.jsp
        RequestDispatcher rd = req.getRequestDispatcher("createUser.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
