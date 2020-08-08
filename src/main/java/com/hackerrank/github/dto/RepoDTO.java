package com.hackerrank.github.dto;

import java.io.IOException;

public class RepoDTO {

	private Long id;

	private String name;

	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() throws IOException {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
