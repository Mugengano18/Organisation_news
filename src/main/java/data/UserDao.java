package data;

import models.User;

import java.util.List;

public interface UserDao {
    //create
    void add (User user);

    //read
    List<User>All();
    User getById(int id);

    //Edit
    void update(int id,String uname,String posInCom,String role,String depart);

    //delete
    void deleteById(int id);
    void deleteAll();

}
