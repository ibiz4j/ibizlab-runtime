package cn.ibizlab.core.ou.extensions.service;

import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.mapper.IBZUSERMapper;
import cn.ibizlab.util.service.IBZUSERService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 实体[IBZUSER] 服务对象接口实现
 */
@Service("userservice")
public class IBZUSERServiceImpl extends ServiceImpl<IBZUSERMapper, IBZUSER> implements IBZUSERService{


}