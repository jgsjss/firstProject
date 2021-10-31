package project;



public class Member {
	private String id;
	private String password;
	private String name;
	private String address;
	private String phoneNumber;
	private boolean loginState;
	Member() {}
	//	로그인 확인용 생성자
	Member(String id, String password){
		this.id=id;
		this.password=password;
		}
//	고객정보 저장하는 배열객체 생성자
	Member(String id, String password, String name, String address, String phoneNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public boolean isLoginState() {return loginState;}
	public void setLoginState(boolean loginState) {this.loginState = loginState;}
//	id와 password 둘다 추출
	public String toString() {return "id: " + id +", password: " + password;}
//	회원정보 객체의 id값을 추출하는 메소드
	public String toStringId() {return id;}
//	password만 추출
	public String toStringPassword() {return password;}
	
}
