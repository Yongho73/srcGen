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
		param.setProgrmId("MHSHRB000"); // ���α׷��������� ���α׷� ID ��Ű��, ������Ű��, �������̺��� �ݵ�� �ԷµǾ�� �մϴ�.�����ϼ���!~~~
		//param.setProgrmId("MHSHRD034"); 
		param.setGenType("type05"); // �ҽ���������-> type02:�׸���crud, type03:�׸��� ����¡ crud, type04:�׸��� ���ֱ���, type05:�׸���crud+Form(new), type06:Only �׸���crud(new)
		param.setMultiDeleteGubun(false); //�׸��� ���࿡ üũ�ڽ� �÷� ���� : üũ�ڽ��� ������ ������ �����ؼ� ���� ����, false = üũ�ڽ� �÷� ����,  true = üũ�ڽ� �÷� ����
		
		//param.setOverWrite(false); // �ҽ� ����� �ɼ�  true-> ������ ���(�۾��� ���� ����� �� ���� ���� ���), false-> ������ ��ŵ��
		param.setOverWrite(true); // �ҽ� ����� �ɼ�  true-> ������ ���(�۾��� ���� ����� �� ���� ���� ���), false-> ������ ��ŵ��
		
		
		// �Ʒ�  gun.trigger????(param, boolean, boolean);
		// 1�� ���� : VO ����ü . �����ϸ� �ȵ�   
		// 2�� ���� : �� �۾��� ó������ �ƴ����� ����,  �� �۾��� ó���̸� true, �� �۾��� ó���� �ƴϸ� false,  true�̸� �ҽ� ��ü ����, false�̸� sql�� xml�� ����  
		// 3�� ���� : �� �۾��� ���������� �ƴ����� ����,  �� �۾��� �������̸� true, �� �۾��� �������� �ƴϸ� false , true�̸� session �� ���α׷� ����
		
		//Oracle�� �ҽ� ����
		//gun.triggerOracle(param, true, false); 
		
		//Mssql�� �ҽ� ����
        //gun.triggerMssql(param, true, true);
        
        //Mysql�� �ҽ� ���� 
        gun.triggerMysql(param, true, true);
    }

}
