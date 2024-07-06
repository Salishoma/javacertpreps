package src.examsim.enums;


public enum Sports {
    FOOTBALL("Football"), BASKETBALL("Basketball");

    private String sports;
    Boolean[] booleans = new Boolean[0];
    Sports(String sports) {

        new StringBuilder().trimToSize();
        this.sports = sports;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }
}
