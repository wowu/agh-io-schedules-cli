import collision.CollisionDetector;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Command(name = "java -jar <jar_file>", mixinStandardHelpOptions = true, version = "collisionDetector 1.0",
        description = "Finds collisions between schedules.")
public class Main implements Runnable {

    @Parameters(index = "0..*", description = "Files/Directories in which the program should look for collisions.")
    private List<File> files;


    @Spec
    CommandSpec spec;

    @Override
    public void run() {
        if (files == null || files.size() == 0)
            spec.commandLine().usage(System.err);
        else {
            try {
                CollisionDetector collisionDetector = new CollisionDetector();
                collisionDetector.loadSchedules(files);
                collisionDetector.compareSchedules();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }
}