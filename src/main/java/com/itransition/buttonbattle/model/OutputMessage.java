package com.itransition.buttonbattle.model;

import java.util.Objects;

public class OutputMessage {

    private String text;
    private String from;
    private String time;

    public OutputMessage(final String text, final String from, final String time) {
        this.text = text;
        this.from = from;
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
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
        if (!(o instanceof OutputMessage)) {
            return false;
        }
        OutputMessage message = (OutputMessage) o;
        return Objects.equals(text, message.text) && Objects.equals(from, message.from) &&
                Objects.equals(time, message.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, from, time);
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", from='" + from + '\'' +
                ", dateTime=" + time +
                '}';
    }

}
