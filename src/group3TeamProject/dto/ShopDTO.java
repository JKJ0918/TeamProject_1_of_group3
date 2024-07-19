package group3TeamProject.dto;

public class ShopDTO {
	//field
	private String sname; // 매장 이름
	private String slocation; // 매장 위치
	private int sno; // 매장 번호
	private String sdesigner; // 매장 소속 디자이너
	private String sopen; // 매장(디자이너)의 출근시간 hhmm(ex. 10시30분 = 1030
	private String sclose; // 매장(디자이너)의 퇴근시간 hhmm(ex. 10시30분 = 1030
	
	//constructor
	public ShopDTO() {} // basic constructor
	
	public ShopDTO(String sname, String slocation, int sno, String sdesigner, String sopen, String sclose) {
		super();
		this.sname = sname;
		this.slocation = slocation;
		this.sno = sno;
		this.sdesigner = sdesigner;
		this.sopen = sopen;
		this.sclose = sclose;
	}// customized constructor



	//method
	public String getSname() {
		return sname;
	}
	public String getSlocation() {
		return slocation;
	}
	public int getSno() {
		return sno;
	}
	public String getSdesigner() {
		return sdesigner;
	}
	public String getSopen() {
		return sopen;
	}
	public String getSclose() {
		return sclose;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setSlocation(String slocation) {
		this.slocation = slocation;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public void setSdesigner(String sdesigner) {
		this.sdesigner = sdesigner;
	}
	public void setSopen(String sopen) {
		this.sopen = sopen;
	}
	public void setSclose(String sclose) {
		this.sclose = sclose;
	}
	
	
}
