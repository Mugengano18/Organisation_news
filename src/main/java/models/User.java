package models;

import java.util.Objects;

public class User {
    private String uname;
    private String posInCom;
    private String role;
    private int depart;
    private  int id;



    public User(String uname, String posInCom, String role, int depart) {
        this.uname = uname;
        this.posInCom = posInCom;
        this.role = role;
        this.depart = depart;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPosInCom() {
        return posInCom;
    }

    public void setPosInCom(String posInCom) {
        this.posInCom = posInCom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepart() {
        return depart;
    }

    public void setDepart(int depart) {
        this.depart = depart;
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
        return depart == user.depart &&
                Objects.equals(uname, user.uname) &&
                Objects.equals(posInCom, user.posInCom) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uname, posInCom, role, depart);
    }
}
