import com.neteasy.common.utils.date.DateStyle;
import com.neteasy.common.utils.date.DateUtils;
import com.neteasy.common.utils.md5.MD5;

import java.util.Date;

public class Md5Test {

    public static void main(String[] args) {
        System.out.println(MD5.md5("123456"));
        System.out.println(DateUtils.dateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));
    }

}
