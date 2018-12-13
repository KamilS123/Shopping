package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    //utworzenie stałej ze scieżką do pliku
    private final String path = "C:\\Users\\Kamil\\Desktop\\userAndProduct.json";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //stworzenie ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //scieżka do pliku w programie
        //InputStream inStream = getServletContext().getResourceAsStream("WEB-INF\\jsonV1_json.json");

        //wczytanie UsersAndProducts
        UsersAndProducts usersAndProducts = mapper.readValue(new FileInputStream(path), UsersAndProducts.class);

        //utworzenie listy z userami
        List<User> listOfUsers = usersAndProducts.getUsers();

        //pobranie od użytkownika danych
        String name = req.getParameter("name").trim();
        String surname = req.getParameter("surname").trim();
        String password = req.getParameter("code").trim();

        //warunek, jeśli Obiekt User zawiera elementy z listy userów to przenies do webIntro.jsp, jesli nie są takie same to wyswietl czerwony komunikat Wrong data
        Boolean isLoginOk = false;
        for (User user : listOfUsers) {
            if (name!=null & name.equals(user.getName()) && surname!=null & surname.equals(user.getSurname()) && password!=null & password.equals(user.getPassword())) {
                Cookie cookie = new Cookie("user_cookie",name);
                cookie.setMaxAge(15*60);
                resp.addCookie(cookie);
                req.getSession().setAttribute("button", user.getName());
                /*RequestDispatcher rd = req.getRequestDispatcher("webIntro.jsp");
                rd.forward(req, resp);*/
                resp.sendRedirect("webIntro.jsp");
                isLoginOk = true;
            }
            if(!isLoginOk) {
                RequestDispatcher rd = req.getRequestDispatcher("/log.jsp");
                resp.getWriter()
                        .println("<font color=red> Wrong data </font>");

                rd.include(req, resp);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
