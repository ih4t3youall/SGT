package ar.com.sgt.services.impl;

import ar.com.sgt.persistence.entity.ClienteDTO;
import ar.com.sgt.services.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public ClienteDTO getUserByPin(int pin) {

		// es un mock
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setApellido("un apellido");
		clienteDTO.setNombre("unNombre");
		clienteDTO.setCbu("01937410284713987129");
		clienteDTO.setId_usuario(20);
		clienteDTO.setPin(pin);

		return clienteDTO;
	}

}
