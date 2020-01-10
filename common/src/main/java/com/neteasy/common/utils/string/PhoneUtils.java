package com.neteasy.common.utils.string;

/**
 * @author: Ivan
 * @date: 2019/10/18 15:50
 */
public class PhoneUtils {

	public static boolean isPhone(String phoneStr) {
		if (StringUtils.isNotEmpty(phoneStr)
				&& phoneStr.startsWith("1")
				&& phoneStr.length() == 11) {
			return true;
		} else {
			return false;
		}
	}

}
