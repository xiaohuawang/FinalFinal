package com.bean;

import java.util.Date;

public class SampleBean {
	private Integer sampleId;
	private String sampleName;
	private Date sampleDate;

	public Date getSampleDate() {
		return sampleDate;
	}

	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}

	public Integer getSampleId() {
		return sampleId;
	}

	public void setSampleId(Integer sampleId) {
		this.sampleId = sampleId;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	
	@Override
	public String toString() {
		return new String("SampleId: " + sampleId + ", " + sampleName);
	}
}
