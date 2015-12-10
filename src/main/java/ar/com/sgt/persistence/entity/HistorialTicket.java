package ar.com.sgt.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@SuppressWarnings("unused")
public class HistorialTicket implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idTicket;
    
    private String username;
    
    private String tipo;
    
    private Date fechaInicio;
    
    private Date fechaFinalizacion;
    
    private String estadoFinal;
    
}
