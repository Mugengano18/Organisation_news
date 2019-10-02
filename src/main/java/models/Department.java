package models;

import java.util.Objects;

public class Department {
    private String name;
    private String description;
    private int noofemployees;
    private int id;



    public Department(String name, String description, int noofemployees) {
        this.name = name;
        this.description = description;
        this.noofemployees = noofemployees;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoofemployees() {
        return noofemployees;
    }

    public void setNoofemployees(int noofemployees) {
        this.noofemployees = noofemployees;
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
        return noofemployees == that.noofemployees &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, noofemployees);
    }
}
