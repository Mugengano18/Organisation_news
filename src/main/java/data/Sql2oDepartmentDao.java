package data;

import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department depart) {
        String query="INSERT INTO department(name,description,noofemployees) VALUES (:dname,:description,:employee)";
        try(Connection connect=sql2o.open()){
            int id =(int) connect.createQuery(query,true)
                    .bind(depart)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
            depart.setId(id);
        }catch (Sql2oException except){
            System.out.println(except);
        }
    }

    @Override
    public List<Department> All() {
        try(Connection connect=sql2o.open()){
            return connect.createQuery("SELECT * FROM department")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department getById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        String query ="DELETE FROM department WHERE id=:id";
        try(Connection connect=sql2o.open()){
            connect.createQuery(query)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException except){
            System.out.println(except);
        }
    }

    @Override
    public void clearAll() {
        String query ="DELETE FROM department";
        try(Connection connect=sql2o.open()){
            connect.createQuery(query)
                    .executeUpdate();
        }catch (Sql2oException except){
            System.out.println(except);
        }

    }
}
