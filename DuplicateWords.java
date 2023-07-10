import java.util.Scanner;

public class DuplicateWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string;
        int count;

        System.out.println("Enter a String: ");
        string = sc.nextLine();
        string = string.toLowerCase();

        String[] words = string.split(" ");

        System.out.println("Duplicate words are : ");
        for(int i = 0; i < words.length; i++) {
            count = 1;
            for(int j = i+1; j < words.length; j++) {
                if(words[i].equals(words[j])) {
                    count++;
                    words[j] = "0";
                }
            }

            if(count > 1 && !words[i].equals("0"))
                System.out.println(words[i]);
        }
    }
}