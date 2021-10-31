package project;

public interface MemberManegement {
	public String WRONG_KEY = "잘못 입력하셨습니다! 다시 시도하세요!";
	public String START_DUPLICATED = "ID 중복검사를 실행합니다.";
	public String INSERT_PHONENUMBER = "연락처를 입력하세요.>>";
	public String INSERT_ID = "ID를 입력하세요. >>";
	public String ENTER_PASSWORD = "비밀번호를 입력하세요. >>";
	public String INSERT_NAME = "성함을 입력하세요.>>";
	public String INSERT_ADDRESS = "주소를 입력하세요.>>";
	public String JOINMEMBERSHIP_COMPLETE = " 님의 회원가입이 완료되었습니다.";
	public String WRONG_ID = "ID가 틀리거나 존재하지 않습니다.";
	public String WRONG_PASSWORD = "password가 틀립니다.";
	public String WRONG_ID_PASSWORD= "ID나 비밀번호가 틀립니다.";
	public String TRY_AGAIN = "다시 입력하세요";
	public String EDIT_MEMBERSHIP = " 님의 회원정보가 수정되었습니다.";
	public String USED_ID = "이미 사용중인 ID입니다.";
	public String POSSIBLE_ID = "사용 가능한 ID입니다.";
	public String NOT_EXIST_MEMBERSHIP = "일치하는 회원정보가 없습니다.";
	public String RETURN_FIRST_PAGE = "처음 화면으로 돌아갑니다.";
	
//	회원가입 메소드
	public void createMemberShip();
//	로그인 메소드
	public void login();
//	회원탈퇴 메소드
	public void withdrawl();
//	회원정보 수정 메소드
	public void editMembership();
	public void checkMembership();
//	ID중복확인 메소드
	public void checkDuplicatedId();

	
}
