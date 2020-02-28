package homework1.enums.metalsColors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VegetablesEnum {

    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    public String value;

    public String toString() {
        return value;
    }
}
