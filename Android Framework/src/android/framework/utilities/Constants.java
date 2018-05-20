/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;
 
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JDesktopPane;


/**
 * 
 * @author majidkhan
 */
public class Constants {

    
    public static final String FOOTER_ALL_SCREEN = "APPLIED RESEARCH PROJECT";
    public static final String TITLE = "Android Framework";
    public static String PROJECT_NAME = "";
    
    public static String LOV_DESCRIPTION = "DESCRIPTION";
    public static String LOV_ID = "ID";
    //public static GeneralTableLookAndFeel TABLE_LOOK = 
    //new GeneralTableLookAndFeel();
    public static int GENERAL_TABLE_HEADER_WIDTH = 18;
    
    
    public static HashMap<Integer,String> MENU_ITEMS_NAMES = new HashMap<>();
    public static HashMap<Integer,String> MENU_ITEMS_FORMS = new HashMap<>();
    public static ArrayList MENU_IDS = new ArrayList();
    
    public static HashMap MENU_ITEMS_MNEMONIC = new HashMap();
    public static HashMap HASH_USER_MENU_ITEM = new HashMap();
    public static String PROJECT_PATH = "";
    public static final String PREFERENCE_FILE = "preferences.csv";
    public static final String SDK_PATH = "/Volumes/Data+Softwares/SoftWare/sdk/tools/";
    public static final String ANT_PATH = "/Volumes/Data+Softwares/SoftWare/ant/bin/";
    public static String CREATE_PROJECT_CMD = SDK_PATH + "android create project -a MainActivity -t android-19 ";
    public static String GENERATE_APK_CMD = ANT_PATH + "ant debug -f ";
    
}
