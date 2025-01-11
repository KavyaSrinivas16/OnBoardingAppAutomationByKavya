package com.onboarding.fintech.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * get the random number , in the range of 0-5000
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ranDom = new Random();
		int ranDomNumber = ranDom.nextInt(2000);
		return ranDomNumber;
	}
	
	 // Method for generating random alphabetic names
    public String getRandomAlphabeticName(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomName = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            randomName.append(alphabet.charAt(index));
        }

        return randomName.toString();
    }

	/**
	 * get the system date based on YYYY-DD-MM format
	 * 
	 * @return
	 */
	public String getSystemDateYYYYDDMM() {

		Date dateObj = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}

	/**
	 * get the TAT date based on YYYY-DD-MM format
	 * 
	 * @return
	 */
	public String getRequriedDateYYYYDDMM(int days) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}

}
