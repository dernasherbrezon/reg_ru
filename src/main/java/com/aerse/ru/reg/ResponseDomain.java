package com.aerse.ru.reg;

public class ResponseDomain {

	private String dname;
	private String result;
	private String service_id;
	private String error_code;
	private String error_text;

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_text() {
		return error_text;
	}

	public void setError_text(String error_text) {
		this.error_text = error_text;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	@Override
	public String toString() {
		return "ResponseDomain [dname=" + dname + ", result=" + result + ", service_id=" + service_id + ", error_code=" + error_code + ", error_text=" + error_text + "]";
	}

}
