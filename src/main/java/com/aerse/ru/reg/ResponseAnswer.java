package com.aerse.ru.reg;

import java.util.List;

public class ResponseAnswer {

	private List<ResponseDomain> domains;

	public List<ResponseDomain> getDomains() {
		return domains;
	}

	public void setDomains(List<ResponseDomain> domains) {
		this.domains = domains;
	}

	@Override
	public String toString() {
		return "ResponseAnswer [domains=" + domains + "]";
	}

}
