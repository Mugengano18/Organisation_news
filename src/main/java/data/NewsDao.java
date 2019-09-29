package data;

import models.News;

import java.util.List;

public interface NewsDao {
    //create
    void add(News info);

    //read
    List<News> All();
    News getById(int id);


    //delete
    void clearAll();
}
