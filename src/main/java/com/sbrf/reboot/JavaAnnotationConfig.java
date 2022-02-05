package com.sbrf.reboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaAnnotationConfig {
    private final String accountMessage = "Bean = Account: Hello there from from Java-config!";
    private final String clientMessage = "Bean = Client: Hello there from Java-config!";

    @Bean
    public Account account(){
        return new Account(accountMessage);
    }
    @Bean
    public Client client(){
        return new Client(clientMessage);
    }
}
