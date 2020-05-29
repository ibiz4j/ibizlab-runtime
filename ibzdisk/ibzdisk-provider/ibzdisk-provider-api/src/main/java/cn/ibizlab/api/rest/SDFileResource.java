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
import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.core.disk.service.ISDFileService;
import cn.ibizlab.core.disk.filter.SDFileSearchContext;

@Slf4j
@Api(tags = {"SDFile" })
@RestController("api-sdfile")
@RequestMapping("")
public class SDFileResource {

    @Autowired
    public ISDFileService sdfileService;

    @Autowired
    @Lazy
    public SDFileMapping sdfileMapping;

    @PreAuthorize("hasPermission(this.sdfileService.get(#sdfile_id),'ibzdisk-SDFile-Update')")
    @ApiOperation(value = "Update", tags = {"SDFile" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/sdfiles/{sdfile_id}")
    @Transactional
    public ResponseEntity<SDFileDTO> update(@PathVariable("sdfile_id") String sdfile_id, @RequestBody SDFileDTO sdfiledto) {
		SDFile domain  = sdfileMapping.toDomain(sdfiledto);
        domain .setId(sdfile_id);
		sdfileService.update(domain );
		SDFileDTO dto = sdfileMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sdfileService.getSdfileByEntities(this.sdfileMapping.toDomain(#sdfiledtos)),'ibzdisk-SDFile-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SDFile" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/sdfiles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SDFileDTO> sdfiledtos) {
        sdfileService.updateBatch(sdfileMapping.toDomain(sdfiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.sdfileMapping.toDomain(#sdfiledto),'ibzdisk-SDFile-Create')")
    @ApiOperation(value = "Create", tags = {"SDFile" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles")
    @Transactional
    public ResponseEntity<SDFileDTO> create(@RequestBody SDFileDTO sdfiledto) {
        SDFile domain = sdfileMapping.toDomain(sdfiledto);
		sdfileService.create(domain);
        SDFileDTO dto = sdfileMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sdfileMapping.toDomain(#sdfiledtos),'ibzdisk-SDFile-Create')")
    @ApiOperation(value = "createBatch", tags = {"SDFile" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SDFileDTO> sdfiledtos) {
        sdfileService.createBatch(sdfileMapping.toDomain(sdfiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SDFile" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SDFileDTO sdfiledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sdfileService.checkKey(sdfileMapping.toDomain(sdfiledto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"SDFile" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/sdfiles/getdraft")
    public ResponseEntity<SDFileDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sdfileMapping.toDto(sdfileService.getDraft(new SDFile())));
    }

    @PostAuthorize("hasPermission(this.sdfileMapping.toDomain(returnObject.body),'ibzdisk-SDFile-Get')")
    @ApiOperation(value = "Get", tags = {"SDFile" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/sdfiles/{sdfile_id}")
    public ResponseEntity<SDFileDTO> get(@PathVariable("sdfile_id") String sdfile_id) {
        SDFile domain = sdfileService.get(sdfile_id);
        SDFileDTO dto = sdfileMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sdfileService.get(#sdfile_id),'ibzdisk-SDFile-Remove')")
    @ApiOperation(value = "Remove", tags = {"SDFile" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sdfiles/{sdfile_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("sdfile_id") String sdfile_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sdfileService.remove(sdfile_id));
    }

    @PreAuthorize("hasPermission(this.sdfileService.getSdfileByIds(#ids),'ibzdisk-SDFile-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SDFile" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sdfiles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sdfileService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.sdfileMapping.toDomain(#sdfiledto),'ibzdisk-SDFile-Save')")
    @ApiOperation(value = "Save", tags = {"SDFile" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles/save")
    public ResponseEntity<Boolean> save(@RequestBody SDFileDTO sdfiledto) {
        return ResponseEntity.status(HttpStatus.OK).body(sdfileService.save(sdfileMapping.toDomain(sdfiledto)));
    }

    @PreAuthorize("hasPermission(this.sdfileMapping.toDomain(#sdfiledtos),'ibzdisk-SDFile-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SDFile" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sdfiles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SDFileDTO> sdfiledtos) {
        sdfileService.saveBatch(sdfileMapping.toDomain(sdfiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdisk-SDFile-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SDFile" } ,notes = "fetchDEFAULT")
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

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdisk-SDFile-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SDFile" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sdfiles/searchdefault")
	public ResponseEntity<Page<SDFileDTO>> searchDefault(@RequestBody SDFileSearchContext context) {
        Page<SDFile> domains = sdfileService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sdfileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

