package app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

public class SearchResults<T> {

	@JsonView(Summary.class)
	@JsonProperty("results")
	private List<T> results;
	
	@JsonView(Summary.class)
	@JsonProperty("grandTotal")
	private Integer grandTotal;

	public SearchResults(List<T> results, Integer grandTotal) {
		super();
		this.results = results;
		this.grandTotal = grandTotal;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Integer getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}

}
