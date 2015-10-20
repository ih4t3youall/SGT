package ar.com.sgt.services;

import ar.com.sgt.dto.ClienteDTO;

public interface UserService {

	ClienteDTO getUserByPin(int pin);
	
}
