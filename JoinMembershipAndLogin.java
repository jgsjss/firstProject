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
//	회원가입 및 로그인, 수정, 탈퇴, 종료 등을 하는 메소드
	public boolean membershipAndLogin() {
		System.out.println("***********SHOES MARKET***********");
			try {
				while (true) {
					if(logState) {
						System.out.println(loginId + "님의 즐거운 쇼핑 되시길 바랍니다.");
						break;
					}
					System.out.println("=================================================");
					System.out.println("1.회원가입|2.로그인 하기|3.회원정보 수정|4.회원 탈퇴|5.종료");
					System.out.println("=================================================");
					System.out.println("메뉴를 선택하세요(1 ~ 5).>>");
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
						System.out.println("쇼핑 종료.");
						System.exit(0);
					}
				}
			}catch (Exception e) {System.out.println(WRONG_KEY);}
			return logState;
	}
//	회원가입 메소드
	@Override
	public void createMemberShip() {
		boolean inputState = false;
		String i_password = null;
		String i_name = null;
		String i_address = null;
		String i_phoneNumber = null;
		System.out.println("***회원 가입***");
		System.out.println("재입력을 원하시면 \"다시\" 를 입력하세요. ");
//		중복체크 메소드 호출
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
// ID 중복검사 메소드
	@Override
	public void checkDuplicatedId() {
		while (true) {
			System.out.print(INSERT_ID);
			id = sc.next();
			if (inputReset(id))
				continue;
			System.out.println(START_DUPLICATED);
			for (int i = 0; i < member.length; i++) {
//				회원정보가 널값일때
				if (member[i] == null) {
					if (i == member.length - 1) {
						System.out.println(POSSIBLE_ID);
						return;
					}
				}
//				회원정보가 널값이 아닐 때
				if (member[i] != null) {
//					id가 중복되는 값이 없는 경우
					if (!id.equals(member[i].toStringId()) && i == member.length - 1) {
						System.out.println(POSSIBLE_ID);
						return;
//						id가 중복되는경우
					} else if (id.equals(member[i].toStringId())) {
						System.out.println(USED_ID);
						System.out.println(TRY_AGAIN);
						break;
					}
				}
			}
		}
	}
//	로그인 메소드
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
						System.out.println(member[i].getId() + "님이 로그인 하셨습니다.");
						member[i].setLoginState(true);
						logState = member[i].isLoginState();
						loginId = member[i].getId();
						break;
					}
				}else {
					if(member[member.length - 1] == null) {
					System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
					System.out.println(TRY_AGAIN);
					break;
					}
				}
			}if(logState) break;
		}
	}
//	회원탈퇴 메소드
	@Override
	public void withdrawl() {
		String i_id = null;
		String i_password = null;
		System.out.println("회원 탈퇴.");
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
				System.out.println("정말로 탈퇴 하시겠습니까?(1.Yes|2.No)");
				int selectNum=sc.nextInt();
				if(selectNum==1) {
				System.out.println(member[i].getId() + "탈퇴");
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
//	회원정보 수정
	@Override
	public void editMembership() {
		System.out.println("***회원 정보 수정***");
		checkMembership();
		try {
			while (true) {
				System.out.println("=================================");
				System.out.println("1.이름|2.주소|3.연락처|4.비밀번호|5.종료");
				System.out.println("=================================");
				System.out.println("수정하실 정보를 선택하세요.>>(1~5)");
				int menuSelect = sc.nextInt();
				if (menuSelect == 1) {
					System.out.println("현재 회원님의 성함은 " + editorMember.getName() + "입니다.");
					System.out.println("수정하실 이름을 입력하세요.>>");
					name = sc.next();
					editorMember.setName(name);
					System.out.println(editorMember.getName() + " 으로 수정 완료되었습니다.");
					break;
				}
				if (menuSelect == 2) {
					System.out.println("현재 회원님의 주소는 " + editorMember.getAddress() + "입니다.");
					System.out.println("수정하실 주소를 입력하세요.>>");
					address = sc.next();
					editorMember.setAddress(address);
					System.out.println(editorMember.getAddress() + " 으로 수정 완료되었습니다.");
					break;
				}
				if (menuSelect == 3) {
					System.out.println("현재 회원님의 연락처는 " + editorMember.getPhoneNumber() + "입니다.");
					System.out.println("수정하실 연락처를 입력하세요.>>");
					phoneNumber = sc.next();
					editorMember.setPhoneNumber(phoneNumber);
					System.out.println(phoneNumber + " 으로 수정 완료되었습니다.");
				}
				if (menuSelect == 4) {
					System.out.println("현재 회원님의 연락처는 " + editorMember.getPassword() + "입니다.");
					System.out.println("수정하실 비밀번호를 입력하세요.>>");
					password = sc.next();
					editorMember.setPassword(password);
					System.out.println(editorMember.getPassword() + " 으로 수정 완료되었습니다.");
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
						System.out.println(member[i].getId() + " 계정의 회원정보를 수정합니다.");
						editorMember = member[i];
						return;
					}
				}
			}
		}
	}
	public boolean inputReset(String str) {
		if (str.equals("다시"))
			return true;
		else
			return false;
	}
}
