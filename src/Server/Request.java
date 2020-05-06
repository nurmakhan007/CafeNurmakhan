package Server;
import sample.Client;
import sample.Food;
import sample.Order;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Request implements Serializable {
    private String operationType;
    private String login;
    private String password;
    private Client client;
    private ArrayList <Client> clients;
    private ArrayList <Food> foods;
    private ArrayList <Order> orders;
    public Request() {

    }
    public Request(String operationType,String login,String password) {
        this.operationType = operationType;
        this.login = login;
        this.password = password;
    }
    public Request(String operationType,Client client) {
        this.operationType = operationType;
        this.client = client;
    }
    public Request(String operationType,ArrayList <Client> clients,ArrayList <Food> foods,ArrayList<Order>orders) {
        this.operationType = operationType;
        this.clients = clients;
        this.foods = foods;
        this.orders = orders;
    }

    public Request(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Request{" +
                "operationType='" + operationType + '\'' +
                '}';
    }
}