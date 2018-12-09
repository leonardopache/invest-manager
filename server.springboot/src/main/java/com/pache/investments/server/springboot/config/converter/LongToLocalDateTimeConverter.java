package com.pache.investments.server.springboot.config.converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import org.springframework.core.convert.converter.Converter;

public class LongToLocalDateTimeConverter implements Converter<Long, LocalDateTime> {
	@Override
	public LocalDateTime convert(Long localDateTime) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(localDateTime), 
                TimeZone.getDefault().toZoneId());

	}
}
