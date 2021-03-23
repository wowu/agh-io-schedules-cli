package parser;

public enum MeetingFormat {
    HOME,
    UNIVERSITY;

    static MeetingFormat getFormatFromString(String format) {
        if (format.equals("zdalnie"))
            return HOME;

        return UNIVERSITY;
    }
}
