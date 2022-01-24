package projecthrissinauKodingBE18.projecthrisbe18.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "bank")
@Getter
@Setter
@NoArgsConstructor

public class Bank extends BaseEntity<Bank> {


    private static final long serialVersionUID = 3392436355282797227L;


    @Column(name = "name", columnDefinition = "VARCHAR(40)")
    private String name;

    @Column(name = "code", columnDefinition = "VARCHAR(10)")
    private String code;
}
