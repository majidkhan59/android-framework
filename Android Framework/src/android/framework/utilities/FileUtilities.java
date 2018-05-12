/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author majidkhan
 */
public class FileUtilities {

    public static void readPreferences() {
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(Constants.PREFERENCE_FILE))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }
    
    public static boolean createProjectFolder(){
        return new File(Constants.PROJECT_PATH).mkdir();
    }
    
    public static boolean createAPKFolder(){
        return new File(Constants.PROJECT_PATH + "/apk").mkdir();
    }
    
    public static boolean writePreferencesToCSV(ArrayList<String> values) {
        char DEFAULT_SEPARATOR = ',';
        boolean ret = false; 
        boolean first = true;
        FileWriter writer = null;
        
        try {
            //Create File 
            String prefFile = Constants.PROJECT_PATH + File.separator + Constants.PREFERENCE_FILE;
            System.out.println("outputFolder = " + prefFile);
            //Using FileWriter

            writer = new FileWriter(prefFile);
            StringBuilder sb = new StringBuilder();
            for (String value : values) {
                if (!first) {
                    sb.append(DEFAULT_SEPARATOR);
                }
                sb.append((value));
                first = false;
            }
            sb.append("\n");
            writer.append(sb.toString());
            ret  = true;
            writer.flush();
            writer.close();
                
        }
         catch (IOException ex) {
            Logger.getLogger(FileUtilities.class.getName()).log(Level.SEVERE, null, ex);
            ret = false;
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(FileUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return ret;
    }
  
    
}
