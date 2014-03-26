package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 文件存储
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name="file_store_tb")
public class TMFileStore extends IdEntity {
	/** 文件名称	*/
	private String fileName;
	/** 文件url	*/
	private String fileUrl;
	/** 文件类型	*/
	private TMBaseEnum fileType;
	
	@NotBlank
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@NotBlank
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	@NotBlank
	public TMBaseEnum getFileType() {
		return fileType;
	}
	public void setFileType(TMBaseEnum fileType) {
		this.fileType = fileType;
	}
	
	
	
}
