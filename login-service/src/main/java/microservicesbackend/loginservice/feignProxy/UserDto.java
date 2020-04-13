package microservicesbackend.loginservice.feignProxy;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long id;
    private String email;
    private String name;
    private String password;
    private List<String> roles = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(Long id, String email, String name, String password, List<String> roles) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
