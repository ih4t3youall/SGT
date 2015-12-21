package ar.com.sgt.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import ar.com.sgt.persistence.dao.IHistorialTicketDao;
import ar.com.sgt.persistence.entity.HistorialTicket;

public class HistorialTicketWriter implements ItemWriter<HistorialTicket>, InitializingBean {

        private IHistorialTicketDao dao;


        @Override
        public void write(List<? extends HistorialTicket> items) throws Exception {
            for (HistorialTicket hTicket : items) {
                dao.persist(hTicket);
            }
            try {
                dao.flush();
            }
            finally {

            }

        }

        public void setDao(IHistorialTicketDao dao) {
            this.dao = dao;
        }


        @Override
        public void afterPropertiesSet() throws Exception {
            Assert.notNull(dao, "Delegate DAO must be set");
        }

}
