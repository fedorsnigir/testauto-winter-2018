package homework4.enums;

public enum ServiceMenuOptionsEnum {

    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

    public String text;

    ServiceMenuOptionsEnum(String text) {
        this.text = text;
    }
}
