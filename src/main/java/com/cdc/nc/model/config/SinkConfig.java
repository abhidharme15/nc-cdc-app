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
public class SinkConfig extends CommonConfig {

	@JsonProperty("topics")
	private String topics;
	@JsonProperty("connection.url")
	private String connectionUrl;
	@JsonProperty("auto.create")
	private String autoCreate;
	@JsonProperty("auto.evolve")
	private String autoEvolve;
	@JsonProperty("insert.mode")
	private String insertMode;
	@JsonProperty("delete.enabled")
	private String deleteEnabled;
	@JsonProperty("pk.fields")
	private String pkFields;
	@JsonProperty("pk.mode")
	private String pkMode;
	/*
	 * @JsonProperty("transforms") private String transforms;
	 */
	@JsonProperty("transforms.mongoflatten.type")
	private String mongoFlattenType;
	@JsonProperty("transforms.mongoflatten.drop.tombstones")
	private String mongoFlattendropTombstones;
	
}
