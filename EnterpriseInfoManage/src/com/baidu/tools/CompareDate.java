package com.baidu.tools;

import java.util.Date;

public class CompareDate {
	public static boolean compare_date(Date DATE1, Date DATE2) {
		Date dt1 = DATE1;
		Date dt2 = DATE2;
		if (dt1.getTime() == dt2.getTime()) {
			return true;
		}
			return false;
	}
}
