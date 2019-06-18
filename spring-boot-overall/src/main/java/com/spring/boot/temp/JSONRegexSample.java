package com.spring.boot.temp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName JSONRegexSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/3 20:19
 * @Version 1.0
 */
public class JSONRegexSample {

    public static void main(String[] args) {


        String s = "{\"msgContent\":\"[{\\\"waybillNoInfos\\\":[{\\\"success\\\":true,\\\"waybillNo\\\":\\\"40\\\"},{\\\"success\\\":true,\\\"waybillNo\\\":\\\"77\\\"},{\\\"success\\\":true,\\\"waybillNo\\\":\\\"88\\\"},{\\\"success\\\":true,\\\"waybillNo\\\":\\\"99\\\"}],\\\"cityCode\\\":\\\"755\\\",\\\"employeeId\\\":\\\"967360\\\",\\\"taskCode\\\":\\\"\\\",\\\"unitAreaCodes\\\":[\\\"755A038\\\"],\\\"handoverCodes\\\":[\\\"JSWZUN57\\\"],\\\"uploadTime\\\":\\\"2019-05-09 16:00:09\\\"}]\",\"msgType\":10,\"systemCode\":\"SGS-EXP\"}";
        System.out.println(s);

        String s1 = s.replaceAll("\\\\", "");
        System.out.println(s.replaceAll("\\\\", ""));

        String key = "waybillNo";
        String waybillNo = "40";
//        String regex = key + "\":\".*?\"";
        String regex = key + "\":\".*?\"";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s1);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
