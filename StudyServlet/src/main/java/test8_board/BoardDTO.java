package test8_board;

import java.sql.Date;

// study_jsp3 - board 테이블 레코드 1개 정보 저장하는 BoardDTO 클래스 정의
public class BoardDTO {
	// 1. board 테이블의 각 컬럼에 대응하는 멤버변수 선언
	private int idx;
	private String name;
	private String passwd;
	private String subject;
	private String content;
	private Date date;
	private int readcount;
	
	// 2. 생성자 정의(생략 가능) - 생략 시 기본 생성자 자동 정의
	
	// 3. 각 멤버변수에 접근하기 위한 Getter/Setter 메소드 정의
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
}
