import java.util.ArrayList;

public class ArrayListSum {
    public static void main(String args[]) {
        ArrayList<Integer> al = new ArrayList<Integer>(); //create an array list
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        System.out.println("Contents are: " + al);
        Integer ai[] = new Integer[al.size()];
        ai = al.toArray(ai); //get the array
        int sum = 0;
        for(int i : ai) {
            sum += i;
        }
        System.out.println("Sum is: " + sum);
    }
}
