package group3TeamProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import group3TeamProject.dto.CutDTO;

public class CutDAO {

	public void insertCut(CutDTO cutdto, Connection connection) { // 헤어스타일 추가하는 sql
		int resultInsertHair = 0;
		try {
			String sql = "insert into cut(csname, csno, ccode, ccutname, cprice, ccontents)"
					+ " values(?, ?, sCode_seq.nextval, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cutdto.getScname());
			preparedStatement.setInt(2, cutdto.getCsno());
			preparedStatement.setString(3, cutdto.getCcutname());
			preparedStatement.setInt(4, cutdto.getCprice());
			preparedStatement.setString(5, cutdto.getCcontents());
			resultInsertHair = preparedStatement.executeUpdate();
			if (resultInsertHair > 0) {
				System.out.println(resultInsertHair + "행의 데이터를 추가했습니다.");
				connection.commit();
			} else {
				System.out.println("결과" + resultInsertHair + "입니다.");
				System.out.println("입력 실패 : 롤백합니다.");
				connection.rollback();
			}
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("관리자 : sql 문을 확인하세요");
			e.printStackTrace();
		}
	}// end insertCut() method

	public void cutEditString(CutDTO cutdto, String updateCut, String inputSt, // 매장이름 / 매커트이름 / 커트내용 수정 메서드
			Connection connection) { 
		int resultEditSt = 0;
		try {
			String sql = "update cut set" + updateCut + "= ? where ccode = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, inputSt);
			preparedStatement.setInt(2, cutdto.getCcode());
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

	public void cutEditInt(CutDTO cutdto, String updateCut, int inputIn, // 매장번호 / 커트가격 수정 메서드
			Connection connection) { 
		int resultEditIn = 0;
		try {
			String sql = "update cut set" + updateCut + "= ? where ccode = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, inputIn);
			preparedStatement.setInt(2, cutdto.getCcode());
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
	
	public void cutDelete(CutDTO cutDel, Connection connection) { // 헤어스타일 삭제 메서드
		int resultIEditHair7 = 0;
		try {
			String sql = "delete from cut where ccode = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cutDel.getCcode());
			resultIEditHair7 = preparedStatement.executeUpdate();
			if (resultIEditHair7 > 0) {
				System.out.println(resultIEditHair7 + "행의 데이터를 삭제했습니다.");
				connection.commit();
			} else {
				System.out.println("결과" + resultIEditHair7 + "입니다.");
				System.out.println("입력 실패 : 롤백합니다.");
				connection.rollback();
			}
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("관리자 : sql 문을 확인하세요");
			e.printStackTrace();
		}
	}// end shopDesignerEdit() method
	
	public void CutDetail(Connection connection) {  //csno를 입력받고 해당하는 시술의 디테일을 보여주는 메서드
		try {
			String sql = "select * from cut where csno =? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, shopdto.getCsno());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 표형식으로 리턴된 값 유무 판단
				System.out.print("매장이름:"+ resultSet.getString("csname") + "\t");
				System.out.print("매장번호:"+ resultSet.getInt("csno") + "\t");
				System.out.println("헤어코드:"+ resultSet.getInt("ccode"));
				System.out.print("헤어이름:"+ resultSet.getString("ccutname") + "\t");
				System.out.print("헤어가격:"+ resultSet.getInt("cprice") + "\t");
				System.out.println("헤어설명:"+ resultSet.getString("ccontents"));
			}
			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("BoardDAO.list() sql문 오류");
			e.printStackTrace();
		}
	}// end shopList() method
	
}
