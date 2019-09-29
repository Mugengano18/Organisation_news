package data;

import models.Department;
import models.News;

import java.util.List;

public interface NewsDao {
    //create
    void add(News info);
    void AddNewsToDepart(News news, Department depart);

    //read
    List<News> All();
    News getById(int id);


    //delete
    void clearAll();
}
