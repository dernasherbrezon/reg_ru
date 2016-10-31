package com.aerse.ru.reg;

import java.util.List;

public abstract class AbstractInputData {

	private String username;
	private String password;
	private List<InputDataDomain> domains;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<InputDataDomain> getDomains() {
		return domains;
	}

	public void setDomains(List<InputDataDomain> domains) {
		this.domains = domains;
	}

}
