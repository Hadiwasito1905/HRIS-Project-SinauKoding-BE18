package projecthrissinauKodingBE18.projecthrisbe18.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends BaseEntity<Employee> {

    private static final long serialVersionUID = 8824698469740862482L;

    public enum StatusEmployee {
        ACTIVE,
        INACTIVE
    }

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "nip",columnDefinition ="VARCHAR(255)" )
    private String nip;

    @Column(name = "status", columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private StatusEmployee status = StatusEmployee.ACTIVE;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}

