package parser;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Conference {
    private final Integer number;
    private final List<Meeting> meetings;

    public Conference(Integer number) {
        this.number = number;
        meetings = new ArrayList<>();
    }

    public Integer getNumber() {
        return number;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
