package com.my.mysql.response;

public class BaseResponse {

	private String respCode = "9000";
	private String respMsg = "erro";
	
	private Integer totalReco;
	private Integer totalPage;
	private Integer currentPage;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public Integer getTotalReco() {
		return totalReco;
	}
	public void setTotalReco(Integer totalReco) {
		this.totalReco = totalReco;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
