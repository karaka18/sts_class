package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.List;

public class MemberVO {
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;

	private String enabled;
	private Timestamp regdate;
	private Timestamp updatedate;

	// join을 통해서 생성될 정보를 저장
	private List<AuthVO> authList;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	public List<AuthVO> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AuthVO> authList) {
		this.authList = authList;
	}
	
	
	
}
