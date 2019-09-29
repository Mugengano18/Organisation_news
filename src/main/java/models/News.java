package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class News {
    private int id;
    private String WrittenBy;
    private String content;
    private int departId;
    private long creation;
    private  String formatCreation;


    public News(String writtenBy, String content, int departId) {
        WrittenBy = writtenBy;
        this.departId = departId;
        this.content=content;
        this.creation = System.currentTimeMillis();
        setFormatCreation();
    }



    public String getWrittenBy() {
        return WrittenBy;
    }

    public void setWrittenBy(String writtenBy) {
        WrittenBy = writtenBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public long getCreation() {
        return creation;
    }

    public void setCreation() {
        this.creation = System.currentTimeMillis();
    }


    public String getFormatCreation() {
        Date day=new Date(creation);
        String dayPattern="EEE, MMM d, ''yy";
        SimpleDateFormat dayFormat2=new SimpleDateFormat(dayPattern);
        return dayFormat2.format(day);
    }

    public void setFormatCreation() {
        Date day =new Date(this.creation);
        String dayPattern ="EEE, MMM d, ''yy";
        SimpleDateFormat dayFormat2= new SimpleDateFormat(dayPattern);
        this.formatCreation = dayFormat2.format(day);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return departId == news.departId &&
                Objects.equals(WrittenBy, news.WrittenBy) &&
                Objects.equals(content, news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(WrittenBy, content, departId);
    }
}
