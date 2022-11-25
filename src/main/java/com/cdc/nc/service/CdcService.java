package com.cdc.nc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cdc.nc.model.connector.CommonKafkaConnector;
import com.cdc.nc.model.connector.KafkaConnector;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CdcService {
	
	@Autowired
	private WebClient webClient;

	public KafkaConnector createKafkaConnector(CommonKafkaConnector request) {
		return webClient.post()
				.uri("/connectors")
				.body(Mono.just(request), KafkaConnector.class)
				.retrieve()
				.bodyToMono(KafkaConnector.class)
				.block();
	}
	
	public KafkaConnector deleteKafkaConnector(String connectorName) {
		return webClient.delete()
				.uri("/connectors/{connectorName}", connectorName)
				.retrieve()
				.bodyToMono(KafkaConnector.class)
				.block();
	}

	public KafkaConnector getKafkaConnectorStatus(String connectorName) {
		return webClient.get()
				.uri("/connectors/{connectorName}/status", connectorName)
				.retrieve()
				.bodyToMono(KafkaConnector.class)
				.block();
	}
	
}
