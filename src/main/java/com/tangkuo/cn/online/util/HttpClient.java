package com.tangkuo.cn.online.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangkuo.cn.online.base.BaseController;
/**
 * 
 * @ClassName: HttpClient
 * @Description: (HttpClient发送请求)
 * @see 
 */
public class HttpClient
{
	protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    
    private static int conn_timeout = 30000;
    
    private static int read_timeout = 30000;
    
    public static String sendPost(String url, String reqMsg) throws Exception
    {
        logger.info(String.format("通知回调交易系统请求报文:[%s]", reqMsg));
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setConnectTimeout(conn_timeout);
            conn.setReadTimeout(read_timeout);
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("content-type", "application/json");
            // conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(reqMsg);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException e)
            {
            	logger.error(e.getMessage(), e);
            }
        }
        logger.info(String.format("通知回调交易系统响应报文:[%s]", result));
        return result;
    }
    
}
