import java.io.Serializable;

public class Pizza implements Serializable
{

    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough +
                ", filling='" + filling + '\'' +
                '}';
    }

    Dough dough = new Dough();
    String filling;
}
