package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
public class DifferTest {
    String correctOutput1 = Files.readString(Paths.get("src", "test", "resources", "correct-output1.txt"));
    String correctOutput2 = Files.readString(Paths.get("src", "test", "resources", "correct-output2.txt"));
    String file1Json = String.valueOf(Paths.get("src", "test", "resources", "file1.json"));
    String file2Json = String.valueOf(Paths.get("src", "test", "resources", "file2.json"));
    String file3Json = String.valueOf(Paths.get("src", "test", "resources", "file3.json"));
    String file4Json = String.valueOf(Paths.get("src", "test", "resources", "file4.json"));
    String file1Yaml = String.valueOf(Paths.get("src", "test", "resources", "file1.yml"));
    String file2Yaml = String.valueOf(Paths.get("src", "test", "resources", "file2.yml"));
    String file3Yaml = String.valueOf(Paths.get("src", "test", "resources", "file3.yml"));
    String file4Yaml = String.valueOf(Paths.get("src", "test", "resources", "file4.yml"));

    public DifferTest() throws IOException {
    }

    @Test
    public void testGenerate() throws Exception {
        assertThat(Differ.generate(file1Json, file2Json)).isEqualTo(correctOutput1);
        assertThat(Differ.generate(file1Json, file2Yaml)).isEqualTo(correctOutput1);
        assertThat(Differ.generate(file1Yaml, file2Yaml)).isEqualTo(correctOutput1);

        assertThat(Differ.generate(file3Json, file4Json)).isEqualTo(correctOutput2);
        assertThat(Differ.generate(file3Json, file4Yaml)).isEqualTo(correctOutput2);
        assertThat(Differ.generate(file3Yaml, file4Yaml)).isEqualTo(correctOutput2);
    }
}
