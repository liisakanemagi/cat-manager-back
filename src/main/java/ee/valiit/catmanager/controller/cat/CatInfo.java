package ee.valiit.catmanager.controller.cat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatInfo {
    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Positive
    private Integer statusId;

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

    @Size(max = 10485760) // 10MB
    private String imageData;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Instant createdAt;
}