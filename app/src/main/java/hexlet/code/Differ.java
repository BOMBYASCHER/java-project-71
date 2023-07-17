package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> file1 = Parser.parse(filepath1);
        Map<String, Object> file2 = Parser.parse(filepath2);
        Set<String> keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());
        LinkedHashMap<String, Object> difference = new LinkedHashMap<>();
        keys.forEach(key -> {
            if (file1.containsKey(key) && file2.containsKey(key)) {
                if (Objects.equals(file1.get(key), file2.get(key))) {
                    difference.put(key, "unchanged");
                } else {
                    difference.put(key, "changed");
                }
            } else {
                if (file1.containsKey(key)) {
                    difference.put(key, "deleted");
                } else {
                    difference.put(key, "added");
                }
            }
        });
        return Formatter.stringify(difference, file1, file2);
    }
}
