package com.hz.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hz.hzsf.common.utils.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname WebConfig
 * @Description TODO
 * @Date 2020-01-07 20:06
 * @Created by hzong
 */
@Configuration
public class WebConfig /*implements WebMvcConfigurer*/ {

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat( new SimpleDateFormat(DateUtils.YYYY_MM_DD_HH_MM_SS));
        return mapper;
    }

   /* //使用阿里 FastJson 作为JSON MessageConverter
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);//保留空的字段
        //SerializerFeature.WriteNullStringAsEmpty,//String null -> ""
        //SerializerFeature.WriteNullNumberAsZero//Number null -> 0
        // 按需配置，更多参考FastJson文档哈

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8_VALUE));
        converters.add(converter);
    }*/
}
