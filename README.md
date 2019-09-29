# Organisation_news
By Mugengano Alice

## Description
this is an app where the user will be able to interact with the company's options like seeing all the users of the company and also seeing a specific user of the company,and will also be able to 
see all the department in a company and you can associate it with the news frm the department and I used many relationships in datbse;
## Application setup

- If you want to implement this project make sure you have all the necessary tools installed in your machine and to have all the required dependencies to inplement the projec
- If you want to get to where the app is use this link to access the repository[Organisation_api](https://github.com/Mugengano18/Organisation_news)
- You also have to create databases and tables here is some help for the tables


CREATE DATABASE organisation;


\c organisation;


CREATE TABLE users(id SERIAL PRIMARY KEY,name VARCHAR,positioninc VARCHAR,role VARCHAR,departid INTEGER);


CREATE TABLE department(id SERIAL PRIMARY KEY,name VARCHAR,description VARCHAR,noofemployees VARCHAR);



CREATE TABLE news(id SERIAL PRIMARY KEY,writtenby VARCHAR,content VARCHAR,departid INTEGER,createdon BIGINT);


CREATE TABLE companynews(id SERIAL PRIMARY KEY,writtenby VARCHAR,content VARCHAR);



CREATE TABLE user_department(id SERIAL PRIMARY KEY,userid INTEGER,departid INTEGER);


CREATE TABLE news_department(id SERIAL PRIMARY KEY,departid INTEGER,newsid INTEGER);


CREATE DATABASE organisation_test WITH TEMPLATE organisation;


## Technologies Used

- java
- Spark framework
- Junit
- Postgress Database
- Json and Gson



## MIT License

Copyright (c) 2019 Mugengano18

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
