package test;

import dao.DanhMucDAOImpl;
import model.*;
import connect.*;


public class Main {
	public static void main(String[] args) {
		DanhMucDAOImpl dm=new DanhMucDAOImpl();
		System.out.println(dm.getListDanhMucCon("100001").size());
	
}
}
