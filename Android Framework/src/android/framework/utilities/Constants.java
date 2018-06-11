/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author majidkhan
 */
public class Constants {

    public static int RED = 169;
    public static int GREEN = 190;
    public static int BLACK = 236;
    public static int BLUE = 236;

    public static final String FOOTER_ALL_SCREEN = "APPLIED RESEARCH PROJECT";
    public static final String TITLE = "Android Framework";
    public static String PROJECT_NAME = "";
    public static String APP_NAME = "";

    public static String LOV_DESCRIPTION = "DESCRIPTION";
    public static String LOV_ID = "ID";
    //public static GeneralTableLookAndFeel TABLE_LOOK = 
    //new GeneralTableLookAndFeel();
    public static int GENERAL_TABLE_HEADER_WIDTH = 18;

    public static String HEX_BUTTON = "";
    public static String HEX_TITLE_BAR = "";
    public static String HEX_BACKGROUND = "";

    public static HashMap<Integer, String> MENU_ITEMS_NAMES = new HashMap<>();
    public static HashMap<Integer, String> MENU_ITEMS_FORMS = new HashMap<>();
    public static ArrayList MENU_IDS = new ArrayList();

    public static HashMap MENU_ITEMS_MNEMONIC = new HashMap();
    public static HashMap HASH_USER_MENU_ITEM = new HashMap();
    public static String PROJECT_PATH = "";
    public static String JAR_PATH = "";
    public static String PREFERENCE_FILE = "preferences.csv";
    public static String SDK_PATH = JAR_PATH + File.separator + "sdk" + File.separator +"tools" + File.separator;
    public static String ANT_PATH = JAR_PATH + File.separator + "ant" + File.separator + "bin" + File.separator;
    public static String CREATE_PROJECT_CMD = SDK_PATH + "android.bat create project -a MainActivity -t android-19 ";
    public static String GENERATE_APK_CMD = ANT_PATH + "ant.bat debug -f ";

}
