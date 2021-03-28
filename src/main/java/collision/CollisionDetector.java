package collision;

import parser.Parser;
import parser.Schedule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollisionDetector {
    List<Schedule> schedules;
    final static String dashes = "--------------------";

    public CollisionDetector() {
        schedules = new ArrayList<>();
    }

    public void loadSchedules(List<File> files) throws FileNotFoundException {
        for (File file : files) {
            if (file.isFile()) {
                Schedule newSchedule = new Parser(file.getName()).parse();
                schedules.add(newSchedule);
            } else if (file.isDirectory()) {
                for (File subfile : Objects.requireNonNull(file.listFiles())) {
                    Schedule newSchedule = new Parser(subfile.getName()).parse();
                    schedules.add(newSchedule);
                }
            } else {
                System.out.println("File " + file.getName() + " is not a file or directory!");
            }
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
