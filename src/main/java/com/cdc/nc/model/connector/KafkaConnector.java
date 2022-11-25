package com.cdc.nc.model.connector;

import com.cdc.nc.model.config.SinkConfig;
import com.cdc.nc.model.config.SourceConfig;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KafkaConnector {

	@JsonProperty("name")
	private String name;

	@JsonProperty("sourceConfig")
	private SourceConfig sourceConfig;

	@JsonProperty("sinkConfig")
	private SinkConfig sinkConfig;
}
