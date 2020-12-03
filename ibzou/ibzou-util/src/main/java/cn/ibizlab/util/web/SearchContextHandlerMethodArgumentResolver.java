package cn.ibizlab.util.web;

import cn.ibizlab.util.filter.SearchContextBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SearchContextHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Value("${ibiz.pageLimit:1000}")
	private int pageLimit=1000;

    private static ObjectMapper objectMapper=new ObjectMapper();

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return SearchContextBase.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
								  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		Map<String, String[]> params = webRequest.getParameterMap();
		LinkedHashMap<String,Object> set = new LinkedHashMap<>();
		for (String key : params.keySet()) {
			set.put(key,params.get(key)[0]);
		}
		if((!set.containsKey("size")) ){
			set.put("size", pageLimit);
		}
		String json = objectMapper.writeValueAsString(set);
		return objectMapper.readValue(json, parameter.getParameterType());
	}
}