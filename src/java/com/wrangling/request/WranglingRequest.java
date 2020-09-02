package com.wrangling.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wrangling.RequestDeserializer;

//@JsonDeserialize(using =RequestDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "query" })
public class WranglingRequest {

	public WranglingRequest(String query) {
		super();
		this.query = query;
	}

	public WranglingRequest() {
		super();
	}

	@JsonProperty("query")
	private String query;

	@JsonProperty("query")
	public String getQuery() {
		return query;
	}

	@JsonProperty("query")
	public void setQuery(String query) {
		this.query = query;
	}

}
