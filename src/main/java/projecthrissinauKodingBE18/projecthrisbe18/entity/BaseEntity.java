package projecthrissinauKodingBE18.projecthrisbe18.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import projecthrissinauKodingBE18.projecthrisbe18.ProjectHrisBe18Application;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@DynamicUpdate
@SuppressWarnings("unchecked")
public abstract class BaseEntity<T> implements Serializable {


    private static final long serialVersionUID = 4142086823101907105L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "deleted")
    private Boolean deleted = Boolean.FALSE;

    @Column(name = "deleted_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedTime;

    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "deleted_by")
    private Long deletedBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @PrePersist
    protected void onCreate() {
        setCreatedTime(new Date());
//        setCreatedBy(ProjectHrisBe18Application.getCurrentUser() != null
//                ? ProjectHrisBe18Application.getCurrentUser().getId()
//                : 0);
    }

    @PreRemove
    protected void onRemove() {
        setDeleted(Boolean.TRUE);
        setDeletedTime(new Date());
    }

    @PreUpdate
    protected void onUpdate() {
        setUpdatedTime(new Date());
//        setUpdatedBy(ProjectHrisBe18Application.getCurrentUser() != null
//        ? ProjectHrisBe18Application.getCurrentUser().getId() : 0);
//
}
}

