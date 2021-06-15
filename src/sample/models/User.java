package sample.models;

public interface User {
    String id = "";
    String email = "";
    String password = "";
    Role role = null;

    String getId();

    void setId(String id);

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    Role getRole();

    void setRole(Role role);

}
