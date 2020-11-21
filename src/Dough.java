import java.io.Serializable;

public class Dough implements Serializable
{


String size;
String type;

    @Override
    public String toString() {
        return "Dough{" +
                "size='" + size + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
