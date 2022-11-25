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
public class ConnectorConfig {
	
    @JsonProperty("connector.class")
    private String connectorClass;
    @JsonProperty("tasks.max")
    private String maxTasks;
    
    // for properties related to mongodb
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

    // for properties related to postgres
    @JsonProperty("database.hostname")
    private String dbHostname;
    @JsonProperty("database.port")
    private String dbPort;
    @JsonProperty("database.user")
    private String dbUser;
    @JsonProperty("database.password")
    private String dbPassword;
    @JsonProperty("database.dbname")
    private String dbName;
    @JsonProperty("database.server.name")
    private String dbServerName;
    @JsonProperty("table.include.list")
    private String tableIncludeList;
    
}