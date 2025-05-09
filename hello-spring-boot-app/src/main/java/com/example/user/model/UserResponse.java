package com.example.user.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {

	private int page;
	private int perPage;
	private int total;
	private int totalPages;
	private List<UserData> data;

	@JsonProperty("page")
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@JsonProperty("per_page")
	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	@JsonProperty("total")
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@JsonProperty("total_pages")
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	@JsonProperty("data")
	public List<UserData> getData() {
		return data;
	}

	public void setData(List<UserData> data) {
		this.data = data;
	}	
}