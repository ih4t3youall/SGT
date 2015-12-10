package ar.com.sgt.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Sesion implements Serializable{
    
    @Id
    @Column(name="sesion_id")
    private Integer id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cubiculo_Id")
    private Cubiculo cubiculo;
    
    @OneToMany(mappedBy="sesion",fetch=FetchType.LAZY)
    private List<Ticket> tickets;
    
    
    
    
}
