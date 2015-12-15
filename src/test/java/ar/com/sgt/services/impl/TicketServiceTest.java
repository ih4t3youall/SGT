package ar.com.sgt.services.impl;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.mockito.Mockito;

import ar.com.sgt.persistence.dao.exception.DaoException;
import ar.com.sgt.persistence.dao.impl.TicketDao;
import ar.com.sgt.persistence.entity.Ticket;
import static org.junit.Assert.*;
public class TicketServiceTest {

	private TicketService ticketService = new TicketService();

	@Test
	public void crearTicket() throws IOException {

		TicketDao ticketDAO = Mockito.mock(TicketDao.class);
		Mockito.when(ticketDAO.getNextId(Mockito.any(String.class))).thenReturn(1);
		SystemHelper systemHelper = Mockito.mock(SystemHelper.class);

		String property = System.getProperty("user.home");
		property += "\\Desktop\\";
		String propertyCrear = "";
		propertyCrear +=property + "\\archivo.pdf";
		new File(propertyCrear).createNewFile();
		

		Mockito.when(systemHelper.getCatalinaBase()).thenReturn(property);
		Mockito.when(systemHelper.getTemporalDir()).thenReturn(property);
		try {
			Mockito.doNothing().when(ticketDAO).persist(Mockito.any(Ticket.class));
		} catch (DaoException e) {
			System.out.println("wololo");
			e.printStackTrace();
		}

		ticketService.setSystemHelper(systemHelper);
		ticketService.setTicketDao(ticketDAO);
		ticketService.setPathTemplate("archivo.pdf");
		String crearTicket = ticketService.crearTicket("un cliente", "un tramite");
		assertNotNull(crearTicket);
		

	}

}
