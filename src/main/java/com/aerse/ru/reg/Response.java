package com.aerse.ru.reg;

public class Response {

	private String result;
	private String error_code;
	private ResponseAnswer answer;
	
	public Response() {
		//do nothing
	}
	
	public Response(String result) {
		this.result = result;
	}
	
	public String getError_code() {
		return error_code;
	}
	
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ResponseAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(ResponseAnswer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Response [result=" + result + ", answer=" + answer + "]";
	}

}
