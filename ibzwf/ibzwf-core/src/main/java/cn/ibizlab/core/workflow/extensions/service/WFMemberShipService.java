package cn.ibizlab.core.workflow.extensions.service;

import cn.ibizlab.core.workflow.domain.WFGroup;
import cn.ibizlab.core.workflow.service.IWFGroupService;
import cn.ibizlab.core.workflow.service.IWFMemberService;
import cn.ibizlab.core.workflow.service.IWFUserService;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.security.AuthenticationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class WFMemberShipService
{

	@Autowired
	private IWFGroupService iwfGroupService;

	@Autowired
	private IWFMemberService memberService;

	@Autowired
	private IWFUserService iwfUserService;

	public List<String> getUsersByGroupByPOrg(String groupId, AuthenticationUser user, EntityBase activedata)
	{
		List<String> users=new ArrayList<>();
		WFGroup group=iwfGroupService.get(groupId);
		if(StringUtils.isEmpty(group.getGroupscope()))
			return users;

		return users;
	}

}
