package homework7.enums;

public enum MainMenuOptionsEnum {
    HOME,
    SERVICE,
    CONTACT_FORM,
    METALS_COLORS("Metals & Colors");

    private String value;

    MainMenuOptionsEnum() {
    }

    MainMenuOptionsEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == null) {
            return name().replaceAll("_", " ");
        } else {
            return value;
        }
    }
}
