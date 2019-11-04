import java.util.ArrayList;

public class Ship {
    int id;
    String name;
    String type;
    ArrayList <ShipContainter> containers = new ArrayList<>();

    public Ship(int id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public String toString(){
        return id + " " + name + " " + type;
    }
}
