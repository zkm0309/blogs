package com.angel.blogs.utils;
import java.io.InputStream;
import java.util.Properties;

public class OperateProperties {
    private static  Properties props = new Properties();  
    static{
    	InputStream in = OperateProperties.class.getClassLoader()
				.getResourceAsStream("constant.properties");  
        try {
			props.load(in);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("读取文件失败！原因："+e.getMessage());
		}
    }
	private OperateProperties() {}
	public static Properties getInstance() {
		return props;
	}
	/**
	 * 根据属性文件中的键读取对应的值
	 * @param key
	 * @return value
	 */
	public static String readValueByKey(String key) {
		Properties properties = getInstance();
		return properties.getProperty(key);
	}
	/**
	 * 根据属性文件中的键写入对应的值
	 * @param key
	 * @param values
	 */
	public static void writeValueByKey(String key,String values){
		Properties properties = getInstance();
		properties.setProperty(key, values);
	}
}
