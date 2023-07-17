package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    private static String getExtension(String filePath) {
        String[] splitFilePath = filePath.split("\\.");
        return splitFilePath[splitFilePath.length - 1];
    }
    private static ObjectMapper getMapper(String extension) {
        Map<String, ObjectMapper> mappers = new HashMap<>();
        mappers.put("json", new ObjectMapper());
        mappers.put("yml", new YAMLMapper());
        mappers.put("yaml", new YAMLMapper());
        return mappers.get(extension);
    }
    public static Map<String, Object> parse(String filePath) throws Exception {
        ObjectMapper mapper = getMapper(getExtension(filePath));
        return mapper.readValue(Files.readString(Paths.get(filePath)), new TypeReference<>() {
        });
    }
}
