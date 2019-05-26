package com.example.demo.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* <p> 空判断工具类 </p>
	 *
	 * @author lijinghao
	 * @version v 0.1
	 * @date 2018-06-14 18:56:33
	 */
public class EmptyUtil {

    public static final String EMPTY = "";

    /**
     * 判断对象是否为空
     * 对于Collection,Array,Map,String 会进行长度的空判断
     *
     * @param obj 对象
     * @return {@code true}: 为空<br>{@code false}: 不为空
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String && obj.toString().length() == 0) {
            return true;
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        }
        if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * 判断字符串是否为空
     * 当字符串为 null, 空串或纯空格时,返回true
     *
     * @param str 字符串
     * @return {@code true}: 为空<br>{@code false}: 不为空
     */
    public static boolean isEmptyStrTrim(String str ) {
        if (str == null) {
            return true;
        }

        if(str.trim().length() == 0){
            return true;
        }

        return false;
    }

    /**
     * 判断字符串是否为空
     * 当字符串不为 null, 空串或纯空格时,返回true
     *
     * @param str 字符串
     * @return {@code true}: 为空<br>{@code false}: 不为空
     */
    public static boolean isNotEmptyStrTrim(String str ) {
        return !isEmptyStrTrim(str);
    }

    /**
     * 判断对象是否非空
     *
     * @param obj 对象
     * @return {@code true}: 非空<br>{@code false}: 空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断对象是否非Null
     *
     * @param obj 对象
     * @return {@code true}: 非空<br>{@code false}: 空
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }
    /**
     * 判断对象是否Null
     *
     * @param obj 对象
     * @return {@code true}: 空<br>{@code false}: 非空
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }


}

