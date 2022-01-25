package projecthrissinauKodingBE18.projecthrisbe18.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "position")
@Setter
@Getter
@NoArgsConstructor
public class Position extends BaseEntity<Position> {

    private static final long serialVersionUID = -1012506979568638734L;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;
}
