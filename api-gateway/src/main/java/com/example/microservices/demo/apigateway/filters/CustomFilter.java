package com.example.microservices.demo.apigateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter {
	
	Logger logger = LoggerFactory.getLogger(CustomFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		/**
		 * If you want to put filter specific to a service you can use if-else
		 */
		if(request.getURI().toString().contains("/api/student")) {
			
		}
		
		// Pre filter 
		logger.info("Authorization = " + request.getHeaders().getFirst("Authorization"));
		
		// post filter - we will use lamda
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			ServerHttpResponse response = exchange.getResponse();
			logger.info("Post Filter = " + response.getStatusCode());
		}));
	}

}
