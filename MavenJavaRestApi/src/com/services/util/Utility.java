package com.services.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.services.exception.APIException;

public class Utility {

	public static final String EMAIL_PATTERN = "[a-zA-Z0-9\\.\\_]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{2,3}";
	public static final String ALPHA_PATTERN = "[a-zA-Z ]+";
	public static final String ALPHA_NUMERIC_PATTERN = "[a-zA-Z0-9 ]+";
	public static final String NUMBER_PATTERN = "\\d+";
	public static final String PASSWORD_PATTERN = "^(?=.*?[0-9])(?=.*?[a-z])[0-9a-zA-Z!@#$%0-9]{6,15}$";
	public static final String DATE_FORMAT_PATTERN = "MM/dd/yyyy";

	private Utility() {

	}

	public static void logMe(Object obj) {
		System.out.println(obj);
	}

	public static boolean isStrEquals(Object s1, Object s2) {
		boolean flag = false;
		if (!isNull(s2) && !isNull(s1)) {
			flag = s2.equals(s1);
		}
		return flag;
	}

	public static String getEncrypted(Object id) {
		return id.toString();
	}

	public static String getDecrypted(Object id) {
		return id.toString();
	}

	public static String[] getSplitupArray(String stringToSplit,
			String stringToSplitOn) {
		String[] splitArray = null;
		if (stringToSplit != null) {
			splitArray = stringToSplit.split(",");
		} else {
			splitArray = new String[0];
		}
		return splitArray;
	}

	public static String[] getSplitupArrayOnComma(String stringToSplit) {
		return getSplitupArray(stringToSplit, ",");
	}

	public static boolean isNullOrEmpty(Object str) throws APIException {
		boolean retVal = false;
		if (isNull(str) || isEmpty(str)) {
			retVal = true;
		}
		if (retVal) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return retVal;
	}

	public static boolean isIntNullOrEmpty(Integer str) throws APIException {
		boolean retVal = false;
		if (isNull(str) || isEmpty(str)) {
			retVal = true;
		}
		if (retVal) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return retVal;
	}

	public static boolean isListNullOrEmpty(List<?> list) throws APIException {
		boolean retVal = false;
		if (list == null || list.isEmpty() || list.size() == 0) {
			retVal = true;
		}
		if (retVal) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return retVal;
	}

	public static boolean isArrayNullOrEmpty(String[] str) throws APIException {
		boolean retVal = false;
		if (str == null || str.length == 0) {
			retVal = true;
		}
		if (retVal) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return retVal;
	}

	public static boolean isNull(Object o) {
		return o == null;
	}

	public static boolean isNotNull(Object obj) throws APIException {
		boolean notNull = false;
		if (obj != null) {
			notNull = true;
		}
		if (!notNull) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.NO_RECORD_MESSAGE);
		}
		return notNull;
	}

	public static boolean isLoginSuccess(Object obj) throws APIException {
		boolean notNull = false;
		if (obj != null) {
			notNull = true;
		}
		if (!notNull) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.INVALID_EMAIL_PASSWORD_MESSAGE);
		}
		return notNull;
	}

	public static boolean isEmpty(Object obj) {
		String str = obj.toString();
		return str.trim().isEmpty();
	}

	public static boolean isZero(int num) {
		return num == 0;
	}

	public static int getRandomIndex() {
		Random random = new Random();
		// 0-4
		int index = random.nextInt(10);
		return index;
	}

	public static int getRandomIndex(int size) {
		Random random = new Random();
		// 0-4
		int index = random.nextInt(size);
		return index;
	}

	public static boolean isZero(long num) {
		return num == 0;
	}

	public static boolean isGreaterThanZero(long num) throws APIException {
		boolean isGreater = false;
		if (num > 0) {
			isGreater = true;
		}
		if (!isGreater) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return isGreater;
	}

	public static boolean isGreaterThanZero(int num) throws APIException {
		boolean isGreater = false;
		if (num > 0) {
			isGreater = true;
		}
		if (!isGreater) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return isGreater;
	}

	public static boolean isDeletedIdGreaterThanZero(int num)
			throws APIException {
		boolean isGreater = false;
		if (num > 0) {
			isGreater = true;
		}
		if (!isGreater) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.NO_RECORD_MESSAGE);
		}
		return isGreater;
	}

	public static boolean isIdGreaterThanZero(int num) throws APIException {
		boolean isGreater = false;
		if (num > 0) {
			isGreater = true;
		}
		if (!isGreater) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.NO_RECORD_MESSAGE);
		}
		return isGreater;
	}

	public static boolean isIdGreaterThanZero(long num) throws APIException {
		boolean isGreater = false;
		if (num > 0) {
			isGreater = true;
		}
		if (!isGreater) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.NO_RECORD_MESSAGE);
		}
		return isGreater;
	}

	public static boolean isUpdateIdGreaterThanZero(int num)
			throws APIException {
		boolean isGreater = false;
		if (num > 0) {
			isGreater = true;
		}
		if (!isGreater) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.UPDATE_FAIL);
		}
		return isGreater;
	}

	public static boolean isUpdateIdGreaterThanZero(long num)
			throws APIException {
		boolean isGreater = false;
		if (num > 0) {
			isGreater = true;
		}
		if (!isGreater) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.UPDATE_FAIL);
		}
		return isGreater;
	}

	public static boolean isGreaterThanZero(double num) throws APIException {
		boolean isGreater = false;
		if (num > 0) {
			isGreater = true;
		}
		if (!isGreater) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return isGreater;
	}

	public static boolean isZero(double num) {
		return num == 0;
	}

	public static String presentableBooleanValue(Boolean val) {
		if (val) {
			return "Yes";
		}
		return "No";
	}

	public static int booleanToInt(Boolean val) {
		if (val) {
			return 1;
		}
		return 0;
	}

	public static boolean intToBoolean(int val) {
		if (val == 1) {
			return true;
		}
		return false;
	}

	public static String getTime() {
		Date date = new Date();
		return Long.toString(date.getTime());
	}

	public static String getDateInString(Date date) {
		return simpleDateFormat().format(date);
	}

	public static Date getStringInDate(String dateStr) {
		Date dt = null;
		try {
			dt = simpleDateFormat().parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}

	private static SimpleDateFormat simpleDateFormat() {
		return new SimpleDateFormat(DATE_FORMAT_PATTERN);
	}

	public static boolean isDeveloperKey(String passedString)
			throws APIException {
		return isAlphaNumeric(passedString);
	}

	public static boolean isNullOrEmpty(String passedString)
			throws APIException {
		boolean nullOrEmpty = false;
		if (passedString == null || passedString.equals("")) {
			nullOrEmpty = true;
		}
		if (nullOrEmpty) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return nullOrEmpty;
	}

	public static boolean isUniqueEmail(String passedString)
			throws APIException {
		boolean nullOrEmpty = false;
		if (passedString == null || passedString.equals("")) {
			nullOrEmpty = true;
		}
		if (!nullOrEmpty) {
			throw new APIException(StatusConstants.INVALID_EMAIL,
					StatusConstants.UNIQUE_EMAIL_ID);
		}
		return nullOrEmpty;
	}

	public static boolean isUniqueMobileNumber(String passedString)
			throws APIException {
		boolean nullOrEmpty = false;
		if (passedString == null || passedString.equals("")) {
			nullOrEmpty = true;
		}
		if (!nullOrEmpty) {
			throw new APIException(StatusConstants.EXISTING_MOBILE_NUMBER,
					StatusConstants.EXISTING_MOBILE_NUMBER_MESSAGE);
		}
		return nullOrEmpty;
	}

	public static boolean isTokenExists(String passedString)
			throws APIException {
		boolean nullOrEmpty = true;
		if (passedString == null || passedString.equals("")) {
			nullOrEmpty = false;
		}
		if (!nullOrEmpty) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.NOT_ALIVE);
		}
		return nullOrEmpty;
	}

	public static boolean isNullOrEmptyRegisterationId(String passedString) {
		boolean nullOrEmpty = false;
		if (passedString == null || passedString.equals("")) {
			nullOrEmpty = true;
		}
		return nullOrEmpty;
	}

	public static boolean isNotEmpty(String passedString) {
		boolean nullOrEmpty = false;
		if (passedString == null || passedString.equals("")) {
			nullOrEmpty = true;
		}
		return nullOrEmpty;
	}

	public static boolean isNotEmptyPassword(String passedString) {
		boolean nullOrEmpty = true;
		if (passedString == null || passedString.equals("")) {
			nullOrEmpty = false;
		}
		return nullOrEmpty;
	}

	public static boolean isValidEmail(String emailString) throws APIException {
		boolean validEmail = false;
		if (isNullOrEmpty(emailString)) {
			throw new APIException(StatusConstants.INVALID_EMAIL_CODE,
					StatusConstants.INVALID_EMAIL_MESSAGE);
		}
		if (isPatternMatching(emailString, EMAIL_PATTERN)) {
			validEmail = true;
		}
		if (!validEmail) {
			throw new APIException(StatusConstants.INVALID_EMAIL_CODE,
					StatusConstants.INVALID_EMAIL_MESSAGE);
		}
		return validEmail;
	}

	public static boolean isAlphabet(String passedString) throws APIException {
		boolean isAlpha = false;
		if (isPatternMatching(passedString, ALPHA_PATTERN)) {
			isAlpha = true;
		}
		if (!isAlpha) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return isAlpha;
	}

	public static boolean isStringAlpaNumeric(String passedString)
			throws APIException {
		boolean isAlphaNumeric = false;
		if (isPatternMatching(passedString, ALPHA_NUMERIC_PATTERN)) {
			isAlphaNumeric = true;
		}
		if (!isAlphaNumeric) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return isAlphaNumeric;
	}

	public static boolean isNumeric(String passedString) throws APIException {
		boolean isNumber = false;
		if (isPatternMatching(passedString, NUMBER_PATTERN)) {
			isNumber = true;
		}
		if (!isNumber) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}
		return isNumber;
	}

	public static boolean isValidMobileNumber(String passedString)
			throws APIException {
		boolean isNumber = false;
		if (isNullOrEmpty(passedString)) {
			throw new APIException(StatusConstants.INVALID_MOBILE_NUMBER,
					StatusConstants.INVALID_MOBILE_NUMBER_MESSAGE);
		}
		if (isPatternMatching(passedString, NUMBER_PATTERN)
				&& passedString.length() == Constant.MOBILE_NUMBER_LENGTH) {
			isNumber = true;
		}
		if (!isNumber) {
			throw new APIException(StatusConstants.INVALID_MOBILE_NUMBER,
					StatusConstants.INVALID_MOBILE_NUMBER_MESSAGE);
		}
		return isNumber;
	}

	public static boolean isValidPassword(String passedString)
			throws APIException {
		boolean validPassword = false;
		if (isPatternMatching(passedString, PASSWORD_PATTERN)) {
			validPassword = true;
		}
		return validPassword;
	}

	private static boolean isPatternMatching(String str, String pattern)
			throws APIException {
		boolean isMatching = false;
		if (!isNullOrEmpty(str)) {
			if (str.matches(pattern)) {
				isMatching = true;
			}
		}
		return isMatching;
	}

	public static boolean isAlphaNumeric(String passedString)
			throws APIException {
		boolean isAlphaNum = false;
		if (isNumeric(passedString) || isAlphabet(passedString)) {
			isAlphaNum = true;
		}
		if (!isAlphaNum) {
			throw new APIException(StatusConstants.FAILED_CALL,
					StatusConstants.VALIDATION_MESSAGE);
		}

		return isAlphaNum;
	}

	public static boolean isFutureDate(long checkDate) {
		long currentTimeInMili = getCurrentTimeInMillis();
		return currentTimeInMili <= checkDate;
	}

	public static long getCurrentTimeInMillis() {
		return System.currentTimeMillis();
	}

	public static void logMe(String str) {
		System.out.println(str);
	}
}