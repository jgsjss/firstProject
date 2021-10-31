package project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ProductsManagementAndShopping implements Products {
//	필드
	private Scanner sc = new Scanner(System.in);
	ArrayList<Shoes> list = new ArrayList<Shoes>();
	ArrayList<ShoppingCart> cart = new ArrayList<ShoppingCart>();
	final String[] company = new String[] { "나이키", "아디다스", "리복" };
	final String[] model = new String[] { "에어맥스", "에어조던", "알파바운스", "울트라부스트", "퓨리", "DMX" };
	final int[] model_price = new int[] { 100000, 150000, 80000, 200000, 70000, 50000 };
	final String[] color = new String[] { "블랙", "화이트", "레드" };
	final int[] size = new int[] { 250, 255, 260, 265, 270 };
//	신발을 랜덤하게 100켤레 생산 후 중복개체는 제거하는 메소드
	@Override
	public void createShoes() {
		for (int i = 0; i <= 100; i++) {
			int num_company = (int) (Math.random() * 3);
			int num_color = (int) (Math.random() * 3);
			int num_size = (int) (Math.random() * 5);
			int num_model_nike = (int) (Math.random() * 2);
			int num_model_adidas = (int) (Math.random() * 2) + 2;
			int num_model_reebok = (int) (Math.random() * 2) + 4;
			int num_amount = (int) (Math.random() * 100) + 1;
//		company 나이키 일때
			if (num_company == 0) {
//			model 에어맥스 일때
				if (num_model_nike == 0) {
					list.add(new Shoes(company[num_company], model[0], color[num_color], size[num_size], model_price[0],
							num_amount));
				}
//			model 조던 일때
				else {
					list.add(new Shoes(company[num_company], model[1], color[num_color], size[num_size], model_price[1],
							num_amount));
				}
			}
//		company 아디다스 일때
			else if (num_company == 1) {
//			model 알파바운스 일때
				if (num_model_adidas == 2) {
					list.add(new Shoes(company[num_company], model[2], color[num_color], size[num_size], model_price[2],
							num_amount));
				}
//			model 울트라부스트 일때
				else {
					list.add(new Shoes(company[num_company], model[3], color[num_color], size[num_size], model_price[3],
							num_amount));
				}
			}
//		company 리복 일때
			else {
//			model 퓨리 일때
				if (num_model_reebok == 4)
					list.add(new Shoes(company[num_company], model[4], color[num_color], size[num_size], model_price[4],
							num_amount));
//			model DMX일때
				else
					list.add(new Shoes(company[num_company], model[5], color[num_color], size[num_size], model_price[5],
							num_amount));
			}
//		중복체크
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) == null)
					break;
				for (int b = j + 1; b < list.size(); b++) {
					if (list.get(j) != null) {
						if (list.get(j).getModel().equals(list.get(b).getModel())
								&& list.get(j).getSize() == list.get(b).getSize()
								&& list.get(j).getColor().equals(list.get(b).getColor())) {
							list.remove(b);
							break;
						}
					} else
						break;
				}
			}
		}
	}

	@Override
	public void addShoes() {}
	@Override
	public void sellShoes(String model, int size, String color) {
		for (int i = 0; i < list.size(); i++) {
			if (model.equals(list.get(i).getModel()) && size == list.get(i).getSize()
					&& color.equals(list.get(i).getColor())) {
				int num = list.get(i).getAmount();
				list.get(i).setAmount(--num);
			}
		}
	}
	@Override
	public void ShoesList() {}
	public void shoppingStart() {
		createShoes();
		try {
			while (true) {
				System.out.println("===========================================");
				System.out.println("1.운동화 찾기|2.장바구니 확인|3.결제하기|4.쇼핑 종료");
				System.out.println("===========================================");
				System.out.println("메뉴를 선택하세요.(1~4)>>");
				int menuSelect = sc.nextInt();
				if (menuSelect == 1)selectBrand();
				if (menuSelect == 2)
				if (menuSelect == 3)
				if (menuSelect == 4)break;
			}
			return;
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다! 다시 시도하세요!");
		}
	}
	public void selectBrand() {
		System.out.println("======================");
		System.out.println("1.나이키|2.아디다스|3.리복");
		System.out.println("======================");
		System.out.println("메뉴를 선택하세요.>>");
		int brandNum = sc.nextInt();
		if (brandNum == 1) {
			System.out.println("나이키 브랜드를 선택하셨습니다.");
			System.out.println("==============");
			System.out.println("1.에어맥스|2.조던");
			System.out.println("==============");
			System.out.println("모델을 선택하세요.>>");
			int modelNum = sc.nextInt();
			if (modelNum == 1) {
				System.out.println("에어맥스 모델을 선택하셨습니다.");
				System.out.println("=====================");
				System.out.println("1.블랙|2.화이트|3.레드");
				System.out.println("=====================");
				System.out.println("색상을 선택하세요.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("나이키") && list.get(i).getModel().equals("에어맥스")
								&& list.get(i).getColor().equals("블랙")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("나이키") && list.get(i).getModel().equals("에어맥스")
								&& list.get(i).getColor().equals("화이트")) {System.out.println();
								System.out.println("==============================================");
								System.out.println("No: "+ i);
								System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
										+ list.get(i).getColor());
								System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("나이키") && list.get(i).getModel().equals("에어맥스")
								&& list.get(i).getColor().equals("레드")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			} else {
				System.out.println("에어조던 모델을 선택하셨습니다.");
				System.out.println("=====================");
				System.out.println("1.블랙|2.화이트|3.레드");
				System.out.println("=====================");
				System.out.println("색상을 선택하세요.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("나이키") && list.get(i).getModel().equals("에어조던")
								&& list.get(i).getColor().equals("블랙")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("나이키") && list.get(i).getModel().equals("에어조던")
								&& list.get(i).getColor().equals("화이트")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("나이키") && list.get(i).getModel().equals("에어조던")
								&& list.get(i).getColor().equals("레드")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			}
		}
		if (brandNum == 2) {
			System.out.println("아디다스 브랜드를 선택하셨습니다.");
			System.out.println("======================");
			System.out.println("1.알파바운스|2.울트라부스트");
			System.out.println("======================");
			System.out.println("모델을 선택하세요.>>");
			int modelNum = sc.nextInt();
			if (modelNum == 1) {
				System.out.println("알파바운스 모델을 선택하셨습니다.");
				System.out.println("=====================");
				System.out.println("1.블랙|2.화이트|3.레드");
				System.out.println("=====================");
				System.out.println("색상을 선택하세요.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("아디다스") && list.get(i).getModel().equals("알파바운스")
								&& list.get(i).getColor().equals("블랙")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("아디다스") && list.get(i).getModel().equals("알파바운스")
								&& list.get(i).getColor().equals("화이트")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if(colorNum == 3){
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("아디다스") && list.get(i).getModel().equals("알파바운스")
								&& list.get(i).getColor().equals("레드")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			}else {
				System.out.println("울트라부스트 모델을 선택하셨습니다.");
				System.out.println("=====================");
				System.out.println("1.블랙|2.화이트|3.레드");
				System.out.println("=====================");
				System.out.println("색상을 선택하세요.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("아디다스") && list.get(i).getModel().equals("울트라부스트")
								&& list.get(i).getColor().equals("블랙")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("아디다스") && list.get(i).getModel().equals("울트라부스트")
								&& list.get(i).getColor().equals("화이트")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if(colorNum == 3){
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("아디다스") && list.get(i).getModel().equals("울트라부스트")
								&& list.get(i).getColor().equals("레드")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.>>");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			}
		}else if (brandNum == 3) {
			System.out.println("리복 브랜드를 선택하셨습니다.");
			System.out.println("======================");
			System.out.println("1.퓨리|2.DMX");
			System.out.println("======================");
			System.out.println("모델을 선택하세요.>>");
			int modelNum = sc.nextInt();
			if (modelNum == 1) {
				System.out.println("퓨리 모델을 선택하셨습니다.");
				System.out.println("=====================");
				System.out.println("1.블랙|2.화이트|3.레드");
				System.out.println("=====================");
				System.out.println("색상을 선택하세요.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("리복") && list.get(i).getModel().equals("퓨리")
								&& list.get(i).getColor().equals("블랙")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("리복") && list.get(i).getModel().equals("퓨리")
								&& list.get(i).getColor().equals("화이트")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if(colorNum == 3) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("리복") && list.get(i).getModel().equals("퓨리")
								&& list.get(i).getColor().equals("레드")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("브랜드: " + list.get(i).getCompany() + " 모델: " + list.get(i).getModel() + " 색상: "
									+ list.get(i).getColor());
							System.out.println("사이즈:" + list.get(i).getSize() + "가격: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("구매하실 상품의 No를 입력하세요.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			}
		}
	}
}
