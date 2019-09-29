import com.google.gson.Gson;
import data.*;
import exceptions.ApiException;
import models.Companynews;
import models.Department;
import models.User;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        Sql2oUserDao userDao;
        Sql2oCompanynewsDao CompanynewsDao;
        Sql2oDepartmentDao DepartmentDao;
        Connection connnect;
        Gson google =new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/organisation"; //connecting to organisation
        Sql2o sql2o = new Sql2o(connectionString, "alice", "20001");  //this is a connection string

        userDao= new Sql2oUserDao(sql2o);
        CompanynewsDao=new Sql2oCompanynewsDao(sql2o);
        DepartmentDao=new Sql2oDepartmentDao(sql2o);
        //CREATING THE USERS
        post("/users/new","application/json",((request, response) ->{
            User user=google.fromJson(request.body(),User.class);
           userDao.add(user);
           response.status(201);
           return google.toJson(user);
        }));

        //getting all users
        get("/users","applicaton/json",(request, response) -> {
            System.out.println(userDao.All());

            if (userDao.All().size()>0){
                return google.toJson(userDao.All());
            }
            else{
                return "{\"message\":\"Sorry,No user are currently saved.\"}";
            }
        });

        //getting single users
        get("/users/:id","application/json",(request, response) -> {
            int userId =Integer.parseInt(request.params("id"));
            User userid =userDao.getById(userId);
            if(userid == null){
                throw new ApiException(404,String.format("no user with that id"));

            }
            return google.toJson(userid);

        });


        //creating news
        post("/company/new","application/json", (request, response) ->{
            Companynews company=google.fromJson(request.body(),Companynews.class);
            CompanynewsDao.add(company);
            response.status(201);
            return google.toJson(company);
        });
        //getting all the news
        get("/companynews","applicaton/json",(request, response) -> {
            System.out.println(CompanynewsDao.getAll());

            if (CompanynewsDao.getAll().size()>0){
                return google.toJson(CompanynewsDao.getAll());
            }
            else{
                return "{\"message\":\"Sorry,No news are currently saved.\"}";
            }
        });
        //getting single news
        get("/companynews/:id","application/json",(request, response) -> {
            int compId =Integer.parseInt(request.params("id"));
            Companynews compToFind=CompanynewsDao.getById(compId);

            if(compToFind == null){
                throw new ApiException(404,String.format("no company with that id"));

            }
            return google.toJson(compId);

        });

        //posting the depart
        post("/department/new","application/json",((request, response) ->{
            Department department=google.fromJson(request.body(),Department.class);
            DepartmentDao.add(department);
            response.status(201);
            return google.toJson(department);
        }));
        //Filters
        exception(ApiException.class,(exception,request,response) ->{
            ApiException error=exception;
            Map<String,Object> jsonMap = new HashMap<>();
            jsonMap.put("status",error.getStatusCode());
            jsonMap.put("errorM",error.getMessage());
            response.type("application/json");
            response.status(error.getStatusCode());
            response.body(google.toJson(jsonMap));
        });
    }
}
