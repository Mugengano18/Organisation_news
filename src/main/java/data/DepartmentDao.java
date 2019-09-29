package data;

import models.Department;

import java.util.List;

public interface DepartmentDao {

    //adding
    void add(Department depart);

    //read
    List<Department>All();


    //delete
    void deleteById(int id);
    void clearAll();
}
