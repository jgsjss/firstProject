package project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ProductsManagementAndShopping implements Products {
//	�ʵ�
	private Scanner sc = new Scanner(System.in);
	ArrayList<Shoes> list = new ArrayList<Shoes>();
	ArrayList<ShoppingCart> cart = new ArrayList<ShoppingCart>();
	final String[] company = new String[] { "����Ű", "�Ƶ�ٽ�", "����" };
	final String[] model = new String[] { "����ƽ�", "��������", "���Ĺٿ", "��Ʈ��ν�Ʈ", "ǻ��", "DMX" };
	final int[] model_price = new int[] { 100000, 150000, 80000, 200000, 70000, 50000 };
	final String[] color = new String[] { "��", "ȭ��Ʈ", "����" };
	final int[] size = new int[] { 250, 255, 260, 265, 270 };
//	�Ź��� �����ϰ� 100�ӷ� ���� �� �ߺ���ü�� �����ϴ� �޼ҵ�
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
//		company ����Ű �϶�
			if (num_company == 0) {
//			model ����ƽ� �϶�
				if (num_model_nike == 0) {
					list.add(new Shoes(company[num_company], model[0], color[num_color], size[num_size], model_price[0],
							num_amount));
				}
//			model ���� �϶�
				else {
					list.add(new Shoes(company[num_company], model[1], color[num_color], size[num_size], model_price[1],
							num_amount));
				}
			}
//		company �Ƶ�ٽ� �϶�
			else if (num_company == 1) {
//			model ���Ĺٿ �϶�
				if (num_model_adidas == 2) {
					list.add(new Shoes(company[num_company], model[2], color[num_color], size[num_size], model_price[2],
							num_amount));
				}
//			model ��Ʈ��ν�Ʈ �϶�
				else {
					list.add(new Shoes(company[num_company], model[3], color[num_color], size[num_size], model_price[3],
							num_amount));
				}
			}
//		company ���� �϶�
			else {
//			model ǻ�� �϶�
				if (num_model_reebok == 4)
					list.add(new Shoes(company[num_company], model[4], color[num_color], size[num_size], model_price[4],
							num_amount));
//			model DMX�϶�
				else
					list.add(new Shoes(company[num_company], model[5], color[num_color], size[num_size], model_price[5],
							num_amount));
			}
//		�ߺ�üũ
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
				System.out.println("1.�ȭ ã��|2.��ٱ��� Ȯ��|3.�����ϱ�|4.���� ����");
				System.out.println("===========================================");
				System.out.println("�޴��� �����ϼ���.(1~4)>>");
				int menuSelect = sc.nextInt();
				if (menuSelect == 1)selectBrand();
				if (menuSelect == 2)
				if (menuSelect == 3)
				if (menuSelect == 4)break;
			}
			return;
		} catch (Exception e) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�! �ٽ� �õ��ϼ���!");
		}
	}
	public void selectBrand() {
		System.out.println("======================");
		System.out.println("1.����Ű|2.�Ƶ�ٽ�|3.����");
		System.out.println("======================");
		System.out.println("�޴��� �����ϼ���.>>");
		int brandNum = sc.nextInt();
		if (brandNum == 1) {
			System.out.println("����Ű �귣�带 �����ϼ̽��ϴ�.");
			System.out.println("==============");
			System.out.println("1.����ƽ�|2.����");
			System.out.println("==============");
			System.out.println("���� �����ϼ���.>>");
			int modelNum = sc.nextInt();
			if (modelNum == 1) {
				System.out.println("����ƽ� ���� �����ϼ̽��ϴ�.");
				System.out.println("=====================");
				System.out.println("1.��|2.ȭ��Ʈ|3.����");
				System.out.println("=====================");
				System.out.println("������ �����ϼ���.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("����Ű") && list.get(i).getModel().equals("����ƽ�")
								&& list.get(i).getColor().equals("��")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("����Ű") && list.get(i).getModel().equals("����ƽ�")
								&& list.get(i).getColor().equals("ȭ��Ʈ")) {System.out.println();
								System.out.println("==============================================");
								System.out.println("No: "+ i);
								System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
										+ list.get(i).getColor());
								System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("����Ű") && list.get(i).getModel().equals("����ƽ�")
								&& list.get(i).getColor().equals("����")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			} else {
				System.out.println("�������� ���� �����ϼ̽��ϴ�.");
				System.out.println("=====================");
				System.out.println("1.��|2.ȭ��Ʈ|3.����");
				System.out.println("=====================");
				System.out.println("������ �����ϼ���.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("����Ű") && list.get(i).getModel().equals("��������")
								&& list.get(i).getColor().equals("��")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("����Ű") && list.get(i).getModel().equals("��������")
								&& list.get(i).getColor().equals("ȭ��Ʈ")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("����Ű") && list.get(i).getModel().equals("��������")
								&& list.get(i).getColor().equals("����")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			}
		}
		if (brandNum == 2) {
			System.out.println("�Ƶ�ٽ� �귣�带 �����ϼ̽��ϴ�.");
			System.out.println("======================");
			System.out.println("1.���Ĺٿ|2.��Ʈ��ν�Ʈ");
			System.out.println("======================");
			System.out.println("���� �����ϼ���.>>");
			int modelNum = sc.nextInt();
			if (modelNum == 1) {
				System.out.println("���Ĺٿ ���� �����ϼ̽��ϴ�.");
				System.out.println("=====================");
				System.out.println("1.��|2.ȭ��Ʈ|3.����");
				System.out.println("=====================");
				System.out.println("������ �����ϼ���.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("�Ƶ�ٽ�") && list.get(i).getModel().equals("���Ĺٿ")
								&& list.get(i).getColor().equals("��")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("�Ƶ�ٽ�") && list.get(i).getModel().equals("���Ĺٿ")
								&& list.get(i).getColor().equals("ȭ��Ʈ")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if(colorNum == 3){
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("�Ƶ�ٽ�") && list.get(i).getModel().equals("���Ĺٿ")
								&& list.get(i).getColor().equals("����")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			}else {
				System.out.println("��Ʈ��ν�Ʈ ���� �����ϼ̽��ϴ�.");
				System.out.println("=====================");
				System.out.println("1.��|2.ȭ��Ʈ|3.����");
				System.out.println("=====================");
				System.out.println("������ �����ϼ���.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("�Ƶ�ٽ�") && list.get(i).getModel().equals("��Ʈ��ν�Ʈ")
								&& list.get(i).getColor().equals("��")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("�Ƶ�ٽ�") && list.get(i).getModel().equals("��Ʈ��ν�Ʈ")
								&& list.get(i).getColor().equals("ȭ��Ʈ")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if(colorNum == 3){
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("�Ƶ�ٽ�") && list.get(i).getModel().equals("��Ʈ��ν�Ʈ")
								&& list.get(i).getColor().equals("����")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.>>");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			}
		}else if (brandNum == 3) {
			System.out.println("���� �귣�带 �����ϼ̽��ϴ�.");
			System.out.println("======================");
			System.out.println("1.ǻ��|2.DMX");
			System.out.println("======================");
			System.out.println("���� �����ϼ���.>>");
			int modelNum = sc.nextInt();
			if (modelNum == 1) {
				System.out.println("ǻ�� ���� �����ϼ̽��ϴ�.");
				System.out.println("=====================");
				System.out.println("1.��|2.ȭ��Ʈ|3.����");
				System.out.println("=====================");
				System.out.println("������ �����ϼ���.>>");
				int colorNum = sc.nextInt();
				if (colorNum == 1) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("����") && list.get(i).getModel().equals("ǻ��")
								&& list.get(i).getColor().equals("��")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if (colorNum == 2) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("����") && list.get(i).getModel().equals("ǻ��")
								&& list.get(i).getColor().equals("ȭ��Ʈ")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				} else if(colorNum == 3) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getCompany().equals("����") && list.get(i).getModel().equals("ǻ��")
								&& list.get(i).getColor().equals("����")) {
							System.out.println();
							System.out.println("==============================================");
							System.out.println("No: "+ i);
							System.out.println("�귣��: " + list.get(i).getCompany() + " ��: " + list.get(i).getModel() + " ����: "
									+ list.get(i).getColor());
							System.out.println("������:" + list.get(i).getSize() + "����: " + list.get(i).getPrice());
						}
					}
					System.out.println("==============================================");
					System.out.println();
					System.out.println("�����Ͻ� ��ǰ�� No�� �Է��ϼ���.");
					int buyNo = sc.nextInt();
					cart.addAll((Collection<? extends ShoppingCart>) list.get(buyNo));
					System.out.println(cart.get(buyNo));
				}
			}
		}
	}
}
