import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> chars = new HashMap<>();
        int counter;
        int MaxSize = t.length();
        int windowSize = 0;
        int p = 0;
        int minSize = Integer.MAX_VALUE;

        String result = "";

        if (s.length() == 0 || t.length() == 0) {
            return result;
        }
        for (int i = 0; i < t.length(); i++) {
            chars.put(t.charAt(i), chars.getOrDefault(t.charAt(i), 0) + 1);

        }
        HashMap<Character, Integer> window = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (!chars.containsKey(s.charAt(j))) {
                continue;
            }

            counter = window.getOrDefault(s.charAt(j), 0);
            if (counter < chars.get(s.charAt(j))) {
                windowSize++;
            }
            window.put(s.charAt(j), counter + 1);

            if (windowSize == MaxSize) {
                //do something
                p++;
            }

            if (minSize > j - p + 1) {
                minSize = j - p + 1;
                result = s.substring(p, j + 1);
            }

        }

        return result;

    }
}

