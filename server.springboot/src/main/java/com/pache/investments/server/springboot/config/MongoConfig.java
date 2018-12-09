package com.pache.investments.server.springboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.pache.investments.server.springboot.config.converter.LocalDateTimeToLongConverter;
import com.pache.investments.server.springboot.config.converter.LongToLocalDateTimeConverter;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new LocalDateTimeToLongConverter());
        converterList.add(new LongToLocalDateTimeConverter());
        return new MongoCustomConversions(converterList);
    }

}
