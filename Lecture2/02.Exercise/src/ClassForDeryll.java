import java.util.Random;

public class ClassForDeryll {
    public static void main(String[] args) {
        String[] classes = new String[]{
                "Warrior", "Priest",
                "Mage", "Warlock",
                "Paladin", "Hunter",
                "Shaman", "Rogue", "Druid"
        };

        Random r = new Random();
        System.out.println(classes[r.nextInt(8)]);
    }
}
/*
    1. Steck Opashki / List
    2. Matrici
    3. Regex
    4. Maps
 */