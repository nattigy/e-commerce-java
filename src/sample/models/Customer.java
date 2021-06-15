package sample.models;

import java.util.List;

public class Customer implements User {
    private String id;
    private String email;
    private String password;
    private Role role;
    private String phoneNumber;
    private String cartId;
    private List<Item> items;

    public Customer(String id, String email, String password, Role role, String phoneNumber, String cartId, List<Item> items) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.cartId = cartId;
        this.items = items;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
