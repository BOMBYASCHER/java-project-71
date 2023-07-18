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
    private static StringBuilder buildAddedString(String key, Object value) {
        final StringBuilder sb = new StringBuilder();
        return sb.append("Property ")
                .append('\'')
                .append(key)
                .append('\'')
                .append(" was added with value: ")
                .append(checkComplexValue(value));
    }
    private static StringBuilder buildDeletedString(String key) {
        final StringBuilder sb = new StringBuilder();
        return sb.append("Property ")
                .append('\'')
                .append(key)
                .append('\'')
                .append(" was removed");
    }
    private static StringBuilder buildChangedString(String key, Object value1, Object value2) {
        final StringBuilder sb = new StringBuilder();
        return sb.append("Property ")
                .append('\'')
                .append(key)
                .append('\'')
                .append(" was updated. From ")
                .append(checkComplexValue(value1))
                .append(" to ")
                .append(checkComplexValue(value2));
    }
    public static String plain(LinkedHashMap<String, Object> diff,
                               Map<String, Object> file1,
                               Map<String, Object> file2) {
        final StringBuilder sb = new StringBuilder();
        diff.forEach((key, value) -> {
            if (value.equals("added")) {
                sb.append(buildAddedString(key, file2.get(key)))
                        .append('\n');
            }
            if (value.equals("deleted")) {
                sb.append(buildDeletedString(key))
                        .append('\n');
            }
            if (value.equals("changed")) {
                sb.append(buildChangedString(key, file1.get(key), file2.get(key)))
                        .append('\n');
            }
        });
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }
}
