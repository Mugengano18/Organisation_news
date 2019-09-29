CREATE DATABASE organisation;
\c organisation;
CREATE TABLE users(id SERIAL PRIMARY KEY,name VARCHAR,positioninc VARCHAR,role VARCHAR,departid INTEGER);
CREATE TABLE department(id SERIAL PRIMARY KEY,name VARCHAR,description VARCHAR,noofemployees VARCHAR);
CREATE TABLE news(id SERIAL PRIMARY KEY,writtenby VARCHAR,content VARCHAR,departid INTEGER,createdon BIGINT);
CREATE TABLE companynews(id SERIAL PRIMARY KEY,writtenby VARCHAR,content VARCHAR);
CREATE TABLE user_department(id SERIAL PRIMARY KEY,userid INTEGER,departid INTEGER);
CREATE TABLE news_department(id SERIAL PRIMARY KEY,departid INTEGER,newsid INTEGER);
CREATE DATABASE organisation_test WITH TEMPLATE organisation;