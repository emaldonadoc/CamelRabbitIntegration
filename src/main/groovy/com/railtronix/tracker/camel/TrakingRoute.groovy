package com.railtronix.traker.camel

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.context.annotation.Bean;

@Component
class TrakingRoute extends RouteBuilder {

  @Value('${rabbitmq.host}') String host
  @Value('${rabbitmq.port}') String port
  @Value('${rabbitmq.exchange}') String exchange
  @Value('${rabbitmq.queueTrack}') String queue


  @Override
  void configure() throws Exception {
    from("rabbitmq://${host}:${port}/${exchange}?autoDelete=false&queue=${queue}")
      .to("stream:out") 
  }


 }

