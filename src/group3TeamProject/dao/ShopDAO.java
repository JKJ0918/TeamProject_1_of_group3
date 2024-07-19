package group3TeamProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import group3TeamProject.dto.CutDTO;
import group3TeamProject.dto.ShopDTO;

public class ShopDAO {
	
	public void insertShop(ShopDTO shopdto, Connection connection) { // 매장 추가 메서드
		int resultInsertShop = 0;
		try {
			String sql = "insert into shop(sname, slocation, sno, sdesigner, sopen, sclose)"
					+ " values(?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, shopdto.getSname());
			preparedStatement.setString(2, shopdto.getSlocation());
			preparedStatement.setInt(3, shopdto.getSno());
			preparedStatement.setString(4, shopdto.getSdesigner());
			preparedStatement.setString(5, shopdto.getSopen());
			preparedStatement.setString(6, shopdto.getSclose());
			resultInsertShop = preparedStatement.executeUpdate();
			if (resultInsertShop > 0) {
				System.out.println(resultInsertShop + "행의 데이터를 추가했습니다.");
				connection.commit();
			} else {
				System.out.println("결과" + resultInsertShop + "입니다.");
				System.out.println("입력 실패 : 롤백합니다.");
				connection.rollback();
			}
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("관리자 : sql 문을 확인하세요");
			e.printStackTrace();
		}
	}// end insertCut() method

	public void shopEditString(ShopDTO shopdto, String updateShop, String inputSt, // 매장이름 / 매커트이름 / 커트내용 수정 메서드
			Connection connection) { 
		int resultEditSt = 0;
		try {
			String sql = "update shop set" + updateShop + "= ? where sno = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, inputSt);
			preparedStatement.setInt(2, shopdto.getSno());
			resultEditSt = preparedStatement.executeUpdate();
			if (resultEditSt > 0) {
				System.out.println(resultEditSt + "행의 데이터를 수정했습니다.");
				connection.commit();
			} else {
				System.out.println("결과" + resultEditSt + "입니다.");
				System.out.println("입력 실패 : 롤백합니다.");
				connection.rollback();
			}
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("관리자 : sql 문을 확인하세요");
			e.printStackTrace();
		}
	}// end cutEditString() method

	public void shopEditInt(ShopDTO shopdto, String updateShop, int inputIn, // 매장번호 / 커트가격 수정 메서드
			Connection connection) { 
		int resultEditIn = 0;
		try {
			String sql = "update shop set" + updateShop + "= ? where sno = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, inputIn);
			preparedStatement.setInt(2, shopdto.getSno());
			resultEditIn = preparedStatement.executeUpdate();
			if (resultEditIn > 0) {
				System.out.println(resultEditIn + "행의 데이터를 수정했습니다.");
				connection.commit();
			} else {
				System.out.println("결과" + resultEditIn + "입니다.");
				System.out.println("입력 실패 : 롤백합니다.");
				connection.rollback();
			}
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("관리자 : sql 문을 확인하세요");
			e.printStackTrace();
		}
	}// end cutEditString() method

	public void shopDelete(ShopDTO shopdto, Connection connection) { // 헤어스타일 삭제 메서드
		int resultShopDel = 0;
		try {
			String sql = "delete from shop where sno = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, shopdto.getSno());
			resultShopDel = preparedStatement.executeUpdate();
			if (resultShopDel > 0) {
				System.out.println(resultShopDel + "행의 데이터를 삭제했습니다.");
				connection.commit();
			} else {
				System.out.println("결과" + resultShopDel + "입니다.");
				System.out.println("입력 실패 : 롤백합니다.");
				connection.rollback();
			}
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("관리자 : sql 문을 확인하세요");
			e.printStackTrace();
		}
	}// end shopDesignerEdit() method
	
	public void shopAllList(Connection connection) {  // 현재 생성된 shop 관련 내용 출력 // V1.0.1 추가 요청
		try {
			String sql = "select * from shop order by sno desc";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 표형식으로 리턴된 값 유무 판단
				System.out.print("매장번호:"+ resultSet.getInt("sno") + "\t");
				System.out.print("매장이름:"+ resultSet.getString("sname") + "\t");
				System.out.println("매장위치:"+ resultSet.getString("slocation"));
				System.out.print("디자이너:"+ resultSet.getString("sdesigner") + "\t");
				System.out.print("오픈시간:"+ resultSet.getString("sopen") + "\t");
				System.out.println("클로즈시간:"+ resultSet.getString("sclose"));
			}
			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("BoardDAO.list() sql문 오류");
			e.printStackTrace();
		}
	}// end shopList() method
	
	public void shopList(Connection connection) {  // 현재 생성된 shop의 sno/sname/slocation 부분 출력
		try {
			String sql = "select sno, sname, slocation from shop order by sno desc";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 표형식으로 리턴된 값 유무 판단
				System.out.print("매장번호:"+ resultSet.getInt("sno") + "\t");
				System.out.print("매장이름:"+ resultSet.getString("sname") + "\t");
				System.out.println("매장위치:"+ resultSet.getString("slocation"));
			}
			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("BoardDAO.list() sql문 오류");
			e.printStackTrace();
		}
	}// end shopList() method
	
	public void shopListDetail(Connection connection) {  // 현재 생성된 shop의 전체 정보 출력
		try {
			String sql = "select * from shop where sno =? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, shopdto.getSno());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 표형식으로 리턴된 값 유무 판단
				System.out.print("매장번호:"+ resultSet.getInt("sno") + "\t");
				System.out.print("매장이름:"+ resultSet.getString("sname") + "\t");
				System.out.println("매장위치:"+ resultSet.getString("slocation"));
				System.out.print("디자이너:"+ resultSet.getString("sdesigner") + "\t");
				System.out.print("매장오픈시간:"+ resultSet.getString("sopen") + "\t");
				System.out.println("매장클로즈시간:"+ resultSet.getString("sclose"));
			}
			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("BoardDAO.list() sql문 오류");
			e.printStackTrace();
		}
	}// end shopList() method
	

	
	
	///// 임시저장소 
	public void memberGradeEdit(MemberDTO memberNo, Connection connection, Scanner scanner) {
		// 입력한 Mno와 관련된 개인정보 재확인
		try {
			String sql = "select mname, mphone from member where mno = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, memberNo.getMno());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 표형식으로 리턴된 값 유무 판단
				System.out.println("선택하신 계정의 상세내용입니다.");
				System.out.print("이름:" + resultSet.getString("mname") + "\t");
				System.out.print("휴대전화번호:" + resultSet.getString("mphone") + "\t");
			}
			System.out.print("변경후 계정등급:" + memberNo.getMgrade());
			
			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("sql문 오류");
			e.printStackTrace();
		}
		System.out.println("상세 내용은 위와 같습니다. 변경하시겠습니까?");
		System.out.print("1.변경 | 2.취소");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			int resultIEditGrade = 0;
			try {
				String sql = "update member set mgrade = ? where mno = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, memberNo.getmGrade());
				preparedStatement.setInt(2, memberNo.getmNo());
				resultIEditGrade = preparedStatement.executeUpdate();
				if (resultIEditGrade > 0) {
					System.out.println("계정 권한을 변경하였습니다.");
					connection.commit();
				} else {
					System.out.println("결과" + resultIEditGrade + "입니다.");
					System.out.println("입력 실패 : 롤백합니다.");
					connection.rollback();
				}
				preparedStatement.close();

			} catch (SQLException e) {
				System.out.println("sql 문을 확인하세요");
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("변경을 취소합니다.");
			break;
		default:
			System.out.println("명령어만 입력해 주세요.");
		}
	}// end memberGradeEdit() method
	
	
	

} //end class
