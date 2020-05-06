package sample;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Database implements Serializable {
    private PreparedStatement ps;
    private static ResultSet rs;
    private Scanner in = new Scanner(System.in);
    private Connection connection;
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private String databaseURL = "jdbc:mysql://localhost:3306/nurdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "";
    private static ArrayList <Client> clients = new ArrayList<>();
    private static ArrayList <Food> foods = new ArrayList<>();
    private static ArrayList <Order> orders = new ArrayList<>();
    public Database() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(databaseURL, user , password);
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public boolean changePassword(String login,String newPassword) {
        try {
            ps = connection.prepareStatement("SELECT * FROM client");
            rs = ps.executeQuery();
            while (rs.next()) {
                String login1 = rs.getString("login");
                if (login.equals(login1)) {
                    int id = rs.getInt("id");
                    ps = connection.prepareStatement("UPDATE client set password = ? WHERE id = ?");
                    ps.setString(1,newPassword);
                    ps.setInt(2,id);
                    ps.executeUpdate();
                    return true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkAdmin(String name,String password) {
        try {
            ps = connection.prepareStatement("SELECT * FROM admin");
            rs = ps.executeQuery();
            while (rs.next()) {
                String name1 = rs.getString("name");
                String password1 = rs.getString("password");
                if (name.equals(name1) && password.equals(password1)) {
                    return true;
                }
            }
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    return false;
    }

    public static int price ;
    public ArrayList<Order> getOrder() {
        ArrayList <Order> orders = new ArrayList<>();
        try {
            ps = connection.prepareStatement("SELECT * FROM onlineorder");
            rs = ps.executeQuery();
            while (rs.next()) {
                String nameOfFood = rs.getString("nameOfFood");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                orders.add(new Order(nameOfFood,name,price));
            }
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
    public boolean addOrder(String nameOfFood,String name) {
        try {
            ps = connection.prepareStatement("SELECT * FROM food");
            rs = ps.executeQuery();
            while (rs.next()) {
                String nameOfFood1 = rs.getString("name");
                if (nameOfFood.equals(nameOfFood1)) {
                     price = rs.getInt("price");
                }
            }
            ps = connection.prepareStatement("INSERT INTO onlineorder VALUES(?,?,?)");
            ps.setString(1,nameOfFood);
            ps.setString(2,name);
            ps.setInt(3,price);
            orders.add(new Order(nameOfFood,name,price));
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Food> getFood() {
        ArrayList <Food> foods = new ArrayList<>();
        try {
           ps = connection.prepareStatement("SELECT * FROM food" );
           rs = ps.executeQuery();
           while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                foods.add(new Food(id,type,name,price));
           }
           ps.executeUpdate();
       }
       catch (Exception e) {
           e.printStackTrace();
       }
        return foods;
    }
    public int checkClient(String login,String password) {
        try {
            ps = connection.prepareStatement("SELECT * FROM client");
            rs = ps.executeQuery();
            while (rs.next()) {
                String login1 = rs.getString("login");
                String password1 = rs.getString("password");
                if (login.equals(login1) && password.equals(password1)) {
                    return rs.getInt("id");
                }
            }
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<Client>  getClient() {
        ArrayList <Client> clients = new ArrayList<>();
        try {
            ps = connection.prepareStatement("SELECT * FROM client");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String mobilePhone = rs.getString("mobilePhone");
                clients.add(new Client(id,login,password,email,mobilePhone));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return clients;
    }
    public boolean addClient(Client client) {
        try {
            ps = connection.prepareStatement("INSERT INTO client VALUES(null,?,?,?,?)");
            ps.setString(1,client.getLogin());
            ps.setString(2,client.getPassword());
            ps.setString(3,client.getEmail());
            ps.setString(4,client.getMobilePhone());
            clients.add(client);
            ps.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
