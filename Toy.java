import java.util.*;
class Toy{
    int id;
    String name;
    List<String> colors = new LinkedList<String>();

    Toy(int id, String name, List colors)
    {
        this.id = id;
        this.name = name;
        this.colors = colors;
    }
}
