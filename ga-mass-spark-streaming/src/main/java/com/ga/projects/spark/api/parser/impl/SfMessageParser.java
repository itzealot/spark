package com.ga.projects.spark.api.parser.impl;

import java.util.List;

import com.ga.projects.spark.api.MessageParser;
import com.ga.projects.spark.api.Persistent;

public class SfMessageParser implements MessageParser {

	@Override
	public String[] getValues(String[] arrays) {
		return arrays;
	}

	@Override
	public List<String[]> getIds(String[] arrays) {
		return null;
	}

	@Override
	public String[] getCodes(String[] arrays) {
		return null;
	}

	@Override
	public String getServiceCode(String[] arrays) {
		return null;
	}

	@Override
	public String[] getSources(String[] arrays) {
		return null;
	}

	@Override
	public String[] getTimes(String[] arrays) {
		return null;
	}

	@Override
	public Persistent getPersistent() {
		return null;
	}

}
