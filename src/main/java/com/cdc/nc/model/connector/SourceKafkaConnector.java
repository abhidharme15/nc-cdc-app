package com.cdc.nc.model.connector;

import com.cdc.nc.model.config.SourceConfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SourceKafkaConnector extends CommonKafkaConnector {

	private String name;
	private SourceConfig config;

}
