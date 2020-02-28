package homework1.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PagesEnum {

    HOME("Home"),
    CONTACT_FORM("Contact Form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

    public String value;

    public String toString() {
        return value;
    }
}
