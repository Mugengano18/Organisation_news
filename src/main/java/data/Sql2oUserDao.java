package data;

import models.Department;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(User user) {
        String query ="INSERT INTO users(name, positioninc,role,departid) VALUES (:uname,:posInCom,:role,:depart)";
        try(Connection connect =sql2o.open()){
            int id= (int) connect.createQuery(query,true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
            System.out.println();
        } catch (Sql2oException except){
            System.out.println(except);
        }
    }

    @Override
    public void AddUserDepart(User user, Department depart) {
        String query="INSERT INTO user_department(userid,departid) VALUES (:userId;departId)";
        try(Connection connect=sql2o.open()){
            connect.createQuery(query)
                    .addParameter("userId",user.getId())
                    .addParameter("departId",depart.getId())
                    .executeUpdate();
        }catch (Sql2oException except){
            System.out.println(except);
        }
    }

    @Override
    public List<User> All() {
        try(Connection connect=sql2o.open()){
            return connect.createQuery("SELECT name FROM users")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public User getById(int id) {
        try(Connection connect =sql2o.open()){
            return connect.createQuery("SELECT * FROM users WHERE id=:id;")
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(User.class);
        }
    }


    @Override
    public void update(int id,String newName, String newPosInCom, String newRole, String newDepart) {
        String query= "UPDATE users SET(name, positioninc,role,departid) = (:uname,:posInCom,:role,:depart) where id=:id;";
        try (Connection connect=sql2o.open()){
            connect.createQuery(query)
                    .addParameter("name",newName)
                    .addParameter("position",newPosInCom)
                    .addParameter("role",newRole)
                    .addParameter("departid",newDepart)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }catch (Sql2oException except){
            System.out.println(except);
        }

    }

    @Override
    public void deleteById(int id) {
        String query ="DELETE FROM users where id=:id";
        try(Connection connect=sql2o.open()){
            connect.createQuery(query)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }catch (Sql2oException except){
            System.out.println(except);
        }
    }

    @Override
    public void deleteAll() {
        String query="DELETE FROM users";
        try(Connection connect=sql2o.open()){
            connect.createQuery(query)
                    .throwOnMappingFailure(false).executeUpdate();
        }catch(Sql2oException except){
            System.out.println(except);
        }
    }
}
