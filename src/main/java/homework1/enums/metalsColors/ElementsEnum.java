package homework1.enums.metalsColors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ElementsEnum {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String value;

    @Override
    public String toString() {
        return value;
    }
}
