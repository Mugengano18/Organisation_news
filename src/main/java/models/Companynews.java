package models;

import java.util.Objects;

public class Companynews {
    private String content;
    private String writtenBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;


    public Companynews(String content, String writtenBy) {
        this.content = content;
        this.writtenBy = writtenBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Companynews that = (Companynews) o;
        return Objects.equals(content, that.content) &&
                Objects.equals(writtenBy, that.writtenBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, writtenBy);
    }
}
