package com.neteasy.common.utils.sms;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/
public class SmsUtils {
	
	private static final String ACCESS_KEY_ID = "LTAI4FcDJrkzHzWGvSvJty6x";
	
	private static final String ACCESS_KEY_SECRET = "0CECQeWoTqwgS0jdnz5fmgNmydOsGv";
	
//    public static void main(String[] args) {
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//        request.putQueryParameter("RegionId", "cn-hangzhou");
//        request.putQueryParameter("PhoneNumbers", "13427292272");
//        request.putQueryParameter("SignName", "中商国际");
//        request.putQueryParameter("TemplateCode", "SMS_174185514");
//        request.putQueryParameter("TemplateParam", "55886");
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            System.out.println(response.getData());
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
//    }
    private static final Logger log = LoggerFactory.getLogger(SmsUtils.class);
    
    
    /**
     * 发送注册验证码
     * @param phone 电话
     * @param code 验证码
     */
    public static void sendValiCode(SmsType smsType,String phone,String code) {
    	DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "KRIBB");
        request.putQueryParameter("TemplateCode", smsType.getCode());
        Map<String,String> param = new HashMap<String,String>();
        param.put("code", code);
        request.putQueryParameter("TemplateParam", JSON.toJSONString(param));
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info("======发送短信响应======"+response.getData());
        } catch (ServerException e) {
            log.error(e.getErrMsg());
        } catch (ClientException e) {
            log.error(e.getErrMsg());
        }
    }
    
    public static void main(String[] args) {
    	sendValiCode(SmsType.LOGIN_ERR,"13427292272", "555888");
	}
    
}