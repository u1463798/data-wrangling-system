package com.wrangling;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wrangling.request.WranglingRequest;

public class RequestDeserializer extends JsonDeserializer<WranglingRequest> {

	@Override
	public WranglingRequest deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		ObjectCodec oc = jp.getCodec();
	    JsonNode node = oc.readTree(jp);
	    String query = node.get("query").asText();
		 System.out.println(query);
		return  new WranglingRequest(query);
	}

}
