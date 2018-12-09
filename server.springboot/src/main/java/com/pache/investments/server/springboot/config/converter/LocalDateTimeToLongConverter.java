package com.pache.investments.server.springboot.config.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.core.convert.converter.Converter;

public class LocalDateTimeToLongConverter implements Converter<LocalDateTime, Long> {
	@Override
	public Long convert(LocalDateTime localDateTime) {
		return Timestamp.valueOf(localDateTime).getTime();
	}
}
