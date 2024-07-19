package group3TeamProject.service;

import java.sql.Connection;
import java.util.Scanner;

import group3TeamProject.dao.CutDAO;
import group3TeamProject.dao.ShopDAO;
import group3TeamProject.dto.CutDTO;
import group3TeamProject.dto.ShopDTO;

public class AdminService {

	Scanner scanner = new Scanner(System.in);
	Connection connection = null; // 붙일때는 지워주세요. (빨간출 제거용으로 작성됨)

	public void adminMenu() { // 관리자 1 디자이너 2 고객 3
		boolean adminMenuRun = true;
		while (adminMenuRun) {
			System.out.println("-------------- 관리자 메뉴판 -------------");
			System.out.println("1.헤어컷 관리|2.매장 관리|3.계정 관리|4.뒤로가기 ");
			System.out.println("--------------------------------------");
			System.out.print(">>>");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("헤어컷 관리");
				manageCut();
				break;
			case 2:
				System.out.println("매장 관리");
				manageShop();
				break;
			case 3:
				System.out.println("계정 관리");
				manageAccount();
				break;
			case 4:
				System.out.println("관리자 메뉴 종료");
				adminMenuRun = false;
				break;
			default:
				System.out.println("명령어만 입력해 주세요.");

			}// end switch

		} // end while

	}// end adminMenu() method

	public void manageCut() { // 헤어컷 관리 메뉴
		boolean hairMenuRun = true;
		while (hairMenuRun) {
			System.out.println("---------- 헤어컷 관리 ----------");
			System.out.println("   1.추가|2.수정|3.제거|4.뒤로가기");
			System.out.println("------------------------------");
			System.out.print(">>>");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("헤어컷 추가를 진행합니다.");
				manageCutAdd();
				break;
			case 2:
				System.out.println("헤어컷 수정을 진행합니다.");
				manageCutEdit();
				break;
			case 3:
				System.out.println("헤어컷 제거를 진행합니다.");
				manageHairDelete();
				break;
			case 4:
				System.out.println("헤어컷 관리 종료");
				hairMenuRun = false;
				break;
			default:
				System.out.println("명령어만 입력해 주세요.");
			}// end switch
		} // end while
	} // end manageHairCut()

	public void manageCutAdd() { // 헤어컷 추가 메서드

		System.out.println("아래 내용을 입력해 주세요.");
		System.out.print("매장이름 : ");
		String csname = scanner.next();
		System.out.print("매장번호 : ");
		int csno = scanner.nextInt();
		System.out.print("커트이름 : ");
		String ccutname = scanner.next();
		System.out.print("커트가격 : ");
		int cprice = scanner.nextInt();
		System.out.print("커트설명 : ");
		String ccontents = scanner.next();
		CutDTO cutdto = new CutDTO(csname, csno, ccutname, cprice, ccontents);
		CutDAO cutdao = new CutDAO();
		cutdao.insertCut(cutdto, connection);
	}// end manageCutAdd() method

	public void manageCutEdit() { // 헤어컷 수정 메서드
		String updateCut = null;
		System.out.println("아래 내용을 입력해 주세요.");
		System.out.print("변경하실 헤어의 코드 : ");
		int ccode = scanner.nextInt();
		System.out.println("변경 사항을 입력해 주세요.");
		System.out.println("1.매장이름	2.매장번호	3.커트이름");
		System.out.println("4.커트가격	5.커트내용");
		System.out.println("*원치 않을 시 아무키나 눌러주세요.");
		int select = scanner.nextInt();
		switch (select) {
		case 1: // String 타입 처리
			System.out.println("매장 이름을 변경합니다.");
			updateCut = "csname"; // 바꾸길 원하는 값 입력
			toCutEditString(ccode, updateCut);
			break;
		case 2: // int 타입 처리
			System.out.println("매장 번호을 변경합니다.");
			updateCut = "csno"; // 바꾸길 원하는 값 입력
			toCutEditInt(ccode, updateCut);
			break;
		case 3: // String
			System.out.println("커트 이름을 변경합니다.");
			updateCut = "ccutname"; // 바꾸길 원하는 값 입력
			toCutEditString(ccode, updateCut);
			break;
		case 4: // int
			System.out.println("커트 가격을 변경합니다.");
			updateCut = "cprice"; // 바꾸길 원하는 값 입력
			toCutEditInt(ccode, updateCut);
			break;
		case 5:// String
			System.out.println("커트 내용을 변경합니다.");
			updateCut = "ccontents"; // 바꾸길 원하는 값 입력
			toCutEditString(ccode, updateCut);
			break;
		default:
			System.out.println("뒤로 돌아갑니다.");
		}// end switch

	}// manageHairEdit() method
	
	public void toCutEditString(int ccode, String updateCut) { // CutEditString 메서드로 전달하는 메서드
		System.out.print("변경 값 입력 : ");
		String inputSt = scanner.next();
		CutDTO cutdto = new CutDTO();
		cutdto.setCcode(ccode);
		CutDAO cutdao = new CutDAO();
		cutdao.cutEditString(cutdto, updateCut, inputSt, connection);
	}
	
	public void toCutEditInt(int ccode, String updateCut) { // CutEditInt 메서드로 전달하는 메서드
		System.out.print("변경 값 입력 : ");
		int inputIn = scanner.nextInt();
		CutDTO cutdto = new CutDTO();
		cutdto.setCcode(ccode);
		CutDAO cutdao = new CutDAO();
		cutdao.cutEditInt(cutdto, updateCut, inputIn, connection);
	}

	public void manageHairDelete() { // 헤어컷 삭제 메서드
		System.out.println("아래 내용을 입력해 주세요.");
		System.out.print("삭제하실 헤어 코드 : ");
		int ccode = scanner.nextInt();
		CutDTO cutDel = new CutDTO();
		cutDel.setCcode(ccode);

		CutDAO cutDelDao = new CutDAO();
		cutDelDao.cutDelete(cutDel, connection);

	}// manageHairDelete() method
	

	public void manageShop() { // 매장 관리 메뉴
		boolean shopMenuRun = true;
		while (shopMenuRun) {
			System.out.println("-------  매장 관리(shop) -------");
			System.out.println("   1.추가|2.수정|3.제거|4.뒤로가기");
			System.out.println("------------------------------");
			System.out.print(">>>");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("매장 추가를 진행합니다.");
				manageShopAdd();
				break;
			case 2:
				System.out.println("매장 수정을 진행합니다.");
				manageShopEdit();
				break;
			case 3:
				System.out.println("매장 제거를 진행합니다.");
				manageShopDelete();
				break;
			case 4:
				System.out.println("매장 관리 메뉴 종료");
				shopMenuRun = false;
				break;
			default:
				System.out.println("명령어만 입력해 주세요.");
			}// end switch
		} // end while
	}

	public void manageShopAdd() { // 매장을 추가하는 메서드
		System.out.println("아래 내용을 입력해 주세요.");
		System.out.print("매장이름 : ");
		String sname = scanner.next();
		System.out.print("매장위치 : ");
		String slocation = scanner.next();
		System.out.print("매장번호 : ");
		int sno = scanner.nextInt();
		System.out.print("매장 디자이너 : ");
		String sdesigner = scanner.next();
		System.out.print("매장 여는시간(open) : ");
		String sopen = scanner.next();
		System.out.print("매장 닫는시간(close) : ");
		String sclose = scanner.next();
		ShopDTO shopdto = new ShopDTO(sname, slocation, sno, sdesigner, sopen, sclose);
		ShopDAO shopdao = new ShopDAO();
		shopdao.insertShop(shopdto, connection);
	}// end manageShopAdd() method

	public void manageShopEdit() { // 매장 정보를 수정하는 메서드
		String updateShop = null;
		System.out.println("아래 내용을 입력해 주세요.");
		System.out.print("변경하실 매장의 번호 : ");
		int sno = scanner.nextInt();
		System.out.println("변경 사항을 입력해 주세요.");
		System.out.println("1.매장이름	2.매장위치	3.매장번호");
		System.out.println("4.디자이너	5.여는시간	6.닫는시간");
		System.out.println("*원치 않을 시 아무키나 눌러주세요.");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			System.out.println("매장 이름을 변경합니다.");
			updateShop = "sname"; // 바꾸길 원하는 값 입력
			toCutEditString(sno, updateShop);
			break;
		case 2:
			System.out.println("매장 위치를 변경합니다.");
			updateShop = "slocation"; // 바꾸길 원하는 값 입력
			toCutEditString(sno, updateShop);
			break;
		case 3:
			System.out.println("매장 번호을 변경합니다.");
			updateShop = "csno"; // 바꾸길 원하는 값 입력
			toCutEditInt(sno, updateShop);
			break;
		case 4:
			System.out.println("매장 디자이너를 변경합니다.");
			updateShop = "sdesigner"; // 바꾸길 원하는 값 입력
			toCutEditString(sno, updateShop);
			break;
		case 5:
			System.out.println("매장 오픈시간을 변경합니다.");
			updateShop = "sopen"; // 바꾸길 원하는 값 입력
			toCutEditString(sno, updateShop);
			break;
		case 6:
			System.out.println("매장 클로즈시간을 변경합니다.");
			updateShop = "sclose"; // 바꾸길 원하는 값 입력
			toCutEditString(sno, updateShop);
			break;
		default:
			System.out.println("명령어만 입력해주세요");
		}// end switch
	}// end manageShopEdit() method

	public void toshopEditString(int sno, String updateShop) { // shopEditString 메서드로 전달하는 메서드
		System.out.print("변경 값 입력 : ");
		String inputSt = scanner.next();
		ShopDTO shopdto = new ShopDTO();
		shopdto.setSno(sno);
		ShopDAO shopdao = new ShopDAO();
		shopdao.shopEditString(shopdto, updateShop, inputSt, connection);
	}
	
	public void toshopEditInt(int sno, String updateShop) { // shopEditInt 메서드로 전달하는 메서드
		System.out.print("변경 값 입력 : ");
		int inputIn = scanner.nextInt();
		ShopDTO shopdto = new ShopDTO();
		shopdto.setSno(sno);
		ShopDAO shopdao = new ShopDAO();
		shopdao.shopEditInt(shopdto, updateShop, inputIn, connection);
	}
	
	public void manageShopDelete() { // 매장을 삭제하는 메서드 
		System.out.println("아래 내용을 입력해 주세요.");
		System.out.print("삭제하실 매장 번호 : ");
		int sno = scanner.nextInt();
		ShopDTO shopdto = new ShopDTO();
		shopdto.setSno(sno);

		ShopDAO shopDelDao = new ShopDAO();
		shopDelDao.shopDelete(shopdto, connection);
	}
	
	public void manageAccount() {
		boolean DesignerMenuRun = true;
		while (DesignerMenuRun) {
			System.out.println("---------- 디자이너 관리 ----------");
			System.out.println("    1.계정등급변경|2.뒤로가기");
			System.out.println("-------------------------------");
			System.out.print(">>>");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("계정 등급 변경");
				//accountGradeEdit();
				break;
			case 2:
				System.out.println("디자이너 관리 종료");
				DesignerMenuRun = false;
				break;
			default:
				System.out.println("명령어만 입력해 주세요.");

			}// end switch
		} // end while
	} // end manageDesigner()

	/*
	public void accountGradeEdit() {
		System.out.println("아래 내용을 입력해 주세요.");
		System.out.print("회원 번호 : ");
		int mno = scanner.nextInt();
		System.out.print("변경할 회원 등급 : ");
		int mgrade = scanner.nextInt();
		MemberDTO memberNo = new MemberDTO();
		memberNo.setMno(mno);
		memberNo.setMgrade(mgrade);

		ShopDAO shopdao8 = new ShopDAO();
		shopdao8.memberGradeEdit(memberNo, connection);

	}// end accountGradeEdit() method
	*/

	
	
}// end class
