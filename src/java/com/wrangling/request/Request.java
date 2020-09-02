package com.wrangling.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "queries" })
public class Request {

//	@JsonProperty("queries")
//	private List<Query> queries = null;
//
//	@JsonProperty("queries")
//	public List<Query> getQueries() {
//		return queries;
//	}
//	@JsonProperty("queries")
//	public void setQueries(List<Query> queries) {
//		this.queries = queries;
//	}
}