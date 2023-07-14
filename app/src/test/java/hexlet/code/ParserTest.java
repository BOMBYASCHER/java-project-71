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
        Map<String, Object> actual = Parser.parse("file1.json");
        ObjectMapper mapperJson = new ObjectMapper();
        Map<String, Object> expected = mapperJson
                .readValue(Files.readString(Paths.get("file1.json")), new TypeReference<>() {
                });
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testParserOnYaml() throws Exception {
        Map<String, Object> actual = Parser.parse("file2.yml");
        ObjectMapper mapperYaml = new YAMLMapper();
        Map<String, Object> expected = mapperYaml
                .readValue(Files.readString(Paths.get("file2.yml")), new TypeReference<>() {
                });
        assertThat(actual).isEqualTo(expected);
    }
}
