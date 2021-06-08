import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyTranslator {
    private Map<String, String> dictionary = new HashMap<>();

    public MyTranslator() {
        dictionary.put("Cat", "Кошка");
        dictionary.put("Dog", "Пес");
    }

    public void addNewWord(String en, String ru) {
        dictionary.put(en, ru);
    }

    public String translate(String en) {
        return dictionary.getOrDefault(en, "Unknown animal");
    }

    @Override
    public String toString() {
        return "MyTranslator " + dictionary;
    }

    public static void main(String[] args) {

        MyTranslator myTranslator = new MyTranslator();
        myTranslator.addNewWord("Horse", "Лошадь");
        myTranslator.addNewWord("Elephant", "Слон");
        System.out.println(myTranslator);
        // System.out.println(myTranslator.translate("Cat"));
        // System.out.println(myTranslator.translate("Penguin"));
        String exit = "";
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter your word to translate: ");
            String word = scan.nextLine();
            if (!myTranslator.dictionary.containsKey(word)) {
                System.out.println("Unknown animal. Enter your translation: ");
                String translated = scan.nextLine();
                myTranslator.dictionary.put(word, translated);
                System.out.println("Word is saved");

            } else {
                String ru = myTranslator.translate(word);
                System.out.println("translation: " + ru);
            }
            exit = scan.nextLine();
            //myTranslator.dictionary.forEach((key, value)->System.out.println(key+" : " + value));
        } while (!exit.equals("end"));
    }
}

