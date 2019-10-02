package models;

import java.util.Objects;

public class User {
    private String name;
    private String positioninc;
    private String role;
    private String departid;
    private  int id;



    public User(String name, String positioninc, String role, String departid) {
        this.name = name;
        this.positioninc = positioninc;
        this.role = role;
        this.departid = departid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositioninc() {
        return positioninc;
    }

    public void setPositioninc(String positioninc) {
        this.positioninc = positioninc;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartid() {
        return departid;
    }

    public void setDepartId(String departId) {
        this.departid = departid;
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
        User user = (User) o;
        return departid == user.departid &&
                Objects.equals(name, user.name) &&
                Objects.equals(positioninc, user.positioninc) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, positioninc, role, departid);
    }
}
