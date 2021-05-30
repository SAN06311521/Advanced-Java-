import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("amazing", "something very delightful and creative");
        dictionary.put("Hard", "very stiff");
        dictionary.put("motion", "movement of an object");
        dictionary.put("delight", "happy, glad");
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while(!quit) {
            System.out.println("Enter a word : ");
            String toSearch = input.nextLine();
            if(toSearch.equals("quit")) {
                quit = true;
            }
            else if(dictionary.containsKey(toSearch)) {
                System.out.println(toSearch + " : " + dictionary.get(toSearch));
            } else {
                System.out.println("Word not found");
            }
        }
    }
}
