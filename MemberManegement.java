package project;

public interface MemberManegement {
	public String WRONG_KEY = "�߸� �Է��ϼ̽��ϴ�! �ٽ� �õ��ϼ���!";
	public String START_DUPLICATED = "ID �ߺ��˻縦 �����մϴ�.";
	public String INSERT_PHONENUMBER = "����ó�� �Է��ϼ���.>>";
	public String INSERT_ID = "ID�� �Է��ϼ���. >>";
	public String ENTER_PASSWORD = "��й�ȣ�� �Է��ϼ���. >>";
	public String INSERT_NAME = "������ �Է��ϼ���.>>";
	public String INSERT_ADDRESS = "�ּҸ� �Է��ϼ���.>>";
	public String JOINMEMBERSHIP_COMPLETE = " ���� ȸ�������� �Ϸ�Ǿ����ϴ�.";
	public String WRONG_ID = "ID�� Ʋ���ų� �������� �ʽ��ϴ�.";
	public String WRONG_PASSWORD = "password�� Ʋ���ϴ�.";
	public String WRONG_ID_PASSWORD= "ID�� ��й�ȣ�� Ʋ���ϴ�.";
	public String TRY_AGAIN = "�ٽ� �Է��ϼ���";
	public String EDIT_MEMBERSHIP = " ���� ȸ�������� �����Ǿ����ϴ�.";
	public String USED_ID = "�̹� ������� ID�Դϴ�.";
	public String POSSIBLE_ID = "��� ������ ID�Դϴ�.";
	public String NOT_EXIST_MEMBERSHIP = "��ġ�ϴ� ȸ�������� �����ϴ�.";
	public String RETURN_FIRST_PAGE = "ó�� ȭ������ ���ư��ϴ�.";
	
//	ȸ������ �޼ҵ�
	public void createMemberShip();
//	�α��� �޼ҵ�
	public void login();
//	ȸ��Ż�� �޼ҵ�
	public void withdrawl();
//	ȸ������ ���� �޼ҵ�
	public void editMembership();
	public void checkMembership();
//	ID�ߺ�Ȯ�� �޼ҵ�
	public void checkDuplicatedId();

	
}
