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
    
    private String tipoCliente;
    
    private String descripcion;
    
    @Id
    private String tipo;
    
    @ManyToMany
    private Set<Cubiculo> cubiculos; 
    

}
