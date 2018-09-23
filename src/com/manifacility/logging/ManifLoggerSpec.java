package com.manifacility.logging;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Objects;

/**
 * An exception handler created to decouple the logger and exception handling from
 * the main program and to centralize the handling to keep the code more maintainable
 */
public class ManifLoggerSpec {

    private static FileOutputStream logStream;

    public static void log(Exception ex) {
        try {
            logStream = new FileOutputStream(System.getProperty("user.home") + "/tempFacilityCurrLog.txt");
        } catch (FileNotFoundException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.err.println("Error Has Occured! -- Check log file in " + System.getProperty("user.home") + "/tempFacilityCurrLog.txt");
        PrintWriter pw = new PrintWriter(Objects.requireNonNull(logStream));
        pw.println("---------------------------------------------------------------------------------------------------");
        pw.println(new Date());
        ex.printStackTrace(pw);
        pw.println("---------------------------------------------------------------------------------------------------");
        pw.flush();

        if (ex.getClass() == NullPointerException.class) System.err.println("com.manifacility.models.Machine with this id not found in the facility, re-enter the id carefully!");
    }

}
