package ar.com.sgt.persistence.entity;

import org.junit.Assert;
import org.junit.Test;



public class ClienteTest {
    
    @Test
    public void testGettersAndSetters(){
        Cliente cliente= new Cliente();
        cliente.setApellido("Perez");
        cliente.setIdcliente(1);
        cliente.setPin(2);
        cliente.setPwd("sonar");
        cliente.setUsuario("PerezRow");
        cliente.setNombre("Pablo");
        Assert.assertEquals("Perez", cliente.getApellido());
        Assert.assertEquals("sonar", cliente.getPwd());
        Assert.assertEquals("PerezRow", cliente.getUsuario());
        Assert.assertEquals("Pablo", cliente.getNombre());
        Assert.assertTrue(1==cliente.getIdcliente());
        Assert.assertTrue(2==cliente.getPin());
    }

}
