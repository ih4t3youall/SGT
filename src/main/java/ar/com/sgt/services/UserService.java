package ar.com.sgt.services;

import ar.com.sgt.persistence.entity.ClienteDTO;

public interface UserService {

    ClienteDTO getUserByPin(int pin);

}
