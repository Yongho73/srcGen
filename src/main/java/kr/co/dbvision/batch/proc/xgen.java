package kr.co.dbvision.batch.proc;

import java.io.IOException;
import java.sql.SQLException;

import kr.co.dbvision.batch.proc.bulet.logic.ProcessBuletMain;
import kr.co.dbvision.batch.proc.bulet.dao.Dao;
import kr.co.dbvision.batch.proc.bulet.entity.Bulet;

public class xgen {

    public static void main(String[] args) throws IOException, SQLException {
    	ProcessBuletMain gun = new ProcessBuletMain();

		Bulet param = Bulet.getInstance();
		param.setProgrmId("MHSHRB000"); // 프로그램관리에서 프로그램 ID 패키지, 서비패키지, 관련테이블이 반드시 입력되어야 합니다.주의하세요!~~~
		//param.setProgrmId("MHSHRD034"); 
		param.setGenType("type05"); // 소스생성형식-> type02:그리드crud, type03:그리드 페이징 crud, type04:그리드 멍텅구리, type05:그리드crud+Form(new), type06:Only 그리드crud(new)
		param.setMultiDeleteGubun(false); //그리드 좌축에 체크박스 컬럼 여부 : 체크박스가 있으면 여러개 선택해서 삭제 가능, false = 체크박스 컬럼 없음,  true = 체크박스 컬럼 있음
		
		//param.setOverWrite(false); // 소스 덥어쓰기 옵션  true-> 무조건 덥어씀(작업된 내용 사라질 수 있음 주의 요망), false-> 있으면 스킵함
		param.setOverWrite(true); // 소스 덥어쓰기 옵션  true-> 무조건 덥어씀(작업된 내용 사라질 수 있음 주의 요망), false-> 있으면 스킵함
		
		
		// 아래  gun.trigger????(param, boolean, boolean);
		// 1번 변수 : VO 구조체 . 수정하면 안됨   
		// 2번 변수 : 이 작업이 처음인지 아닌지를 구분,  이 작업이 처음이면 true, 이 작업이 처음이 아니면 false,  true이면 소스 전체 생성, false이면 sql용 xml만 생성  
		// 3번 변수 : 이 작업이 마지막인지 아닌지를 구분,  이 작업이 마지막이면 true, 이 작업이 마지막이 아니면 false , true이면 session 및 프로그램 종료
		
		//Oracle용 소스 생성
		//gun.triggerOracle(param, true, false); 
		
		//Mssql용 소스 생성
        //gun.triggerMssql(param, true, true);
        
        //Mysql용 소스 생성 
        gun.triggerMysql(param, true, true);
    }

}
