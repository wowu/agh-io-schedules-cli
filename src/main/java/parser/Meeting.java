package parser;

import java.util.Date;

@SuppressWarnings("unused")
public class Meeting {
    private final Integer conference;
    private final Date dateStart;
    private final Date dateEnd;
    private final String subject;
    private final String group;
    private final String lecturer;
    private final String type;
    private final Integer lengthInHours;
    private final String format;
    private final String room;

    public Meeting(Integer conference, Date dateStart, Date dateEnd, String subject, String group, String lecturer,
                   String type, Integer lengthInHours, String format, String room) {
        this.conference = conference;
        this.dateStart = (Date) dateStart.clone();
        this.dateEnd = (Date) dateEnd.clone();
        this.subject = subject;
        this.group = group;
        this.lecturer = lecturer;
        this.type = type;
        this.lengthInHours = lengthInHours;
        this.format = format;
        this.room = room;
    }

    public Integer getConference() {
        return conference;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public String getSubject() {
        return subject;
    }

    public String getGroup() {
        return group;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getType() {
        return type;
    }

    public Integer getLengthInHours() {
        return lengthInHours;
    }

    public String getFormat() {
        return format;
    }

    public String getRoom() {
        return room;
    }
}
