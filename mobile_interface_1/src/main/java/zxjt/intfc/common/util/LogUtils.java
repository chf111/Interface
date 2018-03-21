package zxjt.intfc.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
	/** 
     * 记录日志信息 
     */  
    public static final Logger log = LoggerFactory.getLogger(LogUtils.class);  
  
    /** 
     * 记录info信息 
     *  
     * @param message 
     */  
    public static void logInfo(String message) {  
        StringBuilder s = new StringBuilder();  
        s.append((message));  
        log.info(s.toString());  
    }  
}
