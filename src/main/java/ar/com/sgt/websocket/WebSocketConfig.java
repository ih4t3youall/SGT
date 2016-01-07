package ar.com.sgt.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig  extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	//a donde nos vamos a subscribir ejemplo /topic/ws
        config.enableSimpleBroker("/topic");
        //nombre del socket
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // TODO Auto-generated method stub
    	//distintos canales de subcripcion , en cada canal podemos hacer un broadcast de la informacion que queramos , se utiliza json
        registry.addEndpoint("/hello").withSockJS();
        registry.addEndpoint("/ws").withSockJS();
    }

}