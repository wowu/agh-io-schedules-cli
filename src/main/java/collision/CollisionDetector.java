package collision;

import parser.Parser;
import parser.Schedule;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CollisionDetector {
    List<Schedule> schedules;
    final static String dashes = "--------------------";

    public CollisionDetector() {
        schedules = new ArrayList<>();
    }

    public void loadSchedules(List<String> args) throws FileNotFoundException {
        for (String arg : args) {
            Schedule newSchedule = new Parser(arg).parse();
            schedules.add(newSchedule);
        }
    }

    public void compareSchedules() {
        StringBuilder validSchedules = new StringBuilder("Nie znaleziono kolizji w następujących plikach:");
        StringBuilder invalidSchedules = new StringBuilder("Znaleziono kolizje:");
        boolean areValidSchedules = false;
        boolean areInvalidSchedules = false;
        boolean noCollisions;
        boolean result;

        for (Schedule schedule : schedules) {
            noCollisions = true;
            StringBuilder response =
                    new StringBuilder("\n" + dashes + " " + schedule.getFileName() + " " + dashes);
            for (Schedule otherSchedule : schedules) {
                boolean sameSchedule = schedule.equals(otherSchedule);
                StringBuilder scheduleResponse = new StringBuilder(String.format("\n%8s", ""))
                        .append(dashes).append(" ")
                        .append(otherSchedule.getFileName()).append(" ").append(dashes);
                result = schedule.compareSchedules(otherSchedule, scheduleResponse, sameSchedule);
                if (!result) {
                    noCollisions = false;
                    response.append(scheduleResponse);
                }
            }
            if (noCollisions) {
                validSchedules.append("\n- ").append(schedule.getFileName());
                areValidSchedules = true;
            } else {
                invalidSchedules.append(response);
                areInvalidSchedules = true;
            }
        }

        if (areValidSchedules)
            System.out.println("\n" + validSchedules);
        if (areInvalidSchedules)
            System.out.println("\n" + invalidSchedules);
    }
}
