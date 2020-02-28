package homework1.enums.metalsColors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MetalsEnum {

    METALS("Metals"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String value;

    public String toString() {
        return value;
    }
}
