package lk.sliit.customerservice.util;



import lk.sliit.customerservice.constants.CommonConstant;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author: Lasith Hansana
 * date: 9/21/2020
 * time: 3:05 PM
 */
public class PropertyHandler {
    PropertyHandler(){

    }
    protected static final Properties properties = new Properties();
    /**
     * Initialize logger
     */
    public static final Logger log = Logger.getLogger(DatabaseHandler.class.getName());

    static {
        try {

            // Read the property only once when load the class
            properties.load(DatabaseHandler.class.getResourceAsStream(CommonConstant.PROPERTY_FILE));

        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }
}
