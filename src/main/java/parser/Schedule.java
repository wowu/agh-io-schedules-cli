package parser;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Schedule {
    private final String fileName;
    private final List<Conference> conferences;

    public Schedule(String fileName) {
        this.fileName = fileName;
        conferences = new ArrayList<>();
    }

    String getFileName() {
        return fileName;
    }

    public List<Conference> getConferences() {
        return conferences;
    }
}
