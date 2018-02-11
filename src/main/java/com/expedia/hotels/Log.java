package com.expedia.hotels;

import org.apache.log4j.Logger;

/**
 * This is wrapper for Logger class
 * 
 * @author Tariq
 */
public class Log extends Logger {
	public static Logger log = null;

	protected Log(String name) {
		super(name);
	}
	
	/**
	 * To log debug messages in the Log file
	 * 
	 * @param className : The class that log the message
	 * @param message : The message that will printed in the log file
	 * @author Tariq
	 */
	public static void debug(Object className,String message){
		log = Logger.getLogger(className.getClass());
		log.debug(message);
	}
	
	/**
	 * To log info messages in the Log file
	 * 
	 * @param className : The class that log the message
	 * @param message : The message that will printed in the log file
	 * @author Tariq
	 */
	public static void info(Object className,String message){
		log = Logger.getLogger(className.getClass());
		log.info(message);
	}
	
	/**
	 * To log error messages in the Log file
	 * 
	 * @param className : The class that log the message
	 * @param message : The message that will printed in the log file
	 * @author Tariq
	 */
	public static void error(Object className,String message){
		log = Logger.getLogger(className.getClass());
		log.error(message);
	}
	
	/**
	 * To log fatal messages in the Log file
	 * 
	 * @param className : The class that log the message
	 * @param message : The message that will printed in the log file
	 * @author Tariq
	 */
	public static void fatal(Object className,String message){
		log = Logger.getLogger(className.getClass());
		log.fatal(message);
	}
	
	/**
	 * To log waning messages in the Log file
	 * 
	 * @param className : The class that log the message
	 * @param message : The message that will printed in the log file
	 * @author Tariq
	 */
	public static void warn(Object className,String message){
		log = Logger.getLogger(className.getClass());
		log.warn(message);
	}

}
