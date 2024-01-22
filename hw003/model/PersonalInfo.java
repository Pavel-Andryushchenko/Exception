package model;

public class PersonalInfo {
    String fullName;
    String otherDate;

    public PersonalInfo(String fullName, String otherDate) {
        this.fullName = fullName;
        this.otherDate = otherDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOtherDate() {
        return otherDate;
    }

    public void setOtherDate(String otherDate) {
        this.otherDate = otherDate;
    }

    @Override
    public String toString() {
        return  fullName  + " " + otherDate;

    }
}
