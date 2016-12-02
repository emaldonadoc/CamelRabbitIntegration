package com.railtronix.traker.camel

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Value;

@Component
class TrakingRoute extends RouteBuilder {

  @Value('${rest.host}') String host
  @Value('${rest.port}') String port


  @Override
  void configure() throws Exception {
    println "HOST ${host} ========== PORT ${port}"

      restConfiguration()
          .component('jetty')
          .host(host).port(port)
          .bindingMode(RestBindingMode.json)

      rest('/tracking')
          .get()
              .constant("HELLO THERE");
  }
 }
