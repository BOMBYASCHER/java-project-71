package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class PlainTest {
    String correctOutput = Files.readString(Paths.get("src", "test", "resources", "correct-output-plain.txt"));
    String file3Json = String.valueOf(Paths.get("src", "test", "resources", "file3.json"));
    String file4Yml = String.valueOf(Paths.get("src", "test", "resources", "file4.yml"));

    public PlainTest() throws IOException {
    }

    @Test
    public void testPlain() throws Exception {
        assertThat(Differ.generate(file3Json, file4Yml, "plain")).isEqualTo(correctOutput);
    }
}
