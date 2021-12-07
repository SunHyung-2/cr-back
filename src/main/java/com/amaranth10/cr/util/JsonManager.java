package com.amaranth10.cr.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonManager extends ObjectMapper {
	public JsonManager() {
		super.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		super.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
}
