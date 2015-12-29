package ar.com.sgt.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_empl")
@Data
@SuppressWarnings("unused")
public class User implements Serializable{  

    @Id
    @Column(name="user_id")
    private Integer userId;
    
    private String username;
    
    private String password;
    
    private Boolean enabled;
    

}
