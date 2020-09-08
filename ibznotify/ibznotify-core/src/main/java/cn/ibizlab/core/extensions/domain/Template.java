package cn.ibizlab.core.extensions.domain;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class Template {

    @NotNull(message="模板不能为空")
    private JSONArray template;
}
