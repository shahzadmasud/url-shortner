package com.hackerrank.github.model;

import com.hackerrank.github.util.TxtWriter;

import static com.hackerrank.github.util.Constants.QUERY_ACTOR_GET_ACTORS_ORDERED_BY_MAXIMUM_STREAK;

import java.io.IOException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedNativeQueries({
		@NamedNativeQuery(name = "Actor.getActorsOrderedByMaximumStreak", query = QUERY_ACTOR_GET_ACTORS_ORDERED_BY_MAXIMUM_STREAK, resultClass = Actor.class) })
public class Actor {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "login")
	private String login;

	@Column(name = "avatar")
	private String avatar;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actor")
	private List<Event> events;

	public Actor() {

	}

	public Actor(Long id, String login, String avatar) {
		this.id = id;
		this.login = login;
		this.avatar = avatar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAvatar() throws IOException {

		String res= TxtWriter.readUrlFromFile(avatar);

		return res;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
