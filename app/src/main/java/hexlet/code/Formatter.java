package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.LinkedHashMap;
import java.util.Map;

public class Formatter {
    public static String stringify(LinkedHashMap<String, Object> diff,
                                   Map<String, Object> file1,
                                   Map<String, Object> file2,
                                   String format) {
        if (format.equals("plain")) {
            return Plain.plain(diff, file1, file2);
        } else {
            return Stylish.stylish(diff, file1, file2);
        }
    }
}
