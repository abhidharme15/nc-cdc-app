package com.cdc.nc.model.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonConfig {

	@JsonProperty("connector.class")
	private String connectorClass;
	@JsonProperty("tasks.max")
	private String maxTasks;
	@JsonProperty("transforms")
	private String transforms;
	
}
