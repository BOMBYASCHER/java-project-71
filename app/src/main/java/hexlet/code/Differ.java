package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    private static String stringify(LinkedHashMap<String, Object> diff, Map<String, Object> file1, Map<String, Object> file2) {
        final StringBuilder sb = new StringBuilder("{\n");
        diff.forEach((key, value) -> {
            sb.append("  ");
            if (value.equals("added")) {
                sb.append("+ ").append(key).append(": ").append(file2.get(key));
            }
            if (value.equals("deleted")) {
                sb.append("- ").append(key).append(": ").append(file1.get(key));
            }
            if (value.equals("changed")) {
                sb.append("- ").append(key).append(": ").append(file1.get(key));
                sb.append("\n");
                sb.append("  ");
                sb.append("+ ").append(key).append(": ").append(file2.get(key));
            }
            if (value.equals("unchanged")) {
                sb.append("  ").append(key).append(": ").append(file1.get(key));
            }
            sb.append("\n");
        });
        sb.append("}");
        return sb.toString();
    }
    private static Map<String, Object> parse(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Files.readString(Paths.get(filePath)), new TypeReference<>() {
        });
    }
    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> file1 = parse(filepath1);
        Map<String, Object> file2 = parse(filepath2);
        Set<String> keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());
        LinkedHashMap<String, Object> difference = new LinkedHashMap<>();
        keys.forEach(key -> {
            if (file1.containsKey(key) && file2.containsKey(key)) {
                if (file1.get(key).equals(file2.get(key))) {
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
        return stringify(difference, file1, file2);
    }
}
