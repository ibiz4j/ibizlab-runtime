package cn.ibizlab.api.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.api.dto.*;
import cn.ibizlab.api.mapping.*;
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;

@Slf4j
@Api(tags = {"SysPSSystem" })
@RestController("api-syspssystem")
@RequestMapping("")
public class SysPSSystemResource {

    @Autowired
    private ISysPSSystemService syspssystemService;

    @Autowired
    @Lazy
    public SysPSSystemMapping syspssystemMapping;

    public SysPSSystemDTO permissionDTO=new SysPSSystemDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysPSSystem-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SysPSSystem" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/syspssystems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysPSSystemDTO syspssystemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(syspssystemService.checkKey(syspssystemMapping.toDomain(syspssystemdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysPSSystem-Get-all')")
    @ApiOperation(value = "Get", tags = {"SysPSSystem" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/syspssystems/{syspssystem_id}")
    public ResponseEntity<SysPSSystemDTO> get(@PathVariable("syspssystem_id") String syspssystem_id) {
        SysPSSystem domain = syspssystemService.get(syspssystem_id);
        SysPSSystemDTO dto = syspssystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysPSSystem-Create-all')")
    @ApiOperation(value = "Create", tags = {"SysPSSystem" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/syspssystems")
    @Transactional
    public ResponseEntity<SysPSSystemDTO> create(@RequestBody SysPSSystemDTO syspssystemdto) {
        SysPSSystem domain = syspssystemMapping.toDomain(syspssystemdto);
		syspssystemService.create(domain);
        SysPSSystemDTO dto = syspssystemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.syspssystemMapping,#syspssystemdtos})")
    @ApiOperation(value = "createBatch", tags = {"SysPSSystem" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/syspssystems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysPSSystemDTO> syspssystemdtos) {
        syspssystemService.createBatch(syspssystemMapping.toDomain(syspssystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysPSSystem-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SysPSSystem" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/syspssystems/getdraft")
    public ResponseEntity<SysPSSystemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(syspssystemMapping.toDto(syspssystemService.getDraft(new SysPSSystem())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysPSSystem-Remove-all')")
    @ApiOperation(value = "Remove", tags = {"SysPSSystem" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/syspssystems/{syspssystem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("syspssystem_id") String syspssystem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(syspssystemService.remove(syspssystem_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.syspssystemMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SysPSSystem" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/syspssystems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        syspssystemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

//    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysPSSystem-Save-all')")
    @ApiOperation(value = "Save", tags = {"SysPSSystem" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/syspssystems/save")
    public ResponseEntity<Boolean> save(@RequestBody SysPSSystemDTO syspssystemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(syspssystemService.save(syspssystemMapping.toDomain(syspssystemdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.syspssystemMapping,#syspssystemdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SysPSSystem" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/syspssystems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysPSSystemDTO> syspssystemdtos) {
        syspssystemService.saveBatch(syspssystemMapping.toDomain(syspssystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysPSSystem-Update-all')")
    @ApiOperation(value = "Update", tags = {"SysPSSystem" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/syspssystems/{syspssystem_id}")
    @Transactional
    public ResponseEntity<SysPSSystemDTO> update(@PathVariable("syspssystem_id") String syspssystem_id, @RequestBody SysPSSystemDTO syspssystemdto) {
		SysPSSystem domain = syspssystemMapping.toDomain(syspssystemdto);
        domain.setPssystemid(syspssystem_id);
		syspssystemService.update(domain);
		SysPSSystemDTO dto = syspssystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.syspssystemMapping,#syspssystemdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SysPSSystem" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/syspssystems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysPSSystemDTO> syspssystemdtos) {
        syspssystemService.updateBatch(syspssystemMapping.toDomain(syspssystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysPSSystem-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SysPSSystem" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/syspssystems/fetchdefault")
	public ResponseEntity<List<SysPSSystemDTO>> fetchDefault(SysPSSystemSearchContext context) {
        Page<SysPSSystem> domains = syspssystemService.searchDefault(context) ;
        List<SysPSSystemDTO> list = syspssystemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysPSSystem-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SysPSSystem" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/syspssystems/searchdefault")
	public ResponseEntity<Page<SysPSSystemDTO>> searchDefault(@RequestBody SysPSSystemSearchContext context) {
        Page<SysPSSystem> domains = syspssystemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(syspssystemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
