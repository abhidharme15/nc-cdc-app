package com.cdc.nc.controller;

import java.io.IOException;
import java.util.Objects;

import com.cdc.nc.model.connector.SourceKafkaConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdc.nc.model.connector.CommonKafkaConnector;
import com.cdc.nc.model.connector.KafkaConnector;
import com.cdc.nc.model.connector.SinkKafkaConnector;
import com.cdc.nc.service.CdcService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/app/v1")
public class CdcController {
	
	@Autowired
	private CdcService cdcService;
	
	@PostMapping("/start-streaming")
	public ResponseEntity<KafkaConnector> startStreaming(@RequestBody KafkaConnector request) {
		CommonKafkaConnector commonKafkaConnector = null;
		
		if(Objects.nonNull(request.getSourceConfig())) {
			commonKafkaConnector = SourceKafkaConnector.builder()
					.name(request.getName())
					.config(request.getSourceConfig())
					.build();
		}
		else if(Objects.nonNull(request.getSinkConfig())) {
			commonKafkaConnector = SinkKafkaConnector.builder()
					.name(request.getName())
					.config(request.getSinkConfig())
					.build();
		}
		 
		KafkaConnector response = cdcService.createKafkaConnector(commonKafkaConnector);
		return ResponseEntity.created(null).body(response);
	}
	
	@DeleteMapping("/stop-streaming/{connectorName}")
	public ResponseEntity<String> stopStreaming(@PathVariable String connectorName) throws IOException {
		cdcService.deleteKafkaConnector(connectorName);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/get-streaming-status/{connectorName}")
	public ResponseEntity<KafkaConnector> getStreamingStatus(@PathVariable String connectorName) {
		KafkaConnector response = cdcService.getKafkaConnectorStatus(connectorName);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return ResponseEntity.ok().body("Ping Successful");
	}

}
