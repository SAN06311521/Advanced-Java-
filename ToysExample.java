import java.util.LinkedList;
import java.util.List;

public class ToysExample
{   public static void main(String args[])
{
    List<Toy> list1 = new LinkedList<Toy>();
    list1.add(new Toy(01,"doll", List.of("red","blue")));
    list1.add(new Toy(02,"teddy",List.of("pink","white","black")));
    list1.add(new Toy(04,"train",List.of("red","black","brown","grey","golden","white")));
    list1.add(new Toy(03,"ball",List.of("green")));

    list1.add(new Toy(03,"ball",List.of("green", "blue")));
    System.out.println("\nList of all the toys:"+ list1);

    System.out.println("\nList of all the toys:");
    for(Toy t:list1)
    {
        System.out.println(t.id+" "+t.name+" "+t.colors);
    }
}
}