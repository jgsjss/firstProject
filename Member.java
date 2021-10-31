package project;



public class Member {
	private String id;
	private String password;
	private String name;
	private String address;
	private String phoneNumber;
	private boolean loginState;
	Member() {}
	//	�α��� Ȯ�ο� ������
	Member(String id, String password){
		this.id=id;
		this.password=password;
		}
//	������ �����ϴ� �迭��ü ������
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
//	id�� password �Ѵ� ����
	public String toString() {return "id: " + id +", password: " + password;}
//	ȸ������ ��ü�� id���� �����ϴ� �޼ҵ�
	public String toStringId() {return id;}
//	password�� ����
	public String toStringPassword() {return password;}
	
}
