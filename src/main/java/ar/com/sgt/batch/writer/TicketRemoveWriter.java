package ar.com.sgt.batch.writer;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import ar.com.sgt.persistence.dao.ITicketDao;
import ar.com.sgt.persistence.entity.Ticket;

public class TicketRemoveWriter implements ItemWriter<Ticket>, InitializingBean {

    private ITicketDao dao;


    @Override
    public void write(List<? extends Ticket> items) throws Exception {
        for (Ticket ticket : items) {
            dao.remove(ticket);
        }
        try {
            if (!CollectionUtils.isEmpty(items)){
                dao.flush();
            }  
        }
        finally {

        }

    }

    public void setDao(ITicketDao dao) {
        this.dao = dao;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(dao, "Delegate DAO must be set");
    }

}
