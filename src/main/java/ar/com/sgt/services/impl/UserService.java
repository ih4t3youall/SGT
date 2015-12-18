package ar.com.sgt.services.impl;

import ar.com.sgt.persistence.dto.ClienteDTO;
import ar.com.sgt.persistence.dto.UserDTO;
import ar.com.sgt.services.IUserService;

public class UserService implements IUserService {

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

	@Override
	public UserDTO getUserDTO() {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setIdUser(1);
		userDTO.setApellido("apellido");
		userDTO.setNombre("nombre");
		userDTO.setPassword("password");
		
		return userDTO;
	}
}
