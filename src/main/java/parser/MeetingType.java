package parser;

public enum MeetingType {
    LECTURE,
    LABORATORIES,
    CLASSES;

    static MeetingType getTypeFromString(String type) {
        if (type.equals("W"))
            return LECTURE;
        else if (type.equals("L"))
            return LABORATORIES;
        else
            return CLASSES;
    }
}
