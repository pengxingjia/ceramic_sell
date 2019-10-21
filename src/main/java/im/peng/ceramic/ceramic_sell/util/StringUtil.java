package im.peng.ceramic.ceramic_sell.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

/**
 * 字符串处理公共类
 *
 * @author qiaofeng
 */
@UtilityClass
public class StringUtil {

    /**
     * 判断null和空字符串
     */
    public static boolean isNotEmpty(String str) {
        return !(str == null || "".equals(str));
    }

    public static boolean isEmpty(String str) {
        return !(str != null && !"".equals(str.trim()));
    }


    /**
     * 判断字符串是否相等
     */
    public static boolean equals(String str1, String str2) {
        return str1.equals(str2);
    }

    /**
     * 判断数组是否为空数组 为空返回true
     */
    public static Boolean isEmptyList(List list) {
        if (list != null) {
            if (!list.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断数组是否为空数组 为空返回true
     */
    public static Boolean isNotEmptyList(List list) {
        if (list != null) {
            if (!list.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将字符串数组转为int数组
     * @param str 字符串数组 [1,2,3]
     * @return z
     */
    public static Integer[] stringToIn(String str){
        str = str.replace("[","").replace("]","");
        String[] strArr = str.split(","); //然后使用split方法将字符串拆解到字符串数组中
        Integer[] intArr = new Integer[strArr.length]; //定义一个长度与上述的字符串数组长度相通的整型数组
        if (StringUtil.isEmpty(str)){
            return new Integer[0];
        }
        for(int a=0;a<strArr.length;a++){
            intArr[a] = Integer.valueOf(strArr[a]); //然后遍历字符串数组，使用包装类Integer的valueOf方法将字符串转为整型
        }
        return intArr;
    }

    /**
     * 获取32位随机字符
     */
    public static String getUuid(int num) {
        return getLowerUUID().substring(0, num);
    }

    /**
     * 获取32位随机字符
     */
    public static String getUuid() {
        return StringUtil.getLowerUUID().substring(0, 32);
    }


    public static String getUpperUUID() {
        String uuid = UUID.randomUUID().toString().toUpperCase();
        return uuid.replaceAll("-", "");
    }

    public static String getLowerUUID() {
        String uuid = UUID.randomUUID().toString().toLowerCase();
        return uuid.replaceAll("-", "");
    }

    /**
     * 获取静态文件物理地址
     */
    public static String getRealPath(HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/") + "/static/";
        realPath = realPath.replaceAll("\\\\", "/");
        return realPath;
    }
}
