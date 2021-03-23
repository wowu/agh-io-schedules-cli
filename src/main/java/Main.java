import parser.Conference;
import parser.Meeting;
import parser.Parser;
import parser.Schedule;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Parser parser = new Parser("pattern.xlsx");
        Schedule schedule = parser.parse();

        for (Conference conference : schedule.getConferences()) {
            for (Meeting meeting : conference.getMeetings()) {
                System.out.println("Conference number: " + meeting.getConference().getNumber());
                System.out.println("Date Start: " + meeting.getDateStart());
                System.out.println("Date End:  " + meeting.getDateEnd());
                System.out.println("Subject: " + meeting.getSubject());
                System.out.println("Group: " + meeting.getGroup());
                System.out.println("Lecturer: " + meeting.getLecturer());
                System.out.println("Type: " + meeting.getType());
                System.out.println("Length: " + meeting.getLengthInHours());
                System.out.println("Format: " + meeting.getFormat());
                System.out.println("Room: " + meeting.getRoom() + "\n");
            }
        }
    }

}