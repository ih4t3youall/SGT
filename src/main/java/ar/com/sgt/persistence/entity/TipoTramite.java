package ar.com.sgt.persistence.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
@SuppressWarnings("unused")
public class TipoTramite implements Serializable {
    
    private String descripcion;
    
    @Id
    private String tipo;
    
    @ManyToMany
/*    @JoinTable(name="TICKETS_CUBICULO",
        joinColumns=
            @JoinColumn(name="cubiculo_id", referencedColumnName="cubiculo_id"),
        inverseJoinColumns=
            @JoinColumn(name="tipo_id", referencedColumnName="tipo")
        )*/
    private Set<Cubiculo> cubiculos; 
    

}
