package homework4.enums;

public enum ServiceMenuOptionsEnum {

    SUPPORT,
    DATES,
    COMPLEX_TABLE,
    SIMPLE_TABLE,
    TABLE_WITH_PAGES,
    DIFFERENT_ELEMENTS;

    ServiceMenuOptionsEnum() {
    }

    @Override
    public String toString() {
        return name().replaceAll("_", " ");
    }
}
