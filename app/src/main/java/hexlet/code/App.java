package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Parameters(description = "path to first file")
    private String filepath1;
    @Parameters(description = "path to second file")
    private String filepath2;
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;
    @Override
    public void run() {

    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
