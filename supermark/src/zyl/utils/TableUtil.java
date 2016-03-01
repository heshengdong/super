package zyl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TableUtil {
	private static String FLAG = "ZYL";
	
	private static String FALGSAHNGPING = "XSP";
	
	private static int count = 0;
	

	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String dateString = format.format(date);
		return dateString;
	}
	
	public static String getCode() {
		return FLAG + getDate() + count + getUUID();
	}
	
	public static String getStockCode() {
		return "STOC" + getDate() + count + getUUID();
	}
	
	public static String getTuiHuoStock() {
		return "TUIHUO" + getDate() + count + getUUID();
	}
	
	public static String getSellStock() {
		return "SELL" + getDate() + count + getUUID();
	}
	
	public static String getShangPingCode() {
		count  ++;
		return FALGSAHNGPING + getDate() + count + getUUID();
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString().substring(0, 4);
	}
}
