package cn.ibizlab.core.disk.extensions.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileItem
{
	private String id;
	private String name;
	private String fileid;
	private String filename;
	private long size;
	private String ext;
	private String authcode;

	public FileItem(String id, String name, String fileid, String filename, long size, String ext) {
		this.id = id;
		this.name = name;
		this.fileid = fileid;
		this.filename = filename;
		this.size = size;
		this.ext = ext;
	}
	public FileItem(String id, String name, String fileid, String filename, long size, String ext,String authcode) {
		this.id = id;
		this.name = name;
		this.fileid = fileid;
		this.filename = filename;
		this.size = size;
		this.ext = ext;
		this.authcode = authcode;
	}
}
