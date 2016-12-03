package com.railtronix.traker.camel

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.context.annotation.Bean;

@Component
class TrakingRoute extends RouteBuilder {

  @Value('${rest.host}') String host
  @Value('${rest.port}') String port


  @Override
  void configure() throws Exception {
    /*
      restConfiguration()
          .component('jetty')
          .host(host).port(port)
          .bindingMode(RestBindingMode.json)

      rest('/tracking')
          .get()
              .constant("HELLO THERE");*/

    from("rabbitmq://localhost?queue=rlx-tracker&durable=true&prefetch=1")
      .constant("HELLO THERE !!!!!")
  }

 }

/*
class RabbitConf {

  @Bean(destroyMethod = "destroy")
  public ConnectionFactory rabbitConnectionFactory() {
      CachingConnectionFactory factory = new CachingConnectionFactory(
              "localhost",
              5672
      );

      factory.setUsername("guest");
      factory.setPassword("guest");

      return factory;
  }

}*/
