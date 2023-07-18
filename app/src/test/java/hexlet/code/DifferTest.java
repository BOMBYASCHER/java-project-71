package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
public class DifferTest {
    private final Path filePath1 = Paths.get("src", "test", "resources", "correct-output1.txt");
    private final Path filePath2 = Paths.get("src", "test", "resources", "correct-output2.txt");
    private final String correctOutput1 = Files.readString(filePath1);
    private final String correctOutput2 = Files.readString(filePath2);
    private final String file1Json = String.valueOf(Paths.get("src", "test", "resources", "file1.json"));
    private final String file2Json = String.valueOf(Paths.get("src", "test", "resources", "file2.json"));
    private final String file3Json = String.valueOf(Paths.get("src", "test", "resources", "file3.json"));
    private final String file4Json = String.valueOf(Paths.get("src", "test", "resources", "file4.json"));
    private final String file1Yaml = String.valueOf(Paths.get("src", "test", "resources", "file1.yml"));
    private final String file2Yaml = String.valueOf(Paths.get("src", "test", "resources", "file2.yml"));
    private final String file3Yaml = String.valueOf(Paths.get("src", "test", "resources", "file3.yml"));
    private final String file4Yaml = String.valueOf(Paths.get("src", "test", "resources", "file4.yml"));

    public DifferTest() throws IOException {
    }

    @Test
    public void testGenerate() throws Exception {
        assertThat(Differ.generate(file1Json, file2Json, "stylish")).isEqualTo(correctOutput1);
        assertThat(Differ.generate(file1Json, file2Yaml)).isEqualTo(correctOutput1);
        assertThat(Differ.generate(file1Yaml, file2Yaml, "stylish")).isEqualTo(correctOutput1);

        assertThat(Differ.generate(file3Json, file4Json, "stylish")).isEqualTo(correctOutput2);
        assertThat(Differ.generate(file3Json, file4Yaml, "stylish")).isEqualTo(correctOutput2);
        assertThat(Differ.generate(file3Yaml, file4Yaml, "stylish")).isEqualTo(correctOutput2);
    }
}
