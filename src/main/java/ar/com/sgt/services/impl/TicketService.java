package ar.com.sgt.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.springframework.util.StringUtils;

import ar.com.sgt.persistence.constants.PDFTicketNames;
import ar.com.sgt.persistence.constants.TicketEstado;
import ar.com.sgt.persistence.dao.ITicketDao;
import ar.com.sgt.persistence.dao.exception.DaoException;
import ar.com.sgt.persistence.entity.Ticket;
import ar.com.sgt.persistence.entity.TicketId;
import ar.com.sgt.services.ITicketService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketService implements ITicketService {

    private ITicketDao ticketDao;

    private String pathTemplate;

    @Override
    public String crearTicket(String tipoCliente, String tipoTramite) {
        try {
            Calendar time=Calendar.getInstance();
            Ticket ticket = insertTicket(tipoCliente, tipoTramite,time);
            return generatesPDF(ticket,time);
        } catch (IOException e) {
            log.error("an exception was thrown", e);
        }catch (DaoException e) {
            log.error("an exception was thrown", e);
        } catch (COSVisitorException e) {
            log.error("an exception was thrown", e);
        }
        return null;
    }

    private String generatesPDF(Ticket ticket,Calendar time) throws IOException, COSVisitorException {
        String workingDir = System.getProperty("catalina.base");
        PDDocument pdfTemplate = PDDocument.load(workingDir + pathTemplate);
        pdfTemplate.getNumberOfPages();
        PDDocumentCatalog docCatalog = pdfTemplate.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        acroForm.getField(PDFTicketNames.NUMERO_TURNO.getName())
                .setValue(ticket.getIdTicket().getTipo() + String.format("%03d",ticket.getIdTicket().getTicketId()));
        acroForm.getField(PDFTicketNames.FECHA_TURNO.getName()).setValue(String.format("%02d", time.get(Calendar.DAY_OF_MONTH))+"/"+String.format("%02d",time.get(Calendar.MONTH)+1)+"/"+time.get(Calendar.YEAR));
        acroForm.getField(PDFTicketNames.HORA_TURNO.getName()).setValue(String.format("%02d",time.get(Calendar.HOUR_OF_DAY))+":"+String.format("%02d",time.get(Calendar.MINUTE))+":"+String.format("%02d",time.get((Calendar.SECOND))));
        String pathLocationSave = System.getProperty("java.io.tmpdir") + UUID.randomUUID() + ".pdf";
        log.info(pathLocationSave);
        pdfTemplate.save(pathLocationSave);
        pdfTemplate.close();
        return pathLocationSave;
    }

    public ITicketDao getTicketDao() {
        return ticketDao;
    }

    public void setTicketDao(ITicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    private Ticket insertTicket(String tipoCliente, String tipoTramite, Calendar time) throws DaoException {
        Integer id = ticketDao.getNextId(tipoTramite);
        Ticket ticket = new Ticket();
        TicketId idTicket = new TicketId();
        idTicket.setTicketId(id);
        idTicket.setTipo(tipoTramite);
        ticket.setIdTicket(idTicket);
        ticket.setTipoCliente(tipoCliente);
        ticket.setFechaCreacion(new Timestamp(time.getTimeInMillis()));
        ticket.setEstado(TicketEstado.CREADO.name());
        ticketDao.persist(ticket);
        return ticket;
    }

    public String getPathTemplate() {
        return pathTemplate;
    }

    public void setPathTemplate(String pathTemplate) {
        this.pathTemplate = pathTemplate;
    }

}
