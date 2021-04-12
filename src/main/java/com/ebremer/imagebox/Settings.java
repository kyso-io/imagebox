package com.ebremer.imagebox;

/**
 *
 * @author erich
 */
public class Settings {
//	static int port = 8080;
//	static int port = Integer.parseInt(System.getenv("PORT"));
	static int DEFAULT_PORT = 8080;
    static String webfiles = "/svs";
    static long MaxAgeReaderPool = 600;
    static long ReaderPoolScanDelay = 600;
    static long ReaderPoolScanRate = 60;
    static String ProxyHostName = "http://localhost:8080";
    
    public static int getPort() {
    	int port;
    	String portEnv = System.getenv("PORT");
    	if (portEnv != null && !portEnv.isEmpty()) {
    		port = Integer.parseInt(portEnv);
    	} else {
    		port = DEFAULT_PORT;    		
    	}
    	return port;
    }
}