package homework1.enums.metalsColors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ColorsEnum {

    COLOR("Colors"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String value;

    public String toString() {
        return value;
    }
}
