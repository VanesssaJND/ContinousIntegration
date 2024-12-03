package com.crisdev.projects.integracioncontinua;

import io.sentry.Sentry;
import io.sentry.spring.jakarta.EnableSentry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSentry(dsn = "DNS_SENTRY")
@SpringBootApplication
public class IntegracionContinuaApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(IntegracionContinuaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            throw new Exception("This is a test");
        } catch (Exception e){
            //Sentry.captureException(e);
        }
    }

}