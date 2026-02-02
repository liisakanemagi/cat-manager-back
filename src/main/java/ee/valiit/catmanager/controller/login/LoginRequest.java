package ee.valiit.catmanager.controller.login;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}