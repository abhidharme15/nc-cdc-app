package com.cdc.nc.model.connector;

import com.cdc.nc.model.config.SinkConfig;
import com.cdc.nc.model.config.SourceConfig;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SinkKafkaConnector extends CommonKafkaConnector {

	private String name;
	private SinkConfig config;

}
