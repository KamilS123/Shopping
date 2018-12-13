package shop;

public class User {
    private int id;
    private String username;
    private String password;
    private int totalCashSpend;
    private String name;
    private String surname;
    private String role;

    public User(int id, String username, String password, int totalCashSpend, String name, String surname, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.totalCashSpend = totalCashSpend;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalCashSpend() {
        return totalCashSpend;
    }

    public void setTotalCashSpend(int totalCashSpend) {
        this.totalCashSpend = totalCashSpend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "shop.User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", totalCashSpend=" + totalCashSpend +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
