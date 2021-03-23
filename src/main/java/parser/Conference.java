package parser;

import java.util.ArrayList;

public class Conference {
    private final Integer number;
    private final ArrayList<Meeting> meetings;

    public Conference(Integer number) {
        this.number = number;
        meetings = new ArrayList<>();
    }

    public Integer getNumber() {
        return number;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }
}
