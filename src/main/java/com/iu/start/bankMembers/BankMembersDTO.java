package com.iu.start.bankMembers;

import java.util.List;

import com.iu.start.bankAccount.BankAccountDTO;

public class BankMembersDTO {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String lv;
	private List<BankAccountDTO> bankAccountDTOs;
	private BankMembersFileDTO bankMembersFileDTO;
	private List<RoleDTO> roleDTOs;
	

	public List<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}
	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}
	public BankMembersFileDTO getBankMembersFileDTO() {
		return bankMembersFileDTO;
	}
	public void setBankMembersFileDTO(BankMembersFileDTO bankMembersFileDTO) {
		this.bankMembersFileDTO = bankMembersFileDTO;
	}
	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	

}
