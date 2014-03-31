package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 文件存储
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "tb_file_store")
public class TMFileStore extends IdEntity {
	/** 文件名称 */
	private String fileName;
	/** 文件url */
	private String fileUrl;
	/** 文件类型 */
	private TMBaseEnum fileType;

//	/**
//	 * 场地
//	 */
//	private TMCourt court;

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

	@NotNull
	@OneToOne
	@JoinColumn(name = "enum_id")
	public TMBaseEnum getFileType() {
		return fileType;
	}

	public void setFileType(TMBaseEnum fileType) {
		this.fileType = fileType;
	}

	
}
