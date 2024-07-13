package com.leokenzley.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	private TokenRelayGatewayFilterFactory filterFactory;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("messages", r -> r.path("/messages")
						.filters(f -> f.filters(filterFactory.apply())
								.removeRequestHeader("Cookie"))
						.uri("http://localhost:8082"))
				.build();
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
