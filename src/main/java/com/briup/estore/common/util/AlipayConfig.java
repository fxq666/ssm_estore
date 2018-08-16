package com.briup.estore.common.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓


	//沙箱APPID
	public static final  String app_id = "2016091800542288";
	//沙箱私钥
	public static final  String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDjlb9sQnGIzxVqv2ngvysfeuRS5/Wj+c/QTe+EnRKmhM2EiAXPDBEXLkSCELoJdgzADlYM80arq+OhpbUdqjDbSoEXAcLE5VCCnnOofzTBxUkaBVs4dVo+s8VfWE7H5Ugdb4J9dxQy05OOV055HQGkPUoy4NnvoJ5/8ZiS1ybBSKqnZfEAFXlh5WYV/bZvfuB4A9IKULRKH41DqPZIAxl/ujPqBd8ZIVWIoHXu99IJUA13LgHXW9iySdqeyamYZ+UNa6jdNbVM5RpeDLOUNmZ43F7BU/SXRVZBjHCxviJcoo3KRJqLvtwc3eM92Us+Jvxma82YVgjQSxwxhHE0iIrAgMBAAECggEAPdk+hpij6rYIGJKCHC3V0taEWFPAeqQ+6JsltMOCTsxu+b29vo66dnlNPPALXI7mPNv/GbuI0uGLgas+3/ZFU1NQLKqDWS7Evj6kk4POk/vBcdNJN15Y8bjwgL7oZl5rws34IUCoaoeaceZAMQZ5kdi2mY5MYgrL1sVsJCwgBnTIEiQMt6CvjSrXibnhzihcLXHxCsRI0vffL3bDPOUUmIHsnMilA9xqtqTsQ2Owzk+mQ4X3KOXxAgxFlQcroRHEClUGO+qZ9D+Tk2FINxuBZo/uUJeEjAWX/t9uwe4B/p7gUtJNMz5VzCxrcySTWOdVdDSkWpvBvMZ5w8UM5R1GQQKBgQD4gzRTOLYJxsjAyjD/CM9/ag+AhDO57rC6Hv1mv6dpl6Cb74oTcOkbPuK+C2yj7o5ocKULguXfs60LpPcxu5kaA8nKLBiYdJUzEFRdWiVuXRtJ74y/7Oxk58Qz8Qx/eItJr0g9bHpHuFx/+kDdo+mdYnx0NNFtoJa8rXLtvpUfiwKBgQCHhQqKjDnLc9TvVq+ZvHUf8U+isTQgsPEr9YOit87ReKjae8EK+nqWSu6uSMIGBCnaQvWybRO/12m/jPGEspJOcXqvgcfkfJK3XmaMQk+wx+Z7eaRObWcmkmoRSJhMvfmdZDyo6KOJLrpnGs0kRoIkV7X5Lq13oS6S8KifpgFb4QKBgQCvdPs5kr2781SEAX1MYy0VOY3OYAihSuwNzJl+tOv/OmXUEvC6vypl6SVvpmNC7sgu5vEwSnAAXDxeD0/UFi6HVotfKXkIEq/QiMP30RDCdgwxTGdkjmNs7tHxFkyLp1E4agAoFfHTt0/fr5Giqvri+skBxtTigNJMTm3pe3iP9wKBgArQlSzFT/9qeP24nz7XiUlJSp+jIJPTSwvFBgJAROL2jBMTeS5VGt9Pj4idCc7NGkHuwgjBJ6hRmoDM0KFUVtSnvbCv3LHhNxwnDmv3BsEG0t/brz8LAAZV/NzwPCczqe3jh+u61QInlnyP6PsSHWSlE0KVdQZs+HiFeA91gfpBAoGBAMU8djwJck0bS80+FEOEgRxeIB3JNY1QgQXVGc15DPFCjjv336G3FHqXDC3K8/C7ZYk35XXnWmDxNgSjyZI+0gnwnmcUjZpCuFKN9utAncaCtp+T153WaA9oCMg81yuYjlCak0Ixggq+Qggn4QbDoL4QtYt6ipwjrzRzkrAIpzcV";
	//支付宝公钥
	public static final  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg45W/bEJxiM8Var9p4L8rH3rkUuf1o/nP0E3vhJ0SpoTNhIgFzwwRFy5EghC6CXYMwA5WDPNGq6vjoaW1Haow20qBFwHCxOVQgp5zqH80wcVJGgVbOHVaPrPFX1hOx+VIHW+CfXcUMtOTjldOeR0BpD1KMuDZ76Cef/GYktcmwUiqp2XxABV5YeVmFf22b37geAPSClC0Sh+NQ6j2SAMZf7oz6gXfGSFViKB17vfSCVANdy4B11vYsknansmpmGflDWuo3TW1TOUaXgyzlDZmeNxewVP0l0VWQYxwsb4iXKKNykSai77cHN3jPdlLPib8ZmvNmFYI0EscMYRxNIiKwIDAQAB";
	//沙箱网关地址
	public static final  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

//	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://192.168.213.1:8088/estore_ssm/login";

//	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://192.168.213.1:8088/estore_ssm/index";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";

	
	// 支付宝网关
	public static String log_path = "https://openapi.alipaydev.com/gateway.do";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

