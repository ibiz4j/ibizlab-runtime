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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.api.dto.*;
import cn.ibizlab.api.mapping.*;
import cn.ibizlab.core.ou.domain.IBZOrganization;
import cn.ibizlab.core.ou.service.IIBZOrganizationService;
import cn.ibizlab.core.ou.filter.IBZOrganizationSearchContext;

@Slf4j
@Api(tags = {"单位机构" })
@RestController("api-ibzorganization")
@RequestMapping("")
public class IBZOrganizationResource {

    @Autowired
    public IIBZOrganizationService ibzorganizationService;

    @Autowired
    @Lazy
    public IBZOrganizationMapping ibzorganizationMapping;

    @ApiOperation(value = "检查单位机构", tags = {"单位机构" },  notes = "检查单位机构")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody IBZOrganizationDTO ibzorganizationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzorganizationService.checkKey(ibzorganizationMapping.toDomain(ibzorganizationdto)));
    }

    @PreAuthorize("hasPermission(this.ibzorganizationService.get(#ibzorganization_id),'ibzou-IBZOrganization-Update')")
    @ApiOperation(value = "更新单位机构", tags = {"单位机构" },  notes = "更新单位机构")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}")
    @Transactional
    public ResponseEntity<IBZOrganizationDTO> update(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody IBZOrganizationDTO ibzorganizationdto) {
		IBZOrganization domain  = ibzorganizationMapping.toDomain(ibzorganizationdto);
        domain .setOrgid(ibzorganization_id);
		ibzorganizationService.update(domain );
		IBZOrganizationDTO dto = ibzorganizationMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ibzorganizationService.getIbzorganizationByEntities(this.ibzorganizationMapping.toDomain(#ibzorganizationdtos)),'ibzou-IBZOrganization-Update')")
    @ApiOperation(value = "批量更新单位机构", tags = {"单位机构" },  notes = "批量更新单位机构")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<IBZOrganizationDTO> ibzorganizationdtos) {
        ibzorganizationService.updateBatch(ibzorganizationMapping.toDomain(ibzorganizationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ibzorganizationMapping.toDomain(#ibzorganizationdto),'ibzou-IBZOrganization-Create')")
    @ApiOperation(value = "新建单位机构", tags = {"单位机构" },  notes = "新建单位机构")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations")
    @Transactional
    public ResponseEntity<IBZOrganizationDTO> create(@RequestBody IBZOrganizationDTO ibzorganizationdto) {
        IBZOrganization domain = ibzorganizationMapping.toDomain(ibzorganizationdto);
		ibzorganizationService.create(domain);
        IBZOrganizationDTO dto = ibzorganizationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ibzorganizationMapping.toDomain(#ibzorganizationdtos),'ibzou-IBZOrganization-Create')")
    @ApiOperation(value = "批量新建单位机构", tags = {"单位机构" },  notes = "批量新建单位机构")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<IBZOrganizationDTO> ibzorganizationdtos) {
        ibzorganizationService.createBatch(ibzorganizationMapping.toDomain(ibzorganizationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ibzorganizationMapping.toDomain(#ibzorganizationdto),'ibzou-IBZOrganization-Save')")
    @ApiOperation(value = "保存单位机构", tags = {"单位机构" },  notes = "保存单位机构")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/save")
    public ResponseEntity<Boolean> save(@RequestBody IBZOrganizationDTO ibzorganizationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ibzorganizationService.save(ibzorganizationMapping.toDomain(ibzorganizationdto)));
    }

    @PreAuthorize("hasPermission(this.ibzorganizationMapping.toDomain(#ibzorganizationdtos),'ibzou-IBZOrganization-Save')")
    @ApiOperation(value = "批量保存单位机构", tags = {"单位机构" },  notes = "批量保存单位机构")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<IBZOrganizationDTO> ibzorganizationdtos) {
        ibzorganizationService.saveBatch(ibzorganizationMapping.toDomain(ibzorganizationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ibzorganizationService.get(#ibzorganization_id),'ibzou-IBZOrganization-Remove')")
    @ApiOperation(value = "删除单位机构", tags = {"单位机构" },  notes = "删除单位机构")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ibzorganization_id") String ibzorganization_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ibzorganizationService.remove(ibzorganization_id));
    }

    @PreAuthorize("hasPermission(this.ibzorganizationService.getIbzorganizationByIds(#ids),'ibzou-IBZOrganization-Remove')")
    @ApiOperation(value = "批量删除单位机构", tags = {"单位机构" },  notes = "批量删除单位机构")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ibzorganizationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ibzorganizationMapping.toDomain(returnObject.body),'ibzou-IBZOrganization-Get')")
    @ApiOperation(value = "获取单位机构", tags = {"单位机构" },  notes = "获取单位机构")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}")
    public ResponseEntity<IBZOrganizationDTO> get(@PathVariable("ibzorganization_id") String ibzorganization_id) {
        IBZOrganization domain = ibzorganizationService.get(ibzorganization_id);
        IBZOrganizationDTO dto = ibzorganizationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取单位机构草稿", tags = {"单位机构" },  notes = "获取单位机构草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/getdraft")
    public ResponseEntity<IBZOrganizationDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ibzorganizationMapping.toDto(ibzorganizationService.getDraft(new IBZOrganization())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZOrganization-SelectSOrg-all')")
	@ApiOperation(value = "获取查询下级单位", tags = {"单位机构" } ,notes = "获取查询下级单位")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/fetchselectsorg")
	public ResponseEntity<List<IBZOrganizationDTO>> fetchSelectSOrg(IBZOrganizationSearchContext context) {
        Page<IBZOrganization> domains = ibzorganizationService.searchSelectSOrg(context) ;
        List<IBZOrganizationDTO> list = ibzorganizationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZOrganization-SelectSOrg-all')")
	@ApiOperation(value = "查询查询下级单位", tags = {"单位机构" } ,notes = "查询查询下级单位")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/searchselectsorg")
	public ResponseEntity<Page<IBZOrganizationDTO>> searchSelectSOrg(@RequestBody IBZOrganizationSearchContext context) {
        Page<IBZOrganization> domains = ibzorganizationService.searchSelectSOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzorganizationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZOrganization-SelectPOrg-all')")
	@ApiOperation(value = "获取查询上级单位", tags = {"单位机构" } ,notes = "获取查询上级单位")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/fetchselectporg")
	public ResponseEntity<List<IBZOrganizationDTO>> fetchSelectPOrg(IBZOrganizationSearchContext context) {
        Page<IBZOrganization> domains = ibzorganizationService.searchSelectPOrg(context) ;
        List<IBZOrganizationDTO> list = ibzorganizationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZOrganization-SelectPOrg-all')")
	@ApiOperation(value = "查询查询上级单位", tags = {"单位机构" } ,notes = "查询查询上级单位")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/searchselectporg")
	public ResponseEntity<Page<IBZOrganizationDTO>> searchSelectPOrg(@RequestBody IBZOrganizationSearchContext context) {
        Page<IBZOrganization> domains = ibzorganizationService.searchSelectPOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzorganizationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZOrganization-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"单位机构" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/fetchdefault")
	public ResponseEntity<List<IBZOrganizationDTO>> fetchDefault(IBZOrganizationSearchContext context) {
        Page<IBZOrganization> domains = ibzorganizationService.searchDefault(context) ;
        List<IBZOrganizationDTO> list = ibzorganizationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZOrganization-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"单位机构" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/searchdefault")
	public ResponseEntity<Page<IBZOrganizationDTO>> searchDefault(@RequestBody IBZOrganizationSearchContext context) {
        Page<IBZOrganization> domains = ibzorganizationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzorganizationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

