package com.itransition.buttonbattle.model;

import java.util.Objects;

public class Click {

    private ButtonType buttonType;
    private String from;

    public ButtonType getButtonType() {
        return buttonType;
    }

    public void setButtonType(final ButtonType buttonType) {
        this.buttonType = buttonType;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Click)) {
            return false;
        }
        final Click click = (Click) o;
        return Objects.equals(buttonType, click.buttonType) && Objects.equals(from, click.from);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonType, from);
    }

    @Override
    public String toString() {
        return "Click{" +
                "type='" + buttonType + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
