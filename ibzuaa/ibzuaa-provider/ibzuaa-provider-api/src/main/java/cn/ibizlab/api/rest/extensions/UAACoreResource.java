package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.api.dto.SysPSSystemDTO;
import cn.ibizlab.api.dto.SysRolePermissionDTO;
import cn.ibizlab.api.mapping.SysPSSystemMapping;
import cn.ibizlab.api.mapping.SysRolePermissionMapping;
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.extensions.domain.PermissionNode;
import cn.ibizlab.core.uaa.extensions.domain.SysStructure;
import cn.ibizlab.core.uaa.extensions.service.UAACoreService;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.core.uaa.service.ISysRolePermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@RestController
public class UAACoreResource {

    @Autowired
    private UAACoreService uaaCoreService;

    @Autowired
    private ISysPSSystemService sysPSSystemService;

    @Autowired
    private ISysRolePermissionService sysRolePermissionService;


    @Autowired
    @Lazy
    public SysPSSystemMapping syspssystemMapping;

    @Autowired
    @Lazy
    public SysRolePermissionMapping sysrolepermissionMapping;

    /**
     * 获取全部菜单列表和数据能力列表和统一资源列表
     *
     * @return
     */
    @GetMapping(value = "/sysroles/{roleid}/sysrolepermissions/tree")
    public ResponseEntity<Map<String, List<PermissionNode>>> getTree(@Validated @NotBlank(message = "roleid不允许为空")@PathVariable("roleid") String roleid) {
        Map<String,List<PermissionNode>> map = uaaCoreService.getPermissionTree();
        map.put("SELECTED",uaaCoreService.getRolePermissionByRoleId(roleid));
        return ResponseEntity.ok().body(map);
    }

    @ApiOperation(value = "Save", tags = {"SysPSSystem" },  notes = "Save")
    @RequestMapping(method = RequestMethod.POST, value = "/syspssystems/{systemid}/permissiondata")
    public ResponseEntity<Boolean> pushSystemPermissionData(@PathVariable("systemid") String systemid,@RequestBody SysStructure sysStructure) {
        SysPSSystem sysPSSystem = new SysPSSystem();
        sysPSSystem.setPssystemid(systemid);
        sysPSSystem.setPssystemname(systemid);
        sysPSSystem.setSysstructure(sysStructure);
        return ResponseEntity.status(HttpStatus.OK).body(sysPSSystemService.save(sysPSSystem));
    }


    @ApiOperation(value = "RefreshBatchBySysRole", tags = {"SysRolePermission" },  notes = "RefreshBatchBySysRole")
    @RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysrolepermissions/refreshbatch")
    public ResponseEntity<Boolean> saveBatchBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        List<SysRolePermission> domainlist=sysrolepermissionMapping.toDomain(sysrolepermissiondtos);
        uaaCoreService.saveByRoleid(sysrole_id,domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
