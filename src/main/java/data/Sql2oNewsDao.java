package data;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements  NewsDao {
    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(News info) {
        String query ="INSERT INTO news(writtenby,content,departid,createdon) VALUES (:writtenBy,:content,:departId,:creation)";
        try(Connection connect=sql2o.open()){
            int id = (int) connect.createQuery(query,true)
                    .bind(info)
                    .executeUpdate()
                    .getKey();
            info.setId(id);
        }catch (Sql2oException except){
            System.out.println(except);
        }

    }

    @Override
    public List<News> All() {
        try(Connection connect =sql2o.open()){
            return connect.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News getById(int id) {
        try(Connection connect=sql2o.open()){
            return connect.createQuery("SELECT * FROM news WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public void clearAll() {
     String query = "DELETE FROM news";
     try(Connection connect=sql2o.open()){
         connect.createQuery(query)
                 .executeUpdate();
     }catch(Sql2oException except){
         System.out.println(except);
     }
    }
}
