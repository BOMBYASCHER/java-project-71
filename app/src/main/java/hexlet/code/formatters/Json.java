package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.Parser;

import java.util.LinkedHashMap;

public class Json {
    public static String json(LinkedHashMap<String, Object> diff) throws JsonProcessingException {
        return Parser.json(diff);
    }
}
