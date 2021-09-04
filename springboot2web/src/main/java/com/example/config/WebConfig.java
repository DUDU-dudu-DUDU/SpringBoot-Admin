package com.example.config;

import com.example.converter.DiyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebConfig {

    // WebMvcConfigurer 定制化SpringMvc的功能
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                //
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("json", MediaType.APPLICATION_JSON);
                mediaTypes.put("xml", MediaType.APPLICATION_XML);
                mediaTypes.put("wu", MediaType.parseMediaType("application/x-wu"));
                // 指定支持解析那些参数对应的那些媒体类型
                // 策略管理器 管理支持那些策略
                ParameterContentNegotiationStrategy parameter = new ParameterContentNegotiationStrategy(mediaTypes);

                HeaderContentNegotiationStrategy header = new HeaderContentNegotiationStrategy();
                // 设置内容协商策略
                configurer.strategies(Arrays.asList(parameter, header));
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new DiyMessageConverter());
            }
        };
    }
}
