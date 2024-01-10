package com.crif.contact.integrations.s1.event;

import java.io.Serializable;

public class PipelinedCOS1Event implements Serializable{

	private Long s1LoadId;
	private String s1LoadRequestId;

	public PipelinedCOS1Event(Long s1LoadId, String s1LoadRequestId) {
		this.s1LoadId = s1LoadId;
		this.s1LoadRequestId = s1LoadRequestId;
	}

	// default constructor for rabbit listener
	public PipelinedCOS1Event() {
	}

	public Long getS1LoadId() {
		return s1LoadId;
	}

	public String getS1LoadRequestId() {
		return s1LoadRequestId;
	}

	public void setS1LoadId(Long s1LoadId) {
		this.s1LoadId = s1LoadId;
	}

	public void setS1LoadRequestId(String s1LoadRequestId) {
		this.s1LoadRequestId = s1LoadRequestId;
	}

	@Override
	public String toString() {
		return "PipelinedCOS1Event [s1LoadId=" + s1LoadId + ", s1LoadRequestId=" + s1LoadRequestId + "]";
	}

}
