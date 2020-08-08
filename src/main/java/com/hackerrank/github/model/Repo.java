package com.hackerrank.github.model;

import com.hackerrank.github.util.TxtWriter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.IOException;

@Entity
@Table
public class Repo {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "url")
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

		String res=TxtWriter.readUrlFromFile(url);

		return res;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
