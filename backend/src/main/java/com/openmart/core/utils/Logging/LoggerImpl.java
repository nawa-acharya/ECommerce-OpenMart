package com.openmart.core.utils.Logging;

import org.springframework.stereotype.Component;

/**
 * Created by Nawa on 7/13/2016.
 */
@Component
public class LoggerImpl implements Logger {
    @Override
    public void log(String logMessage) {
        System.out.println();
        java.util.logging.Logger.getLogger("*****************************************************************");
        java.util.logging.Logger.getLogger("OpenMart Logger-----").info(logMessage);
        java.util.logging.Logger.getLogger("*****************************************************************");
    }
}
