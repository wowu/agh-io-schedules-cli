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

    public boolean compareSchedules(Schedule otherSchedule, StringBuilder result) {
        boolean noCollisions = true;
        for (Conference conference : conferences) {
            for (Conference otherConference : otherSchedule.getConferences()) {
                if (conference.compareConference(otherConference, result))
                    noCollisions = false;
            }
        }

        return noCollisions;
    }

    public String getFileName() {
        return fileName;
    }

    public List<Conference> getConferences() {
        return conferences;
    }
}
