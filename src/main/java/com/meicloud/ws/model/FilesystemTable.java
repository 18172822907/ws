package com.meicloud.ws.model;

import java.io.Serializable;

/**
 * 	永洪filesystem_table
 * 
 *  @author Administrator
 *
 */
public class FilesystemTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;
	private String path;
	private String parent;
	private byte[] content;
	private String isFolder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getIsFolder() {
		return isFolder;
	}

	public void setIsFolder(String isFolder) {
		this.isFolder = isFolder;
	}

}
