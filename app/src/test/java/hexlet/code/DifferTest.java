package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
public class DifferTest {
    String correctOutput1 = Files.readString(Paths.get("src/test/resources/correct-output1.txt"));

    public DifferTest() throws IOException {
    }

    @Test
    public void testGenerate() throws Exception {
        assertThat(Differ.generate("file1.json", "file2.json")).isEqualTo(correctOutput1);
    }
}
