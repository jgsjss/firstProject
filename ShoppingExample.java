package project;


public class ShoppingExample {

	Member member = new Member();
	public static void main(String[] args) {
		JoinMembershipAndLogin jm = new JoinMembershipAndLogin();
		ProductsManagementAndShopping pm = new ProductsManagementAndShopping();
		jm.membershipAndLogin();
		if(jm.membershipAndLogin()) {pm.shoppingStart();}
	}
}
