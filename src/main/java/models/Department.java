package models;

import java.util.Objects;

public class Department {
    private String dname;
    private String description;
    private int employee;
    private int id;


    public Department(String dname, String description, int employee) {
        this.dname = dname;
        this.description = description;
        this.employee = employee;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDescripton() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return employee == that.employee &&
                Objects.equals(dname, that.dname) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dname, description, employee);
    }
}
