package backend.src.main.java.com.openmart.core.user.domain;

import java.util.List;

/**
 * Created by Nawa on 7/9/2016.
 */
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private UserImage image;
    private Address address;
    private List<Product> products;

    public User() {

    }

    public User(String firstName, String lastName, String email, Address address, UserImage image, Role role, List<Product> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.image = image;
        this.role = role;
        this.products = products;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserImage getImage() {
        return image;
    }

    public void setImage(UserImage image) {
        this.image = image;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
