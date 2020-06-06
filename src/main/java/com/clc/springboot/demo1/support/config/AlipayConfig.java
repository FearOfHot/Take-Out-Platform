package com.clc.springboot.demo1.support.config;

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

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102200741259";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC0KOnF0h44+KkoTNCIyE13aogHsUa1+4JXoQRV8augOSM5pGXhgljsLHgvK0ZPjbe7YNxOA5droE95ciL0M181QLYyj8PoWgW8dkQSGkpBohHHNZlXIfTu7PV0mzV1fupX0hJubObCpMXGRR3m+IgUOqqMZT2rHDEKNtnxlWbL6mVAhCxRg8GBVx5QDER0rNCJb1eFz0vexZMdA6sezb0ISbgTa7fUTM7Avw9XsMNW1+utk+AkjtrI15eWILHvGohn3i4scio/zsW1nK+qvGy76fNMKdRzDkoAK/zQS31UUr9n7Opt1Oi2TA0rQjqrhh0W+QZakqDbnXYo/WeinIDVAgMBAAECggEAWEqstqwQ7669h+iNUluHy3xECjERDGKkMDnTHCOCDtWxs7Aj1e7BkY0BoWw92wMDBiukC/+ql65LBKOxCaibgkeigwj948MqiIAVQCHuPlglClH0QkV7+hPa/ziJbHm0czGaos9wD/gcjNyWmPk4B2Hw7zk2jcMVLYJQMRsc89WrDHzqby/UjNlnzQ/QypBeyKymDpgiRIrPx/4X/aSPxqByEKLOiHlZtpoiAs2ExFEX79SMpQZ6TtBwqe24q7kq7LyCTSIxMzvhvIl9/cVn2n/ldJeTRD9gkI9RWgbhzsu9j5NObcdHm3bNzdxQh/Q4K4AwAoEy5bZ5Ou5vqDXbyQKBgQDdeoNFR1FBOWbV8Hensv3G9WMR+IyOXtl5010aZhdCMiZLs+ytJ4/34D5ziH4eTKzdVkOULwsNKSnmjt+x+ui/0S89fnVe8Q6rn3FputZvZ03JzQ9u94ejyUSPPFAXd3paTgHcy/Nj5QbYJeqOGSW9v9P9+EvCzacdisnYwxqa7wKBgQDQPbDCNv1vVIAptvUW+ZB7uZwmuj7LvunRDTfu88EybAgoiNdARl003eOlgpaNPaS7ufAmxYXZWJ9dUWzhlx1v+N6tAxPoAaJU+FljDTgW/yKcVUf1IVdknerGwilv/OgcMQq+jiXlRZcSMzA/lFz1w5LvdlZRt3x30dZw1azwewKBgQCH8eJPjOYINha0LQUVL53sGMU1y61i2j99MsrMIGwYWrX887TL2CPbj45l1hsrt/7HYWLbu0B6VJD+jyYplgx1aQ4pHc0neKl7mMPBlUh4Wx15R+A4ScG9PBZUIT48GT9F3OnxwFJmN7dKx4NAs5jh7rROCLFgImF4la8t2RwkiwKBgQCNkYL7ZfsBlsbSlSkmB1/sXREFWxSZ2x6GGqBt+JTdPIiHVhBQCAYRjM/Yk2DagI/fd9cF5L7MNe2RuWt2Kg+/McfggvkjfwjnDzdlmXUKXUUgVvHmelY5dwpHOXSGR79cexK83VJx/c9odhhVAP35ro3T8fVY9I7Pvn40k29QxQKBgB03nTzzg0HAftyA+FbsIcCUr8AxnhqasutGeyisesvbpzIjFjIDs8mkRxfclfqLLy64YzSZEzoUso0DXKDrZBqliNbSuUGvs7BD71GxlXj6zmZb0ylbMHnPatsAbZoUWeZ0GQ9K2royZFWayZcOJPXjVWvpP5U4jTdoCJh8OAZG";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk9Eys0sanBB+DgZsAaYQqnQe1VnPjSKnCBTLYK1gG6IY+mt5qXsio5FJn/SUJ/sTAJXxUhsIhNCIWoHFHfTE3vOSntMkYNOUlUZhWcqMvkhHJnDumnO1Z6BujpPVGbZ7e3MU4g7Yqf95K+AjgXJ41VE9bWEVMWJ0Jcve4IyWPEgRRDHTjf5wd8+mhFGcrc0Squsq+n3oYwEQuDqf+iqTFU5e2LehG/WrLFUWCARdcZtRapEOLGLcVNUHBop2cESyo0gEARJGvzj2XPgkE+/AKPgSiaX98nklP29LOmVNXV7AyiXsCZEVN3BBSHWBdgssWOyAAdn4MWN6vyLlZ+JwwQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8082/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8082/#/dish";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "UTF-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
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

