package ee.valiit.catmanager.controller.cat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatInfo {
    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Size(max = 20)
    private String status;

    private LocalDate arrivedAt;

    private LocalDate birthday;

    private BigDecimal weight;

    @Size(max = 10)
    private String sex;

    @Size(max = 50)
    private String chipNumber;

    @Size(max = 500)
    private String healthInfo;

    @Size(max = 500)
    private String otherInfo;

    @Size(max = 255)
    private String imageUrl;

    private Instant createdAt;
}