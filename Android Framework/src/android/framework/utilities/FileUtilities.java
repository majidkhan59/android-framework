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
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.openide.util.Exceptions;

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
    
    public static String copyIcon(String iconPath){
        String drawablePath = Constants.PROJECT_PATH + "/apk/res/drawable-";
        String[] drawableTypes = {"ldpi","hdpi","mdpi","xhdpi"};
        File source = new File(iconPath);
        String fileName = source.getName().substring(0,source.getName().lastIndexOf(".")).replaceAll(" ", "_").replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String fileExt = "." + source.getName().substring(source.getName().lastIndexOf(".") + 1);
        for(int i = 0; i < drawableTypes.length; i++){
            try {
                File dest = new File(drawablePath + drawableTypes[i] + "/" + fileName + fileExt);
                
                Files.copy(source.toPath(), dest.toPath(),StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        
        return fileName;
    }
}
