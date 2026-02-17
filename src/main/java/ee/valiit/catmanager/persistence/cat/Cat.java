package ee.valiit.catmanager.persistence.cat;

import ee.valiit.catmanager.persistence.catstatus.CatStatus;
import ee.valiit.catmanager.persistence.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private CatStatus status;

    @Column (name = "arrived_at")
    private LocalDate arrivedAt;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Positive
    @Column(name = "weight", precision = 4, scale = 2)
    private BigDecimal weight;

    @Size(max = 10)
    @Column(name = "sex", length = 10)
    private String sex;


    @Pattern(regexp = "^[0-9]{15}$")
    @Column(name = "chip_number", length = 20)
    private String chipNumber;

    @Column(name = "health_info", length = Integer.MAX_VALUE)
    private String healthInfo;

    @Column(name = "other_info", length = Integer.MAX_VALUE)
    private String otherInfo;

    @NotNull
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Instant createdAt;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}