package com.crif.contact.integrations.s1.event;

import java.util.List;

public class RMQMessage {
	private List<String> s1LoadId;
	private String s1RequestId;

	public List<String> getS1LoadId() {
		return s1LoadId;
	}

	public void setS1LoadId(List<String> s1LoadId) {
		this.s1LoadId = s1LoadId;
	}

	public String getS1RequestId() {
		return s1RequestId;
	}

	public void setS1RequestId(String s1RequestId) {
		this.s1RequestId = s1RequestId;
	}

	@Override
	public String toString() {
		return "RMQMessage [s1LoadId=" + s1LoadId + ", s1RequestId=" + s1RequestId + "]";
	}

}
