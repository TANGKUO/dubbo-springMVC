package com.tangkuo.cn.online.util;


public class StringParam
{

    public static String getString2(String str, String name){

    	int	start = -1;
    	
    	if( str.substring(0, name.length() + 1).equals( name + "=" ) )
    	{
    		start = 0;
    	}
    	else
    	{
	        start = str.indexOf( "&" + name + "=");
	        if (start == -1)
	        {
	            return null;
	        }
	        start += 1;
    	}

        int end = str.indexOf('&', start);
        if (end == -1)
        {
            end = str.length();
        }

        String value = str.substring(start + name.length() + 1, end);
       return value;
    
    }
    
    
    /**
     * @param str
     * @param name
     * @return
     */
    public static String parserPara (String str, String name) {
    	if (str ==null || name == null || str.length() <= name.length()) {
    		return null ;
    	}
    	return getString(str, name);
    }
    
    
    public static String getString(String str, String name)
    {
    	int	start = -1;
    	
    	if( str.substring(0, name.length() + 1).equals( name + "=" ) )
    	{
    		start = 0;
    	}
    	else
    	{
	        start = str.indexOf( "&" + name + "=");
	        if (start == -1)
	        {
	            return null;
	        }
	        start += 1;
    	}

        int end = str.indexOf('&', start);
        if (end == -1)
        {
            end = str.length();
        }

        String value = str.substring(start + name.length() + 1, end);
//        System.out.println(value);
//        String tmp = decode(value); // unescape the value string
        return value;
    }
    
   
    
}