package cn.ibizlab.util.cache.redis;

import cn.ibizlab.util.security.AuthenticationUser;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomJacksonSerializer<T> extends Jackson2JsonRedisSerializer<T>  {

    public static final String DEFAULT_PACKAGE ="[\\w+\\.]+\\.AuthenticationUser";

    public static final String USER_PACKAGE= AuthenticationUser.class.getName();

    public CustomJacksonSerializer(Class type) {
        super(type);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        String serializerContent = new String(bytes, DEFAULT_CHARSET);
        Matcher matcher = Pattern.compile(DEFAULT_PACKAGE).matcher(serializerContent);
        return matcher.find()?super.deserialize(serializerContent.replaceAll(DEFAULT_PACKAGE,USER_PACKAGE).getBytes()):super.deserialize(bytes);
    }
}
