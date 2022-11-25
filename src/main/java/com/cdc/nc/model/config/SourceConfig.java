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
public class SourceConfig extends CommonConfig {

	@JsonProperty("mongodb.name")
	private String mongoDbName;
	@JsonProperty("mongodb.hosts")
	private String mongoDbHosts;
	@JsonProperty("mongodb.user")
	private String mongoDbUser;
	@JsonProperty("mongodb.password")
	private String mongoDbPassword;
	@JsonProperty("database.include.list")
	private String databaseIncludeList;
	@JsonProperty("schema.history.internal.kafka.bootstrap.servers")
	private String kafkaServerUrl;
	/*
	 * @JsonProperty("transforms") private String transforms;
	 */
	@JsonProperty("transforms.route.type")
	private String transformsRouteType;
	@JsonProperty("transforms.route.regex")
	private String transformsRouteRegex;
	@JsonProperty("transforms.route.replacement")
	private String transformsRouteReplacement;
	
}
