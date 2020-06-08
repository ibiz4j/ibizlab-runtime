package cn.ibizlab.core.uaa.domain.handlers;

import cn.ibizlab.core.uaa.domain.SysApp;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@MappedTypes({List.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class SysAppTypeHandler extends AbstractJsonTypeHandler<List>
{
    private static ObjectMapper objectMapper = new ObjectMapper();
    private JavaType type;

    public SysAppTypeHandler(Class<List> type) {
        this.type = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, SysApp.class);
    }

    @Override
    protected List parse(String json) {
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String toJson(List obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setObjectMapper(ObjectMapper objectMapper) {
        SysAppTypeHandler.objectMapper = objectMapper;
    }
}



