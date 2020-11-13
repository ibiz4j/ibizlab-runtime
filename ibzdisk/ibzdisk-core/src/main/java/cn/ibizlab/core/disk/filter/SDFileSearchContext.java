package cn.ibizlab.core.disk.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.core.disk.domain.SDFile;
/**
 * 关系型数据实体[SDFile] 查询条件对象
 */
@Slf4j
@Data
public class SDFileSearchContext extends QueryWrapperContext<SDFile> {

	private String n_filename_like;//[名称]
	public void setN_filename_like(String n_filename_like) {
        this.n_filename_like = n_filename_like;
        if(!ObjectUtils.isEmpty(this.n_filename_like)){
            this.getSearchCond().like("filename", n_filename_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
    @Override
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("filename", query)   
            );
		 }
	}
}



