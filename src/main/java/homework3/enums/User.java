package homework3.enums;

public enum User {
    LOGIN("epam"),
    PASSWORD("1234"),
    USERNAME("PITER CHAILOVSKII");

    public String value;

    User(String value) {
        this.value = value;
    }
}
