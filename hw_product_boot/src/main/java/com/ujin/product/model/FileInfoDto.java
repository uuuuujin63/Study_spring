package com.ujin.product.model;

public class FileInfoDto {
	private int seq;
	// seq : 파일 일련 번호
	private String photo_seq;
	// 
	private String file_name;
	// file_name : 원본 파일명
	private String savefile_name;
	// savefile_name : 저장된 파일명
	private String file_path_org;
	// file_path_org : 파일 경로
	private String file_path_thumb;
	// file_path_thumb : 썸네일 경로
	private int file_size;
	// file_size : 파일 사이즈
	private String stat_view;
	// stat_view : 사용 여부
	private String dt_reg;
	// dt_reg : 등록 일시
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getPhoto_seq() {
		return photo_seq;
	}
	public void setPhoto_seq(String photo_seq) {
		this.photo_seq = photo_seq;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getSavefile_name() {
		return savefile_name;
	}
	public void setSavefile_name(String savefile_name) {
		this.savefile_name = savefile_name;
	}
	public String getFile_path_org() {
		return file_path_org;
	}
	public void setFile_path_org(String file_path_org) {
		this.file_path_org = file_path_org;
	}
	public String getFile_path_thumb() {
		return file_path_thumb;
	}
	public void setFile_path_thumb(String file_path_thumb) {
		this.file_path_thumb = file_path_thumb;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public String getStat_view() {
		return stat_view;
	}
	public void setStat_view(String stat_view) {
		this.stat_view = stat_view;
	}
	public String getDt_reg() {
		return dt_reg;
	}
	public void setDt_reg(String dt_reg) {
		this.dt_reg = dt_reg;
	}
	
}
