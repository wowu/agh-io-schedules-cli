package collision;

public enum CollisionReason {
    ROOM,
    LECTURER,
    GROUP;

    @Override
    public String toString() {
        if (this.equals(ROOM))
            return "Sala";
        else if (this.equals(LECTURER))
            return "Prowadzący";
        else
            return "Grupa";
    }
}
