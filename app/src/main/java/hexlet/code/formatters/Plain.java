package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Plain {
    private static Object checkComplexValue(Object value) {
        if (value == null) {
            return null;
        }
        ArrayList<String> complexTypes = new ArrayList<>();
        complexTypes.add("java.util.ArrayList");
        complexTypes.add("java.util.LinkedHashMap");
        final StringBuilder sb = new StringBuilder();
        if (value instanceof String) {
            sb.append('\'').append(value).append('\'');
            return sb.toString();
        }
        if (complexTypes.contains(value.getClass().getTypeName())) {
            return "[complex value]";
        }
        return value;
    }
    public static String plain(LinkedHashMap<String, Object> diff,
                               Map<String, Object> file1,
                               Map<String, Object> file2) {
        final StringBuilder sb = new StringBuilder();
        diff.forEach((key, value) -> {
            if (value.equals("added")) {
                sb.append("Property ")
                        .append('\'')
                        .append(key)
                        .append('\'')
                        .append(" was added with value: ")
                        .append(checkComplexValue(file2.get(key)))
                        .append('\n');
            }
            if (value.equals("deleted")) {
                sb.append("Property ")
                        .append('\'')
                        .append(key)
                        .append('\'')
                        .append(" was removed")
                        .append('\n');
            }
            if (value.equals("changed")) {
                sb.append("Property ")
                        .append('\'')
                        .append(key)
                        .append('\'')
                        .append(" was updated. From ")
                        .append(checkComplexValue(file1.get(key)))
                        .append(" to ")
                        .append(checkComplexValue(file2.get(key)))
                        .append('\n');
            }
        });
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }
}
