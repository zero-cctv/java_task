/*
 * Copyright Huayu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.huayu.springboot.framework.config.json.fastjson;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 如需使用FastJson 作为MVC json序列化器， 则在类上标注 @Configuration
 * FastJson 和 Jackson 同时只能存在一个
 *
 * @author weiqian
 * @date 2018-11-08
 */
public class FastJsonMvcConfig implements WebMvcConfigurer {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        mediaTypes.add(MediaType.TEXT_HTML);
        mediaTypes.add(new MediaType("application", "xml"));
        mediaTypes.add(new MediaType("text", "xml"));
        mediaTypes.add(new MediaType("application", "*+xml"));
        mediaTypes.add(MediaType.ALL);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName(DEFAULT_CHARSET));
        fastJsonConfig.setDateFormat(DEFAULT_DATE_FORMAT);
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                // 格式化
                SerializerFeature.PrettyFormat,
                // 输出空值
                SerializerFeature.WriteMapNullValue,
                // 空集合输出[]
                SerializerFeature.WriteNullListAsEmpty,
                // 日期格式化
                SerializerFeature.WriteDateUseDateFormat
        };
        fastJsonConfig.setSerializerFeatures(serializerFeatures);


        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        fastJsonConfig.setSerializeConfig(serializeConfig);

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        converters.add(0, fastJsonHttpMessageConverter);

    }
}
