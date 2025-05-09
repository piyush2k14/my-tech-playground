package com.example.user;

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

	public static class UserData {
		private int id;
		private String email;
		private String firstName;
		private String lastName;
		private String avatar;

		@JsonProperty("id")
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JsonProperty("email")
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@JsonProperty("first_name")
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		@JsonProperty("last_name")
		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		@JsonProperty("avatar")
		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
	}
}