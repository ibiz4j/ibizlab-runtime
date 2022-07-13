package cn.ibizlab.api.rest.extensions;


import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.core.disk.extensions.service.DiskCoreService;
import cn.ibizlab.core.disk.extensions.service.FileCoreService;
import cn.ibizlab.core.disk.extensions.vo.FileItem;
import cn.ibizlab.core.disk.service.ISDFileService;
import cn.ibizlab.util.errors.BadRequestAlertException;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
public class DiskCoreResource
{

	@Autowired
	private DiskCoreService diskCoreService;

	@Autowired
	private ISDFileService fileService;

	@Autowired
	private FileCoreService fileCoreService;

	private Hashtable<String, String> type = null;
	private String getType(String ext)
	{
		if(type==null)
		{
			type = new Hashtable<String, String>();
			type.put(".pdf", "application/pdf");
			type.put(".jpg", "image/jpg");
			type.put(".jpeg", "image/jpeg");
			type.put(".bmp", "image/bmp");
			type.put(".gif", "image/gif");
			type.put(".tif", "image/tiff");
			type.put(".tiff", "image/tiff");
			type.put(".png", "image/png");
			type.put(".doc","application/msword");
			type.put(".docx","application/msword");
			type.put(".xls","application/vnd.ms-excel");
			type.put(".xlsx","application/vnd.ms-excel");
			type.put(".wps","application/vnd.ms-works");
			type.put(".txt","text/plain");
		}

		String key=ext.toLowerCase();
		key=ext.toLowerCase();
		if(!key.startsWith("."))
			key="."+key;
		if(type.containsKey(key))
			return type.get(key);
		else
			return "application/octet-stream";

	}

	@Value("${ibiz.filePath:/app/file/}")
	private String fileRoot;


	@PostMapping(value = {"net-disk/upload/{folder}/{id}/{name}.{ext}","net-disk/upload/{folder}/{id}","net-disk/upload/{folder}","{folder}/upload/{id}","{folder}/upload"})
	public ResponseEntity<FileItem> updatefile(@PathVariable("folder") String folder, @PathVariable(value = "id",required = false) String id,
											   @PathVariable(value = "name",required = false) String name, @PathVariable(value = "ext",required = false) String ext,
											   @RequestParam(value = "ownertype",required = false) String ownertype, @RequestParam(value = "ownerid",required = false) String ownerid,
											   @RequestParam("file") MultipartFile multipartFile){
		return ResponseEntity.ok().body(diskCoreService.saveFile(folder,id,ownertype,ownerid,multipartFile));
	}



	@GetMapping(value = {"net-disk/download/{folder}/{id}/{name}.{ext}","net-disk/download/{id}","{folder}/download/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public void download(@PathVariable("folder") String folder, @PathVariable("id") String id,
						 @PathVariable(value = "name",required = false) String name, @PathVariable(value = "ext", required = false) String ext,
						 @RequestHeader(value = "authcode",required = false) String authcode,
						 @RequestParam(value = "authcode",required = false) String checkcode,HttpServletRequest request,HttpServletResponse response){
		File file = diskCoreService.getFile(folder,id, StringUtils.isEmpty(authcode)?checkcode:authcode);
		response.setHeader("Content-Disposition", "attachment;filename="+getFileName(request.getHeader("User-Agent"),file.getName()));
		this.sendRespose(response, file);
	}

	@PostMapping(value = "net-disk/download")
	@ResponseStatus(HttpStatus.OK)
	public void download(@RequestBody List<JsonNode> list, HttpServletRequest request, HttpServletResponse response){
		File file= diskCoreService.getFile(null, list);
		response.setHeader("Content-Disposition", "attachment;filename="+getFileName(request.getHeader("User-Agent"),file.getName()));
		this.sendRespose(response, file);
	}

	@GetMapping(value = {"net-disk/openview/{folder}/{id}/{name}.{ext}","net-disk/files/{folder}/{id}/{name}.{ext}"})
	@ResponseStatus(HttpStatus.OK)
	public void open(@PathVariable("folder") String folder, @PathVariable("id") String id,
					 @PathVariable("name") String name, @PathVariable("ext") String ext,
					 @RequestHeader(value = "authcode",required = false) String authcode,
					 @RequestParam(value = "authcode",required = false) String checkcode,HttpServletRequest request,HttpServletResponse response){
		File file = diskCoreService.getFile(folder,id,StringUtils.isEmpty(authcode)?checkcode:authcode);
		String type = getType(DiskCoreService.getExtensionName(file));
		response.setContentType(type);
		if(type.toLowerCase().equals("application/octet-stream"))
			response.setHeader("Content-Disposition", "attachment;filename="+getFileName(request.getHeader("User-Agent"),file.getName()));
		this.sendRespose(response, file);
	}

	@ApiOperation(value = "删除文件", tags = {"文件" },  notes = "删除文件")
	@RequestMapping(method = RequestMethod.DELETE, value = "/net-disk/files/{sdfile_id}")
	public ResponseEntity<Boolean> remove(@PathVariable("sdfile_id") String sdfile_id) {
		return ResponseEntity.status(HttpStatus.OK).body(fileService.remove(sdfile_id));
	}

	@GetMapping(value = "net-disk/files/{folder}")
	public ResponseEntity<List<FileItem>> getFiles(@PathVariable("folder") String folder,@RequestParam("ownertype") String ownertype, @RequestParam("ownerid") String ownerid){
		return ResponseEntity.ok().body(diskCoreService.getFileList(folder,ownertype,ownerid));
	}

	@PostMapping(value = "net-disk/files/{folder}")
	public ResponseEntity<Boolean> saveFiles(@PathVariable("folder") String folder,@RequestParam("ownertype") String ownertype, @RequestParam("ownerid") String ownerid, @RequestBody List<FileItem> fileItems){
		diskCoreService.saveFileList(folder,ownertype,ownerid,fileItems);
		return ResponseEntity.ok().body(true);
	}

	@Value("${ibiz.file.proxy.previewpath:http://172.16.100.243:8012/onlinePreview?url=}")
	private String previewPath;

	@GetMapping(value = "net-disk/preview/{folder}/{id}/{name}.{ext}")
	public ResponseEntity<String> preview(@PathVariable("folder") String folder, @PathVariable("id") String id,
								  @PathVariable("name") String name, @PathVariable("ext") String ext,
								  @RequestHeader(value = "authcode",required = false) String authcode,
								  @RequestParam(value = "authcode",required = false) String checkcode, HttpServletRequest request){
		if(StringUtils.isEmpty(previewPath))
			throw new BadRequestAlertException("未配置预览系统地址","SDFile","");
		authcode=StringUtils.isEmpty(authcode)?checkcode:authcode;
		if ((!folder.toLowerCase().startsWith("ibizutil"))&&(StringUtils.isEmpty(authcode)||(!authcode.equals(fileCoreService.getAuthCode(id)))))
			throw new BadRequestAlertException("没有权限预览","SDFile","");
		String redirectUrl = request.getScheme().concat("://").concat(request.getServerName());
		if(request.getServerPort()!=80&&request.getServerPort()!=443)
			redirectUrl=redirectUrl.concat(":").concat(request.getServerPort()+"");
		redirectUrl=redirectUrl.concat("/net-disk/openview/")
				.concat(folder).concat("/").concat(id).concat("/").concat(name).concat(".").concat(ext).concat("?authcode=").concat(StringUtils.isEmpty(authcode)?checkcode:authcode).concat("&fullfilename=").concat(id).concat(".").concat(ext);
		redirectUrl=previewPath.concat("").concat(encodeURIComponent(redirectUrl));
		return ResponseEntity.status(HttpStatus.OK).body(redirectUrl);
	}

	@Value("${ibiz.file.proxy.ocrpath:http://101.132.236.47:58114/ocr/view?url=}")
	private String ocrPath;

	@GetMapping(value = "net-disk/ocrview/{folder}/{id}/{name}.{ext}")
	public ResponseEntity<String> ocrview(@PathVariable("folder") String folder, @PathVariable("id") String id,
								  @PathVariable("name") String name, @PathVariable("ext") String ext,
								  @RequestHeader(value = "authcode",required = false) String authcode,
								  @RequestParam(value = "authcode",required = false) String checkcode, HttpServletRequest request){
		if(StringUtils.isEmpty(ocrPath))
			throw new BadRequestAlertException("未配置预览系统地址","SDFile","");
		if(!this.checkOcr(ext))
			throw new BadRequestAlertException("不支持识别","SDFile",ext);
		authcode=StringUtils.isEmpty(authcode)?checkcode:authcode;
		if ((!folder.toLowerCase().startsWith("ibizutil"))&&(StringUtils.isEmpty(authcode)||(!authcode.equals(fileCoreService.getAuthCode(id)))))
			throw new BadRequestAlertException("没有权限识别","SDFile","");
		String redirectUrl = request.getScheme().concat("://").concat(request.getServerName());
		if(request.getServerPort()!=80&&request.getServerPort()!=443)
			redirectUrl=redirectUrl.concat(":").concat(request.getServerPort()+"");
		redirectUrl=redirectUrl.concat("/net-disk/openview/")
				.concat(folder).concat("/").concat(id).concat("/").concat(name).concat(".").concat(ext).concat("?authcode=").concat(StringUtils.isEmpty(authcode)?checkcode:authcode);
		redirectUrl=ocrPath.concat("").concat(encodeURIComponent(redirectUrl));
		return ResponseEntity.status(HttpStatus.OK).body(redirectUrl);
	}

	@Value("${ibiz.file.proxy.editpath:http://172.16.180.233:39980/loleaflet/dist/loleaflet.html?file_path=}")
	private String editPath;

	@GetMapping(value = {"net-disk/editview/{folder}/{id}/{name}.{ext}","net-disk/edit/{folder}/{id}/{name}.{ext}"})
	public ResponseEntity<String> editview(@PathVariable("folder") String folder, @PathVariable("id") String id,
								  @PathVariable("name") String name, @PathVariable("ext") String ext,
								  @RequestHeader(value = "authcode",required = false) String authcode,
								  @RequestParam(value = "authcode",required = false) String checkcode, HttpServletRequest request){
		if(StringUtils.isEmpty(editPath))
			throw new BadRequestAlertException("未配置预览系统地址","SDFile","");
		if(!this.checkEdit(ext))
			throw new BadRequestAlertException("不支持编辑","SDFile",ext);
		authcode=StringUtils.isEmpty(authcode)?checkcode:authcode;
		if ((!folder.toLowerCase().startsWith("ibizutil"))&&(StringUtils.isEmpty(authcode)||(!authcode.equals(fileCoreService.getAuthCode(id)))))
			throw new BadRequestAlertException("没有权限编辑","SDFile","");
		String redirectUrl = request.getScheme().concat("://").concat(request.getServerName());
		if(request.getServerPort()!=80&&request.getServerPort()!=443)
			redirectUrl=redirectUrl.concat(":").concat(request.getServerPort()+"");
		redirectUrl=redirectUrl.concat("/net-disk/wopiview/")
				.concat(folder).concat("/").concat(id).concat("/").concat(encodeURIComponent(name)).concat(".").concat(ext);
		redirectUrl=editPath.concat("").concat(redirectUrl);
		return ResponseEntity.status(HttpStatus.OK).body(redirectUrl);
	}

	@GetMapping(value = "net-disk/wopiview/{folder}/{id}/{name}.{ext}")
	public ResponseEntity<JSONObject> getWoAPI(@PathVariable("folder") String folder, @PathVariable("id") String id,
						 @PathVariable(value = "name",required = false) String name, @PathVariable(value = "ext", required = false) String ext){

		SDFile sdFile = fileService.getById(id);
		if(sdFile==null)
			throw new BadRequestAlertException("文件未找到","SDFile",id);

		File file = diskCoreService.getFile(sdFile);
		JSONObject json = new JSONObject();
		// 取得文件名
		json.put("BaseFileName", file.getName());
		json.put("Size", file.length());
		json.put("OwnerId", StringUtils.isEmpty(sdFile.getUpdateman())?"admin":sdFile.getUpdateman());
		json.put("Version", file.lastModified());
		json.put("Sha256", DiskCoreService.getHash256(file));
		json.put("AllowExternalMarketplace", true);
		json.put("UserCanWrite", true);
		json.put("SupportsUpdate", true);
		json.put("SupportsLocks", true);
		return ResponseEntity.ok().body(json);
	}

	@GetMapping(value = "net-disk/wopiview/{folder}/{id}/{name}.{ext}/contents")
	@ResponseStatus(HttpStatus.OK)
	public void getWoAPIContents(@PathVariable("folder") String folder, @PathVariable("id") String id,
								@PathVariable(value = "name",required = false) String name, @PathVariable(value = "ext", required = false) String ext, HttpServletResponse response) {
		File file = diskCoreService.getFile(folder,id, fileCoreService.getAuthCode(id));
		InputStream fis = null;
		OutputStream toClient = null;
		try {
			if (file != null) {
				// 取得文件名
				String filename = file.getName();
				fis = new BufferedInputStream(new FileInputStream(file));
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				// 清空response
				response.reset();
				// 设置response的Header
				response.addHeader("Content-Disposition", "attachment;filename=" +
						getFileName("",filename));
				response.addHeader("Content-Length", "" + file.length());
				toClient = new BufferedOutputStream(response.getOutputStream());
				response.setContentType("application/octet-stream");
				toClient.write(buffer);
				toClient.flush();
			}

		} catch (IOException ex) {
		} finally {
			if (fis != null) {
				try {
					fis.close();
				}
				catch (IOException e) {

				}
			}
			if (toClient != null) {
				try {
					toClient.close();
				}
				catch (IOException e) {

				}
			}
		}
	}

	@PostMapping("net-disk/wopiview/{folder}/{id}/{name}.{ext}/contents")
	@ResponseStatus(HttpStatus.OK)
	public void postWoAPIFile(@PathVariable("folder") String folder, @PathVariable("id") String id,
							  @PathVariable(value = "name",required = false) String name, @PathVariable(value = "ext", required = false) String ext, @RequestBody byte[] content) {

		SDFile sdFile = fileService.getById(id);
		if(sdFile==null)
			throw new BadRequestAlertException("文件未找到","SDFile",id);

		diskCoreService.saveFile(sdFile,content);
	}


	protected void sendRespose(HttpServletResponse response, File file){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		}
		catch (Exception e) {
			//throw e;
		}
		finally {
			if (bis != null) {
				try {
					bis.close();
				}
				catch (IOException e) {

				}
			}
			if (bos != null) {
				try {
					bos.close();
				}
				catch (IOException e) {

				}
			}
		}
	}

	protected String getFileName(String userAgent,String fileName){
		try {
			if(userAgent.contains("MSIE")||userAgent.contains("Trident")) {
				return java.net.URLEncoder.encode(fileName,"UTF-8");
			}else {
				return new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
			}
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	protected String encodeURIComponent(String s) {
		String result = null;

		try {
			result = java.net.URLEncoder.encode(s, "UTF-8")
					.replaceAll("\\+", "%20")
					.replaceAll("\\!", "%21")
					.replaceAll("\\'", "%27")
					.replaceAll("\\(", "%28")
					.replaceAll("\\)", "%29")
					.replaceAll("\\~", "%7E");
		}

		// This exception should never occur.
		catch (UnsupportedEncodingException e) {
			result = s;
		}

		return result;
	}


	protected boolean checkOcr(String ext)
	{
		ext = ext.toLowerCase();
		if(ext.equals("bmp")||ext.equals("gif")||ext.equals("tif")||ext.equals("tiff")||ext.equals("jpg")||ext.equals("jpeg")||ext.equals("png")||ext.equals("pdf"))
			return true;
		return false;
	}

	protected boolean checkEdit(String ext)
	{
		ext = ext.toLowerCase();
		if(ext.equals("wps")||ext.equals("et")||ext.equals("doc")||ext.equals("docx")||ext.equals("xls")||ext.equals("xlsx")||ext.equals("ppt")||ext.equals("pptx")
				||ext.equals("dps")||ext.equals("rtf")||ext.equals("cvs")||ext.equals("txt")||ext.equals("odt"))
			return true;
		return false;
	}

}