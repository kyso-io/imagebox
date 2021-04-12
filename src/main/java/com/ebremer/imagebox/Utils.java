package com.ebremer.imagebox;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**Class with utility methods*/
public class Utils {

    public static Boolean isWhiteListed(String iiif){
    	Boolean isWhiteListed = false;
        Logger.getLogger(Utils.class.getName()).log(Level.INFO,"Verifying if the domain in the parameter is " +
                "one of the whiteListed Ones...");
        
        String whiteListedUrls = System.getenv("whiteListedUrls");
        if(whiteListedUrls.isEmpty()) {
        	isWhiteListed = true;
        }
        
        else {
	        List<String> whiteListedDomainsList = Arrays.asList(whiteListedUrls.split(","));

	        for (String whiteURL :whiteListedDomainsList ){
	         //   System.out.println("whiteURL- " + whiteURL);
	            if (iiif.trim().startsWith(whiteURL.trim())){
	            	isWhiteListed = true;
	                Logger.getLogger(Utils.class.getName()).log(Level.INFO,
	                        whiteURL+ "  [ param starts with whitelisted one.]) ");
	            }
	        }
        }
//        if(msg.isEmpty()){
//        System.out.println("msg- " + msg+" empty check: "+msg.isEmpty());
//        }
        return isWhiteListed;
      }

}
