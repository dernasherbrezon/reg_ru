package com.aerse.ru.reg;

public class RemoveRecordInputData extends AbstractInputData {

	/**
	 * поддомен для которого будет удаляться запись, обязательное поле
	 */
	private String subdomain;
	/**
	 * класс, тип удаляемой записи, обязательное поле
	 */
	private RecordType record_type;
	/**
	 * приоритет записи, опциональное поле, значение по умолчанию 0. Неприменимо к запросу удаления А-записи (и аналогичных записей)
	 */
	private Integer priority;
	/**
	 * содержимое записи, опциональное поле, при его отсутствии помечаются к удалению все записи, попадающие под условие остальных параметров
	 */
	private String content;

	public String getSubdomain() {
		return subdomain;
	}

	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}

	public RecordType getRecord_type() {
		return record_type;
	}

	public void setRecord_type(RecordType record_type) {
		this.record_type = record_type;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
