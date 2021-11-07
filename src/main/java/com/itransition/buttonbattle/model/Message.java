package com.itransition.buttonbattle.model;

import java.util.Objects;

public class Message {

    private String from;
    private ButtonType buttonType;
    private String time;

    public Message() {
    }

    public Message(final String from, final ButtonType buttonType, final String time) {
        this.from = from;
        this.buttonType = buttonType;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public ButtonType getButtonType() {
        return buttonType;
    }

    public void setButtonType(final ButtonType buttonType) {
        this.buttonType = buttonType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(final String time) {
        this.time = time;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(from, message.from) && Objects.equals(time, message.time) && buttonType == message.buttonType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, time, buttonType);
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", time='" + time + '\'' +
                ", buttonType=" + buttonType +
                '}';
    }
}
