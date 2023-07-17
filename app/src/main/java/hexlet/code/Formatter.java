package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;

public class Formatter {
    public static String stringify(LinkedHashMap<String, Object> diff,
                                    Map<String, Object> file1,
                                    Map<String, Object> file2) {
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
        return String.valueOf(sb);
    }
}
