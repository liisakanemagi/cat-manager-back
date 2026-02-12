package ee.valiit.catmanager.controller.register;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @NotNull
    @Size(max = 50)
    private String username;
    @NotNull
    @Size(max = 255)
    private String password;
    @Size(max = 100)
    private String email;
}