package com.wrangling.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wrangling.exceptions.ParsingException;
import com.wrangling.mapper.QueryMapper;
import com.wrangling.models.Query;
import com.wrangling.operators.RelationalExpression;
import com.wrangling.parser.VisitorParser;
import com.wrangling.request.WranglingRequest;

@RestController
public class QueryController {

	@GetMapping("/")
	public String getWelcomeMessage() {
		return "API is working";
	}

	@PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getQuery(@RequestBody WranglingRequest request) {
		System.out.println(request);
		VisitorParser visitorParser = new VisitorParser();
		Query query;
		String response = "Something went wrong. Please check your request!";
		RelationalExpression relationalExpression = null;
		QueryMapper queryMapper = new QueryMapper();
		try {
			query = visitorParser.parse(request.getQuery());
			relationalExpression = queryMapper.mapQuery(query);
			if (relationalExpression != null) {
				response = relationalExpression.getJson(null).toString();
			}
		} catch (ParsingException e) {
			if (e.getMessage() != null) {
				response = e.getMessage();
			}

			e.printStackTrace();
		} catch (Exception e) {
			if (e.getMessage() != null) {
				response = e.getMessage();
			}
			e.printStackTrace();
		}

		return response;
	}
}
