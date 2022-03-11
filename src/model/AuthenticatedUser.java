package model;

public class AuthenticatedUser {

    private String name;
    private String email;
    private String role;
    private Integer id;

    public AuthenticatedUser() {
    }

    public AuthenticatedUser(String name, String email, String role, Integer id) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AuthenticatedUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                '}';
    }
}
