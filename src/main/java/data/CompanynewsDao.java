package data;

import models.Companynews;

import java.util.List;

public interface CompanynewsDao {
    //add
     void add(Companynews news);


    //read
    List<Companynews>getAll();
    Companynews getById(int id);

    //update
//    void update (int id,String content,String writtenBy);


    //delete
    void deleteById(int id);
    void clearAll();
}
