package ar.com.sgt.persistence.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
@SuppressWarnings("unused")
public class Cubiculo implements Serializable {
    
    @Id
    @Column(name="cubiculo_id")
    private String codigoCubiculo;
    
    @ManyToMany(mappedBy = "cubiculos")
    private Set<TipoTramite> tiposTramites;
    
}
