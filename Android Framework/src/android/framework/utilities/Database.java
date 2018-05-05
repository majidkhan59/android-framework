/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;


/**
 * 
 * @author majidkhan
 */
public class Database {
    
    
   
        public static void setMenuItems() {
           
            Constants.MENU_ITEMS_FORMS.put(0,"Form.General.frmPreferences");
            Constants.MENU_ITEMS_NAMES.put(0,"New Project");
            
            
            //Constants.MENU_ITEMS_FORMS.put(1,"Form.General.frmPreferences");
            //Constants.MENU_ITEMS_NAMES.put(1,"Preferences");
    
        }
        
        public static String prefFile = "preferences.csv";
    
}
