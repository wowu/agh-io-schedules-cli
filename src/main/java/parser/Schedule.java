package parser;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Schedule {
    private final String fileName;
    private final ArrayList<Conference> conferences;

    public Schedule(String fileName) {
        this.fileName = fileName;
        conferences = new ArrayList<>();
    }

    String getFileName() {
        return fileName;
    }

    public ArrayList<Conference> getConferences() {
        return conferences;
    }
}
