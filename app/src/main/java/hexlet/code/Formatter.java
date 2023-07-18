package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.LinkedHashMap;
import java.util.Map;

public class Formatter {
    public static String stringify(LinkedHashMap<String, Object> diff,
                                   Map<String, Object> file1,
                                   Map<String, Object> file2,
                                   String format) throws JsonProcessingException {
        if (format.equals("plain")) {
            return Plain.plain(diff, file1, file2);
        }
        if (format.equals("json")) {
            return Json.json(diff);
        } else {
            return Stylish.stylish(diff, file1, file2);
        }
    }
}
