package data;

import models.Department;
import models.User;

import java.util.List;

public interface DepartmentDao {

    //adding
    void add(Department depart);

    //read
    List<Department>All();
    Department getById(int id);


    //delete
    void deleteById(int id);
    void clearAll();
}
