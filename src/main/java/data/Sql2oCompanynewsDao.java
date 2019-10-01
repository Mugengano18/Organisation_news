package data;

import models.Companynews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCompanynewsDao implements CompanynewsDao {
    private final Sql2o sql2o;

    public Sql2oCompanynewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Companynews news) {
        String query ="INSERT INTO companynews(writtenBy,content) VALUES (:writtenBy,:content)";
        try(Connection connect = sql2o.open()){
            int id =(int) connect.createQuery(query,true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        }catch (Sql2oException exception){
            System.out.println(exception);
        }
    }

    @Override
    public List<Companynews> getAll() {
       try(Connection connect=sql2o.open()){
           return  connect.createQuery("SELECT * FROM companynews")
                   .throwOnMappingFailure(false)
                   .executeAndFetch(Companynews.class);
       }
    }

    @Override
    public Companynews getById(int id) {
       try(Connection connect= sql2o.open()){
           return  connect.createQuery("SELECT * FROM companynews WHERE id=:id")
                   .addParameter("id",id)
                   .executeAndFetchFirst(Companynews.class);
       }
    }



    @Override
    public void deleteById(int id) {
        String query="DELETE FROM companynews WHERE id=:id";
        try(Connection connect=sql2o.open()){
            connect.createQuery(query)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException except){
            System.out.println(except);
        }
    }

    @Override
    public void clearAll() {
        String query ="DELETE FROM companynews";
        try(Connection connect= sql2o.open()){
            connect.createQuery(query).executeUpdate();
        }catch(Sql2oException except){
            System.out.println(except);
        }
    }
}
