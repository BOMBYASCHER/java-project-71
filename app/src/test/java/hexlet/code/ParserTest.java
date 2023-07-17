package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    @Test
    public void testParserOnJson() throws Exception {
        var filePath = Paths.get("src", "test", "resources", "file1.json");
        Map<String, Object> actual = Parser.parse(String.valueOf(filePath));
        ObjectMapper mapperJson = new ObjectMapper();
        Map<String, Object> expected = mapperJson
                .readValue(Files.readString(filePath), new TypeReference<>() {
                });
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testParserOnYaml() throws Exception {
        var filePath = Paths.get("src", "test", "resources", "file2.yml");
        Map<String, Object> actual = Parser.parse(String.valueOf(filePath));
        ObjectMapper mapperYaml = new YAMLMapper();
        Map<String, Object> expected = mapperYaml
                .readValue(Files.readString(filePath), new TypeReference<>() {
                });
        assertThat(actual).isEqualTo(expected);
    }
}
