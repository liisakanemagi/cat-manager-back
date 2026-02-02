package ee.valiit.catmanager.controller.register;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.catmanager.persistence.user.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    @NotNull
    @Size(max = 50)
    private String username;
    @NotNull
    @Size(max = 255)
    private String password;
    @Size(max = 100)
    private String email;
}