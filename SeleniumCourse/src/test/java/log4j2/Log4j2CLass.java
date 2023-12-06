package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2CLass {
	
	public static void main(String[] args) {
		Logger l = LogManager.getLogger(Log4j2CLass.class);
		l.info("info msg");
		l.error("error msg");
		l.fatal("fatal msg");
		l.warn("warn msg");
		l.debug("debug msg");
		System.out.println("Done");
	}

}
