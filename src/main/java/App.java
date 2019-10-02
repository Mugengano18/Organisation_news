import com.google.gson.Gson;
import data.*;
import exceptions.ApiException;
import models.Companynews;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;
import spark.ModelAndView;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        Sql2oUserDao userDao;
        Sql2oCompanynewsDao CompanynewsDao;
        Sql2oDepartmentDao DepartmentDao;
        Sql2oNewsDao NewsDao;
        Connection connnect;
        Gson google =new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/organisation"; //connecting to organisation
        Sql2o sql2o = new Sql2o(connectionString, "alice", "20001");  //this is a connection string

        userDao= new Sql2oUserDao(sql2o);
        CompanynewsDao=new Sql2oCompanynewsDao(sql2o);
        DepartmentDao=new Sql2oDepartmentDao(sql2o);
        NewsDao=new Sql2oNewsDao(sql2o);
//        //CREATING THE USERS
//        post("/users/new","application/json",((request, response) ->{
//            User user=google.fromJson(request.body(),User.class);
//           userDao.add(user);
//           response.status(201);
//           return google.toJson(user);
//        }));
//
//        //getting all users
//        get("/users","applicaton/json",(request, response) -> {
//            System.out.println(userDao.All());
//
//            if (userDao.All().size()>0){
//                return google.toJson(userDao.All());
//            }
//            else{
//                return "{\"message\":\"Sorry,No user are currently saved.\"}";
//            }
//        });
//
//        //getting single users
//        get("/users/:id","application/json",(request, response) -> {
//            int userId =Integer.parseInt(request.params("id"));
//            User userid =userDao.getById(userId);
//            if(userid == null){
//                throw new ApiException(404,String.format("no user with that id"));
//
//            }
//            return google.toJson(userid);
//
//        });
//
//        //Adding users to departments
//        post("/users/:userId/depart/:departId", "application/json", (req, res) -> {
//
//            int userId = Integer.parseInt(req.params("userId"));
//            int departId = Integer.parseInt(req.params("departId"));
//            User user = userDao.getById(userId);
//            Department depart  = DepartmentDao.getById(departId);
//
//
//            if (user != null && depart != null){
//                //both exist and can be associated
//                DepartmentDao.AddDepartToUser(user,depart);
//                res.status(201);
//                return google.toJson(String.format("Restaurant '%s' and Foodtype '%s' have been associated",depart.getDname(), user.getUname()));
//            }
//            else {
//                throw new ApiException(404, String.format("User or department does not exist!!"));
//            }
//        });
//
//        //creating news
//        post("/company/new","application/json", (request, response) ->{
//            Companynews company=google.fromJson(request.body(),Companynews.class);
//            CompanynewsDao.add(company);
//            response.status(201);
//            return google.toJson(company);
//        });
//        //getting all the news
////        get("/companynews","applicaton/json",(request, response) -> {
////            System.out.println(CompanynewsDao.getAll());
////
////            if (CompanynewsDao.getAll().size()>0){
////                return google.toJson(CompanynewsDao.getAll());
////            }
////            else{
////                return "{\"message\":\"Sorry,No news are currently saved.\"}";
////            }
////        });
//        //getting single news
//        get("/companynews/:id","application/json",(request, response) -> {
//            int compId =Integer.parseInt(request.params("id"));
//            Companynews compToFind=CompanynewsDao.getById(compId);
//
//            if(compToFind == null){
//                throw new ApiException(404,String.format("no company with that id"));
//
//            }
//            return google.toJson(compId);
//
//        });
//
//        //posting the depart
//        post("/department/new","application/json",((request, response) ->{
//            Department department=google.fromJson(request.body(),Department.class);
//            DepartmentDao.add(department);
//            response.status(201);
//            return google.toJson(department);
//        }));
//        //getting all the department
//        get("/department","applicaton/json",(request, response) -> {
//            System.out.println(DepartmentDao.All());
//
//            if (DepartmentDao.All().size()>0){
//                return google.toJson(DepartmentDao.All());
//            }
//            else{
//                return "{\"message\":\"Sorry,No department are currently saved.\"}";
//            }
//        });
//        //getting the department by id
//        get("/companynews/:id","application/json",(request, response) -> {
//            int depId =Integer.parseInt(request.params("id"));
//            Department depToFind=DepartmentDao.getById(depId);
//
//            if(depToFind == null){
//                throw new ApiException(404,String.format("no company with that id"));
//
//            }
//            return google.toJson(depId);
//
//        });
//
//
//
//        //posting the department news
//        post("/news/new","application/json", (request, response) ->{
//            News news=google.fromJson(request.body(),News.class);
//            NewsDao.add(news);
////            news.setCreation();
//            news.setFormatCreation();
//            response.status(201);
//            return google.toJson(news);
//        });
//        //getting the news
//        get("/news","applicaton/json",(request, response) -> {
//            System.out.println(NewsDao.All());
//
//            if (NewsDao.All().size()>0){
//                return google.toJson(NewsDao.All());
//            }
//            else{
//                return "{\"message\":\"Sorry,No news posted.\"}";
//            }
//        });
//        //getting the news by id
//        get("/news/:id","application/json",(request, response) -> {
//            int depaId =Integer.parseInt(request.params("id"));
//            News newsToFind=NewsDao.getById(depaId);
//
//            if(newsToFind == null){
//                throw new ApiException(404,String.format("no company with that id"));
//
//            }
//            return google.toJson(depaId);
//
//        });
//        //Filters
//        exception(ApiException.class,(exception,request,response) ->{
//            ApiException error=exception;
//            Map<String,Object> jsonMap = new HashMap<>();
//            jsonMap.put("status",error.getStatusCode());
//            jsonMap.put("errorM",error.getMessage());
//            response.type("application/json");
//            response.status(error.getStatusCode());
//            response.body(google.toJson(jsonMap));
//        });

        //the home page
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "home.hbs");
        }, new HandlebarsTemplateEngine());

        //getting the department form
        get("/department/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "departmentform.hbs");
        }, new HandlebarsTemplateEngine());

        //posting the deprt
        post("/department/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            String name= request.queryParams("name");
            String explain=request.queryParams("description");
            int noofemployees= Integer.parseInt(request.queryParams("noofemployees"));
            Department depart=new Department(name,explain,noofemployees);
            DepartmentDao.add(depart);
            System.out.println(noofemployees);
            model.put("dep",depart);
            return new ModelAndView(model, "savedepart.hbs");
        }), new HandlebarsTemplateEngine());


        //getting all the departments
        get("/departments", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Department>depart=DepartmentDao.All();
            model.put("department",depart);
            return new ModelAndView(model, "alldepartments.hbs");
        }, new HandlebarsTemplateEngine());


        //getting the form to input the news
        get("/generalnews", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "generalnewsform.hbs");
        }, new HandlebarsTemplateEngine());



        //posting the news
        post("/generalnews",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            String written=request.queryParams("content");
            String content= request.queryParams("writtenby");
            Companynews company= new Companynews(content,written);
            System.out.println(written);
            CompanynewsDao.add(company);
            return new ModelAndView(model, "Generalnews.hbs");
        }), new HandlebarsTemplateEngine());



        //getting the form for the user
        get("/users/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Department>depart=DepartmentDao.All();
            model.put("department",depart);
            return new ModelAndView(model, "userform.hbs");
        }, new HandlebarsTemplateEngine());


        //posting the users
        post("/users/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            String name=request.queryParams("name");
            String pos=request.queryParams("positioninc");
            String role=request.queryParams("role");
            String depart=request.params("departid");
            User use=new User(name,pos,role,depart);
            model.put("name",name);
            model.put("position",pos);
            model.put("role",role);
            userDao.add(use);
            return new ModelAndView(model, "saveuser.hbs");
        }), new HandlebarsTemplateEngine());


        //getting all the users
        get("/users", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<User> user= userDao.All();
            model.put("user",user);
            return new ModelAndView(model, "allusers.hbs");
        }, new HandlebarsTemplateEngine());


        //getting all the news
        get("/news", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Companynews> company=CompanynewsDao.getAll();
            model.put("general",company);
            return new ModelAndView(model, "Generalnews.hbs");
        }, new HandlebarsTemplateEngine());



        //deleting individual news


        get("news/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfnewsToDel = Integer.parseInt(req.queryParams("id"));
            CompanynewsDao.deleteById(idOfnewsToDel);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());




    }
}
