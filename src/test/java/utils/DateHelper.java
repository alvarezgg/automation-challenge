package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class DateHelper {

	static SimpleDateFormat dateTimeFormat;
	
	/*
	 * Devuelve una fecha actual como String con el formato indicado
	 * para ver el formato admitido: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	 * */
	public static String getFechaActual(String format) {
		dateTimeFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		return dateTimeFormat.format(cal.getTime());
	}
	/*
	 * Devuelve una fecha diferida como String con el formato indicado
	 * El parametro dias sirve como offset en dias: 
	 * Ejemplo dias=10, retornara una fecha adelantada 10 dias
	 *         dias=-10, retornara una fecha atrasada 10 dias
	 * para ver el formato admitido: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	 * */
	public static String getFechaDiferida(String format, int dias) {
		dateTimeFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, dias);
		return dateTimeFormat.format(cal.getTime());
	}
	public static String getFechaActualDateTime() {
		return DateHelper.getFechaActual("yyyy-MM-dd'T'HH:mm:ss");
	}
	public static String getFechaDiferidaDateTime(int dias) {
		return DateHelper.getFechaDiferida("yyyy-MM-dd'T'HH:mm:ss", dias);
	}
}
