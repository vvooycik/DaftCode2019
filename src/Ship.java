import java.util.ArrayList;

public class Ship {
    int id;
    String name;
    String type;
    ArrayList containters = new ArrayList<ShipContainter>();

    public Ship(int id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
