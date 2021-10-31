package project;

import java.util.Scanner;


public class JoinMembershipAndLogin implements MemberManegement{
	String id;
	String password;
	String name;
	String address;
	String phoneNumber;
	String loginId;
	boolean logState = false;
	Member editorMember = new Member();
	private Scanner sc = new Scanner(System.in);
	private Member[] member = new Member[100];
//	ȸ������ �� �α���, ����, Ż��, ���� ���� �ϴ� �޼ҵ�
	public boolean membershipAndLogin() {
		System.out.println("***********SHOES MARKET***********");
			try {
				while (true) {
					if(logState) {
						System.out.println(loginId + "���� ��ſ� ���� �ǽñ� �ٶ��ϴ�.");
						break;
					}
					System.out.println("=================================================");
					System.out.println("1.ȸ������|2.�α��� �ϱ�|3.ȸ������ ����|4.ȸ�� Ż��|5.����");
					System.out.println("=================================================");
					System.out.println("�޴��� �����ϼ���(1 ~ 5).>>");
					int menuSelect = sc.nextInt();
					if (menuSelect < 0 && menuSelect > 5)
						continue;
					switch (menuSelect) {
					case 1:
						createMemberShip();
						break;
					case 2:
						login();
						break;
					case 3:
						editMembership();
						break;
					case 4:
						withdrawl();
						break;
					case 5:
						System.out.println("���� ����.");
						System.exit(0);
					}
				}
			}catch (Exception e) {System.out.println(WRONG_KEY);}
			return logState;
	}
//	ȸ������ �޼ҵ�
	@Override
	public void createMemberShip() {
		boolean inputState = false;
		String i_password = null;
		String i_name = null;
		String i_address = null;
		String i_phoneNumber = null;
		System.out.println("***ȸ�� ����***");
		System.out.println("���Է��� ���Ͻø� \"�ٽ�\" �� �Է��ϼ���. ");
//		�ߺ�üũ �޼ҵ� ȣ��
		checkDuplicatedId();
		System.out.println(ENTER_PASSWORD);
		password = sc.next();
		i_password = password;
		if (inputState = inputReset(i_password)) {
			createMemberShip();
			return;
		}
		System.out.println(INSERT_NAME);
		name = sc.next();
		i_name = name;
		if (inputState = inputReset(i_name)) {
			createMemberShip();
			return;
		}
		System.out.println(INSERT_ADDRESS);
		address = sc.nextLine();
		sc.nextLine();
		i_address = address;
		if (inputState = inputReset(i_address)) {
			createMemberShip();
			return;
		}
		System.out.println(INSERT_PHONENUMBER);
		phoneNumber = sc.next();
		i_phoneNumber = phoneNumber;
		if (inputState = inputReset(i_phoneNumber)) {
			createMemberShip();
			return;
		}
		Member newMember = new Member(id, password, name, address, phoneNumber);
		for (int i = 0; i < member.length; i++) {
			if (member[i] == null) {
				member[i] = newMember;
//				System.out.println("member[" + i + "]: " + member[i].toString());
				System.out.println(member[i].getName() + JOINMEMBERSHIP_COMPLETE);
				break;
			}
		}
	}
// ID �ߺ��˻� �޼ҵ�
	@Override
	public void checkDuplicatedId() {
		while (true) {
			System.out.print(INSERT_ID);
			id = sc.next();
			if (inputReset(id))
				continue;
			System.out.println(START_DUPLICATED);
			for (int i = 0; i < member.length; i++) {
//				ȸ�������� �ΰ��϶�
				if (member[i] == null) {
					if (i == member.length - 1) {
						System.out.println(POSSIBLE_ID);
						return;
					}
				}
//				ȸ�������� �ΰ��� �ƴ� ��
				if (member[i] != null) {
//					id�� �ߺ��Ǵ� ���� ���� ���
					if (!id.equals(member[i].toStringId()) && i == member.length - 1) {
						System.out.println(POSSIBLE_ID);
						return;
//						id�� �ߺ��Ǵ°��
					} else if (id.equals(member[i].toStringId())) {
						System.out.println(USED_ID);
						System.out.println(TRY_AGAIN);
						break;
					}
				}
			}
		}
	}
//	�α��� �޼ҵ�
	@Override
	public void login() {
		String i_id = null;
		String i_password = null;
		System.out.println("***Login***");
		while(true) {
			System.out.println(INSERT_ID);
			i_id = sc.next();
			System.out.println(ENTER_PASSWORD);
			i_password = sc.next();
			for(int i = 0; i < member.length; i++) {
				System.out.println(member[i].toString());
				if(member[i] != null) {
					if(member[i].getId().equals(i_id) && member[i].getPassword().equals(i_password)) {
						System.out.println(member[i].getId() + "���� �α��� �ϼ̽��ϴ�.");
						member[i].setLoginState(true);
						logState = member[i].isLoginState();
						loginId = member[i].getId();
						break;
					}
				}else {
					if(member[member.length - 1] == null) {
					System.out.println("���̵� Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					System.out.println(TRY_AGAIN);
					break;
					}
				}
			}if(logState) break;
		}
	}
//	ȸ��Ż�� �޼ҵ�
	@Override
	public void withdrawl() {
		String i_id = null;
		String i_password = null;
		System.out.println("ȸ�� Ż��.");
		System.out.println(INSERT_ID);
		i_id = sc.next();
		System.out.println(ENTER_PASSWORD);
		i_password = sc.next();
		for (int i = 0; i < member.length; i++) {
			Member mem = member[i];
			if (mem == null)
				break;
			String id = mem.getId();
			if (id.equals(i_id)) {
				System.out.println("������ Ż�� �Ͻðڽ��ϱ�?(1.Yes|2.No)");
				int selectNum=sc.nextInt();
				if(selectNum==1) {
				System.out.println(member[i].getId() + "Ż��");
				member[i] = null;
				}else break;
			}
		}
		for (int i = 0; i < member.length; i++) {
			if (member[i] != null) {
				System.out.println(i + ": " + member[i].getId());
			}
		}
	}
//	ȸ������ ����
	@Override
	public void editMembership() {
		System.out.println("***ȸ�� ���� ����***");
		checkMembership();
		try {
			while (true) {
				System.out.println("=================================");
				System.out.println("1.�̸�|2.�ּ�|3.����ó|4.��й�ȣ|5.����");
				System.out.println("=================================");
				System.out.println("�����Ͻ� ������ �����ϼ���.>>(1~5)");
				int menuSelect = sc.nextInt();
				if (menuSelect == 1) {
					System.out.println("���� ȸ������ ������ " + editorMember.getName() + "�Դϴ�.");
					System.out.println("�����Ͻ� �̸��� �Է��ϼ���.>>");
					name = sc.next();
					editorMember.setName(name);
					System.out.println(editorMember.getName() + " ���� ���� �Ϸ�Ǿ����ϴ�.");
					break;
				}
				if (menuSelect == 2) {
					System.out.println("���� ȸ������ �ּҴ� " + editorMember.getAddress() + "�Դϴ�.");
					System.out.println("�����Ͻ� �ּҸ� �Է��ϼ���.>>");
					address = sc.next();
					editorMember.setAddress(address);
					System.out.println(editorMember.getAddress() + " ���� ���� �Ϸ�Ǿ����ϴ�.");
					break;
				}
				if (menuSelect == 3) {
					System.out.println("���� ȸ������ ����ó�� " + editorMember.getPhoneNumber() + "�Դϴ�.");
					System.out.println("�����Ͻ� ����ó�� �Է��ϼ���.>>");
					phoneNumber = sc.next();
					editorMember.setPhoneNumber(phoneNumber);
					System.out.println(phoneNumber + " ���� ���� �Ϸ�Ǿ����ϴ�.");
				}
				if (menuSelect == 4) {
					System.out.println("���� ȸ������ ����ó�� " + editorMember.getPassword() + "�Դϴ�.");
					System.out.println("�����Ͻ� ��й�ȣ�� �Է��ϼ���.>>");
					password = sc.next();
					editorMember.setPassword(password);
					System.out.println(editorMember.getPassword() + " ���� ���� �Ϸ�Ǿ����ϴ�.");
					break;
				}
				if (menuSelect == 5) {
					System.out.println(RETURN_FIRST_PAGE);
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(WRONG_KEY);
		}
	}
	@Override
	public void checkMembership() {
		while (true) {
			System.out.println(INSERT_ID);
			id = sc.next();
			System.out.println(ENTER_PASSWORD);
			password = sc.next();
			Member editMember = new Member(id, password);
			for (int i = 0; i < member.length; i++) {
				if (member[i] == null) {
					if (i == member.length - 1) {
						System.out.println(NOT_EXIST_MEMBERSHIP);
						System.out.println(TRY_AGAIN);
						break;
					}
				} else if (member[i] != null) {
					if (!editMember.toString().equals(member[i].toString()) && i == member.length - 1) {
						System.out.println(WRONG_ID_PASSWORD);
						System.out.println(TRY_AGAIN);
						break;
					} else if (editMember.toString().equals(member[i].toString())) {
						System.out.println(member[i].getId() + " ������ ȸ�������� �����մϴ�.");
						editorMember = member[i];
						return;
					}
				}
			}
		}
	}
	public boolean inputReset(String str) {
		if (str.equals("�ٽ�"))
			return true;
		else
			return false;
	}
}
