package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class PlainTest {
    private final Path filePath = Paths.get("src", "test", "resources", "correct-output-plain.txt");
    private final String correctOutput = Files.readString(filePath);
    private final String file3Json = String.valueOf(Paths.get("src", "test", "resources", "file3.json"));
    private final String file4Yml = String.valueOf(Paths.get("src", "test", "resources", "file4.yml"));

    public PlainTest() throws IOException {
    }

    @Test
    public void testPlain() throws Exception {
        assertThat(Differ.generate(file3Json, file4Yml, "plain")).isEqualTo(correctOutput);
    }
}
