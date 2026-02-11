package ee.valiit.catmanager.controller.catstatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.catmanager.persistence.catstatus.CatStatus}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatStatusDto implements Serializable {
    @Size(max = 50)
    private String statusCode;
    @NotNull
    @Size(max = 50)
    private String label;
}