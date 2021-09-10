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
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.api.dto.*;
import cn.ibizlab.api.mapping.*;
import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.core.disk.service.ISDFileService;
import cn.ibizlab.core.disk.filter.SDFileSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"文件" })
@RestController("api-sdfile")
@RequestMapping("")
public class SDFileResource {

    @Autowired
    public ISDFileService sdfileService;

    @Autowired
    @Lazy
    public SDFileMapping sdfileMapping;

    @PreAuthorize("hasPermission(this.sdfileMapping.toDomain(#sdfiledto),'ibzdisk-SDFile-Create')")
    @ApiOperation(value = "新建文件", tags = {"文件" },  notes = "新建文件")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles")
    public ResponseEntity<SDFileDTO> create(@Validated @RequestBody SDFileDTO sdfiledto) {
        SDFile domain = sdfileMapping.toDomain(sdfiledto);
		sdfileService.create(domain);
        SDFileDTO dto = sdfileMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sdfileMapping.toDomain(#sdfiledtos),'ibzdisk-SDFile-Create')")
    @ApiOperation(value = "批量新建文件", tags = {"文件" },  notes = "批量新建文件")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SDFileDTO> sdfiledtos) {
        sdfileService.createBatch(sdfileMapping.toDomain(sdfiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.sdfileMapping.toDomain(returnObject.body),'ibzdisk-SDFile-Get')")
    @ApiOperation(value = "获取文件", tags = {"文件" },  notes = "获取文件")
	@RequestMapping(method = RequestMethod.GET, value = "/sdfiles/{sdfile_id}")
    public ResponseEntity<SDFileDTO> get(@PathVariable("sdfile_id") String sdfile_id) {
        SDFile domain = sdfileService.get(sdfile_id);
        SDFileDTO dto = sdfileMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sdfileService.get(#sdfile_id),'ibzdisk-SDFile-Remove')")
    @ApiOperation(value = "删除文件", tags = {"文件" },  notes = "删除文件")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sdfiles/{sdfile_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("sdfile_id") String sdfile_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sdfileService.remove(sdfile_id));
    }

    @PreAuthorize("hasPermission(this.sdfileService.getSdfileByIds(#ids),'ibzdisk-SDFile-Remove')")
    @ApiOperation(value = "批量删除文件", tags = {"文件" },  notes = "批量删除文件")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sdfiles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sdfileService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sdfile" , versionfield = "updatedate")
    @PreAuthorize("hasPermission(this.sdfileService.get(#sdfile_id),'ibzdisk-SDFile-Update')")
    @ApiOperation(value = "更新文件", tags = {"文件" },  notes = "更新文件")
	@RequestMapping(method = RequestMethod.PUT, value = "/sdfiles/{sdfile_id}")
    public ResponseEntity<SDFileDTO> update(@PathVariable("sdfile_id") String sdfile_id, @RequestBody SDFileDTO sdfiledto) {
		SDFile domain  = sdfileMapping.toDomain(sdfiledto);
        domain .setId(sdfile_id);
		sdfileService.update(domain );
		SDFileDTO dto = sdfileMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sdfileService.getSdfileByEntities(this.sdfileMapping.toDomain(#sdfiledtos)),'ibzdisk-SDFile-Update')")
    @ApiOperation(value = "批量更新文件", tags = {"文件" },  notes = "批量更新文件")
	@RequestMapping(method = RequestMethod.PUT, value = "/sdfiles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SDFileDTO> sdfiledtos) {
        sdfileService.updateBatch(sdfileMapping.toDomain(sdfiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查文件", tags = {"文件" },  notes = "检查文件")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SDFileDTO sdfiledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sdfileService.checkKey(sdfileMapping.toDomain(sdfiledto)));
    }

    @ApiOperation(value = "获取文件草稿", tags = {"文件" },  notes = "获取文件草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sdfiles/getdraft")
    public ResponseEntity<SDFileDTO> getDraft(SDFileDTO dto) {
        SDFile domain = sdfileMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(sdfileMapping.toDto(sdfileService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.sdfileMapping.toDomain(#sdfiledto),'ibzdisk-SDFile-Save')")
    @ApiOperation(value = "保存文件", tags = {"文件" },  notes = "保存文件")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles/save")
    public ResponseEntity<SDFileDTO> save(@RequestBody SDFileDTO sdfiledto) {
        SDFile domain = sdfileMapping.toDomain(sdfiledto);
        sdfileService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sdfileMapping.toDto(domain));
    }

    @PreAuthorize("hasPermission(this.sdfileMapping.toDomain(#sdfiledtos),'ibzdisk-SDFile-Save')")
    @ApiOperation(value = "批量保存文件", tags = {"文件" },  notes = "批量保存文件")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SDFileDTO> sdfiledtos) {
        sdfileService.saveBatch(sdfileMapping.toDomain(sdfiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdisk-SDFile-searchDefault-all') and hasPermission(#context,'ibzdisk-SDFile-Get')")
	@ApiOperation(value = "获取DEFAULT", tags = {"文件" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sdfiles/fetchdefault")
	public ResponseEntity<List<SDFileDTO>> fetchDefault(SDFileSearchContext context) {
        Page<SDFile> domains = sdfileService.searchDefault(context) ;
        List<SDFileDTO> list = sdfileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdisk-SDFile-searchDefault-all') and hasPermission(#context,'ibzdisk-SDFile-Get')")
	@ApiOperation(value = "查询DEFAULT", tags = {"文件" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sdfiles/searchdefault")
	public ResponseEntity<Page<SDFileDTO>> searchDefault(@RequestBody SDFileSearchContext context) {
        Page<SDFile> domains = sdfileService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sdfileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

