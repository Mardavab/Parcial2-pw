package co.edu.usco.pw.parcial2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="role")
public class Role {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @NotEmpty
    private String name;

    public Role(Long idRole, @NotEmpty String name) {
        super();
        this.idRole = idRole;
        this.name = name;
    }

    public Role() {
        super();
    }

    @Override
    public String toString() {
        return "Rol [idRol=" + idRole + ", nombre=" + name + "]";
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRol) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = name;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
