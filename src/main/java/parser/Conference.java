package parser;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Conference {
    private final Schedule schedule;
    private final Integer number;
    private final List<Meeting> meetings;

    public Conference(Schedule schedule, Integer number) {
        this.schedule = schedule;
        this.number = number;
        meetings = new ArrayList<>();
    }

    public boolean compareConference(Conference otherConference, StringBuilder result) {
        boolean noCollisions = true;
        for (Meeting meeting : meetings) {
            boolean noCollisionsMeeting = true;
            StringBuilder response =
                    new StringBuilder(String.format("\n%17s %s", "-", meeting.toString()));
            for (Meeting otherMeeting : otherConference.getMeetings()) {
                if (meeting.compareMeeting(otherMeeting, response)) {
                    noCollisionsMeeting = false;
                }
            }
            if (!noCollisionsMeeting) {
                result.append(response);
                noCollisions = false;
            }
        }
        return noCollisions;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Integer getNumber() {
        return number;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
