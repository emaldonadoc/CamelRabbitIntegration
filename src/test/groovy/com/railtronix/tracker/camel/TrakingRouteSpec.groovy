package com.railtronix.traker.camel

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
class TrakingRouteSpec {

   @Test
   public void RabbitConnection () {
     CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("rabbitmq://localhost:5672/railtronix")
                 .to("log:foo")
            }
        });

        context.start();
   }


}
