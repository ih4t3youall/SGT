package ar.com.sgt.services.impl;
 
import org.springframework.stereotype.Service;
 

/**
 * POJO class, have handleMessage(...) method. 
 * The return of handleMessage(...) will be 
 * automatically send back to message.getJMSReplyTo().  
 */
@Service
public class JmsMessageListener {
 
  public String handleMessage(String text) {
    System.out.println("Received: " + text);
    return "ACK from handleMessage";
  }
}