import com.google.gson.Gson;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public class HW
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Домашнее задание реализовывать здесь

    Properties properties = new Properties();
    properties.load(new FileReader(new File("pizza.properties")));

    Pizza hawaii_pizza = new Pizza() ;
    hawaii_pizza.dough.size = properties.getProperty("dough.size");
    hawaii_pizza.dough.type = properties.getProperty("dough.type");
    hawaii_pizza.filling = properties.getProperty("pizza.filling");

    // Сереализация
    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("hawaii_pizza.serealize"));
    outputStream.writeObject(hawaii_pizza);
    outputStream.close();

    // Десереализация
    ObjectInputStream inputStream = new ObjectInputStream((new FileInputStream("hawaii_pizza.serealize")));
    Pizza pizzaResulted_1 = (Pizza) inputStream.readObject();
    inputStream.close();
    System.out.println("испеклась первая пицца: " + pizzaResulted_1);

    // Сереализация json
    Gson gson = new Gson();
    File file = new File ("hawaii_pizza.json");
    String jsonString = gson.toJson(hawaii_pizza);
    Files.write(Paths.get("hawaii_pizza.json"), jsonString.getBytes());

    // Десереализация json
    jsonString = new String(Files.readAllBytes(Paths.get("hawaii_pizza.json")), StandardCharsets.UTF_8);
    Pizza pizzaResulted_2 = gson.fromJson(jsonString,Pizza.class);
    System.out.println("испеклась вторая пицца: " + pizzaResulted_2);

    }
}
