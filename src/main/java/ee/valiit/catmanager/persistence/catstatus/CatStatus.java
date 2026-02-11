package ee.valiit.catmanager.persistence.catstatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cat_statuses")
public class CatStatus {
    @Id
    @Size(max = 50)
    @Column(name = "status_code", nullable = false, length = 50)
    private String statusCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "label", nullable = false, length = 50)
    private String label;

}