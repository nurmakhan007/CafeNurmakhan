package Server;
import sample.Client;
import sample.Food;
import sample.Main;
import sample.Order;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ClientHandler {
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;
    public static ArrayList<Client> clients;
    public static ArrayList <Food> foods;
    public static ArrayList <Order> orders;
    static {
        try {
            oos = new ObjectOutputStream(Main.socket.getOutputStream());
            ois = new ObjectInputStream(Main.socket.getInputStream());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeRequest(String operationType) throws IOException {
        oos.writeObject(new Request(operationType));
    }

    public void writeRequest(String operationType,String nickname,String password) throws IOException {
        oos.writeObject(new Request(operationType,nickname,password));
    }

    public boolean writeRequest(String operationType,Client client) throws IOException {
        oos.writeObject(new Request(operationType,client));
        return true;
    }


    public void writeRequest(String operationType,ArrayList<Client> clients,ArrayList <Food> foods, ArrayList <Order> orders) throws IOException {
        oos.writeObject(new Request(operationType,clients,foods,orders));
    }
    public boolean checkRequest(String operationType) {
        try {
            Request request;
            request = (Request) ois.readObject();
            if (request.getOperationType().equals(operationType)) {
                clients = request.getClients();
                foods = request.getFoods();
                orders = request.getOrders();
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
