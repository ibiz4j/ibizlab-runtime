package cn.ibizlab.api.rest.extensions;


import cn.ibizlab.core.disk.extensions.service.DiskCoreService;
import cn.ibizlab.util.domain.FileItem;
import cn.ibizlab.util.errors.BadRequestAlertException;
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
import java.util.Hashtable;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
public class DiskCoreResource
{

	@Autowired
	private DiskCoreService diskCoreService;

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

		if(type.containsKey(ext.toLowerCase()))
			return type.get(ext.toLowerCase());
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



	@GetMapping(value = {"net-disk/download/{folder}/{id}/{name}.{ext}","{folder}/download/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public void download(@PathVariable("folder") String folder, @PathVariable("id") String id,
						 @PathVariable(value = "name",required = false) String name, @PathVariable(value = "ext", required = false) String ext,
						 @RequestHeader(value = "authcode",required = false) String authcode,
						 @RequestParam(value = "authcode",required = false) String checkcode,HttpServletResponse response){
		File file = diskCoreService.getFile(folder,id, StringUtils.isEmpty(authcode)?checkcode:authcode);
		response.setHeader("Content-Disposition", "attachment;filename="+getFileName(file.getName()));
		this.sendRespose(response, file);
	}

	@GetMapping(value = "net-disk/files/{folder}/{id}/{name}.{ext}")
	@ResponseStatus(HttpStatus.OK)
	public void open(@PathVariable("folder") String folder, @PathVariable("id") String id,
					 @PathVariable("name") String name, @PathVariable("ext") String ext,
					 @RequestHeader(value = "authcode",required = false) String authcode,
					 @RequestParam(value = "authcode",required = false) String checkcode,HttpServletResponse response){
		File file = diskCoreService.getFile(folder,id,StringUtils.isEmpty(authcode)?checkcode:authcode);
		String type = getType(ext);
		response.setContentType(type);
		if(type.toLowerCase().equals("application/octet-stream"))
			response.setHeader("Content-Disposition", "attachment;filename="+getFileName(file.getName()));
		this.sendRespose(response, file);
	}

	@Value("ibiz.file.proxy.previewpath")
	private String previewPath;

	@GetMapping(value = "net-disk/preview/{folder}/{id}/{name}.{ext}")
	public ResponseEntity preview(@PathVariable("folder") String folder, @PathVariable("id") String id,
								  @PathVariable("name") String name, @PathVariable("ext") String ext,
								  @RequestHeader(value = "authcode",required = false) String authcode,
								  @RequestParam(value = "authcode",required = false) String checkcode, HttpServletRequest request){
		if(StringUtils.isEmpty(previewPath))
			throw new BadRequestAlertException("未配置预览系统地址","SDFile","");
		String redirectUrl = request.getScheme().concat("://").concat(request.getServerName());
		if(request.getServerPort()!=80&&request.getServerPort()!=443)
			redirectUrl=redirectUrl.concat(":").concat(request.getServerPort()+"");
		redirectUrl=redirectUrl.concat("/net-disk/download/")
				.concat(folder).concat("/").concat(folder).concat("/").concat(name).concat(".").concat(ext).concat("?authcode=").concat(StringUtils.isEmpty(authcode)?checkcode:authcode);
		redirectUrl=previewPath.concat("?url=").concat(encodeURIComponent(redirectUrl));
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, redirectUrl).build();
	}

	@Value("ibiz.file.proxy.ocrpath")
	private String ocrPath;

	@GetMapping(value = "net-disk/ocrview/{folder}/{id}/{name}.{ext}")
	public ResponseEntity ocrview(@PathVariable("folder") String folder, @PathVariable("id") String id,
								  @PathVariable("name") String name, @PathVariable("ext") String ext,
								  @RequestHeader(value = "authcode",required = false) String authcode,
								  @RequestParam(value = "authcode",required = false) String checkcode, HttpServletRequest request){
		if(StringUtils.isEmpty(previewPath))
			throw new BadRequestAlertException("未配置预览系统地址","SDFile","");
		String redirectUrl = request.getScheme().concat("://").concat(request.getServerName());
		if(request.getServerPort()!=80&&request.getServerPort()!=443)
			redirectUrl=redirectUrl.concat(":").concat(request.getServerPort()+"");
		redirectUrl=redirectUrl.concat("/net-disk/download/")
				.concat(folder).concat("/").concat(folder).concat("/").concat(name).concat(".").concat(ext).concat("?authcode=").concat(StringUtils.isEmpty(authcode)?checkcode:authcode);
		redirectUrl=ocrPath.concat("?url=").concat(encodeURIComponent(redirectUrl));
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, redirectUrl).build();
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

	protected String getFileName(String fileName){
		try {
			return new String(fileName.getBytes("utf-8"),"iso8859-1");//防止中文乱码
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
}