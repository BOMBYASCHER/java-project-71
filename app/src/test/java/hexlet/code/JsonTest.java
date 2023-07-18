package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {
    Path filePath = Paths.get("src", "test", "resources", "correct-json.json");
    String file3Json = String.valueOf(Paths.get("src", "test", "resources", "file3.json"));
    String file4Yml = String.valueOf(Paths.get("src", "test", "resources", "file4.yml"));
    @Test
    public void testJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> expected = objectMapper.readValue(Files.readString(filePath), new TypeReference<>() {
        });
        String difference = Differ.generate(file3Json, file4Yml, "json");
        Map<String, Object> actual = objectMapper.readValue(difference, new TypeReference<>() {
        });
        assertThat(actual).isEqualTo(expected);
    }
}
