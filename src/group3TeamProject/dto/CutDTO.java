package group3TeamProject.dto;

public class CutDTO {
	//field
	private String scname; // 헤어컷 매장 이름
	private int csno; // 헤어컷 매장 번호
	private int ccode; // 헤어컷 번호 : ccode_seq
	private String ccutname; // 헤어컷 이름
	private int cprice; // 헤어컷 가격
	private String ccontents; //헤어컷 설명

	
	
	//constructor
	public CutDTO() {} // basic constructor
	
	public CutDTO(String scname, int csno, String ccutname, int cprice, String ccontents) {
		super();
		this.scname = scname;
		this.csno = csno;
		this.ccutname = ccutname;
		this.cprice = cprice;
		this.ccontents = ccontents;
	}


	//method
	public String getScname() {
		return scname;
	}
	public int getCsno() {
		return csno;
	}
	public int getCcode() {
		return ccode;
	}
	public String getCcutname() {
		return ccutname;
	}
	public int getCprice() {
		return cprice;
	}
	public String getCcontents() {
		return ccontents;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	public void setCsno(int csno) {
		this.csno = csno;
	}
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
	public void setCcutname(String ccutname) {
		this.ccutname = ccutname;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public void setCcontents(String ccontents) {
		this.ccontents = ccontents;
	}
	
}
