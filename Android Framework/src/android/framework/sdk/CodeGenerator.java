/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.sdk;

import android.framework.main.MobileScreen;
import android.framework.utilities.Button;
import android.framework.utilities.CommandLineUtilities;
import android.framework.utilities.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXLabel;
import org.netbeans.api.visual.widget.ComponentWidget;
import org.netbeans.api.visual.widget.Widget;
import org.openide.util.Exceptions;

/**
 *
 * @author usamamaqbool
 */
public class CodeGenerator {

    //Used to create file
    public static void fileCreator(String data, String fileName, String fileType, String path) {
        try {
            File f;
            f = new File(path + fileName + fileType);

            if (!f.exists())//check if the file already exists
            {
                f.createNewFile();
                FileWriter writer = new FileWriter(f);
                writer.write(data);
                writer.close();
            } else {
                f.delete();
                f.createNewFile();
                FileWriter writer = new FileWriter(f);
                writer.write(data);
                writer.close();
            }

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    //Used to write code in Java file
    public static void javaFileGenerate(Map<Button, MobileScreen> sceneMap) {

        ArrayList<Button> buttonQueue = new ArrayList<>();
        buttonQueue.add(null);
        int activityNumber = 0;

        while (buttonQueue.size() > 0) {
            String start = "";
            String component = "";
            String onclick = "";
            String end = "";

            MobileScreen thisScreen = sceneMap.get(buttonQueue.get(0));
            buttonQueue.remove(0);
            ArrayList<Widget> screenComponents = thisScreen.getComponents();

            start = "package com.AndroidFramework." + Constants.PROJECT_NAME
                    + ";\n"
                    + "import android.app.Activity;\n"
                    + "import android.content.Intent;\n"
                    + "import android.os.Bundle;\n"
                    + "import android.view.View;\n"
                    + "import android.widget.Button;\n"
                    + "import android.widget.TextView;\n"
                    + "\n"
                    + "\n"
                    + "public class activity" + activityNumber + " extends Activity {\n"
                    + "    \n"
                    + "    @Override\n"
                    + "    protected void onCreate(Bundle savedInstanceState) {\n"
                    + "        super.onCreate(savedInstanceState);\n"
                    + "        setContentView(R.layout.activity" + activityNumber + ");\n";

            for (int i = 0; i < screenComponents.size(); i++) {
                if (screenComponents.get(i) instanceof Button) {
                    buttonQueue.add((Button) screenComponents.get(i));
                    component += "Button button" + i + "a" + activityNumber + " =(Button)findViewById(R.id.button" + i + "a" + activityNumber + ");\n";
                } else {
                    component += "TextView label" + i + "a" + activityNumber + " = (TextView) findViewById(R.id.label" + i + "a" + activityNumber + ");\n"
                            + "";
                }
            }

            for (int i = 0; i < screenComponents.size(); i++) {
                if (screenComponents.get(i) instanceof Button) {
                    onclick += "        button" + i + "a" + activityNumber + ".setOnClickListener(new View.OnClickListener() {\n"
                            + "            @Override\n"
                            + "            public void onClick(View v) {\n"
                            + "                \n"
                            + "                Intent intent = new Intent(activity" + activityNumber + ".this,activity" + sceneMap.get((Button) screenComponents.get(i)).getActivityNumber() + ".class);\n"
                            + "                startActivity(intent);\n"
                            + "            }\n"
                            + "        });\n ";
                }
            }
            end = "}\n}";

            fileCreator(start + component + onclick + end, "activity" + activityNumber, ".java", Constants.PROJECT_PATH + "/apk/src/com/AndroidFramework/" + Constants.PROJECT_NAME + "/");
            activityNumber++;
        }
    }

    //used to generate manifest file of android
    public static void manifestGenerate(ArrayList<String> screenTitles) {
        String data = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                + "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"com.AndroidFramework." + Constants.PROJECT_NAME + "\">\n"
                + "<application android:allowBackup=\"true\" android:label=\"@string/app_name\">\n"
                + "<activity android:name=\"activity0\" android:label=\"@string/app_name\">\n"
                + "<intent-filter> <action android:name=\"android.intent.action.MAIN\" />\n"
                + "<category android:name=\"android.intent.category.LAUNCHER\" />\n"
                + "</intent-filter>\n"
                + "</activity>\n";
        for (int i = 1; i < screenTitles.size(); i++) {
            data += "<activity android:name=\"activity" + i + "\" android:label=\"@string/activity" + i + "\"/>\n";
        }
        data += "</application>\n"
                + "</manifest>";
        fileCreator(data, "AndroidManifest", ".xml", Constants.PROJECT_PATH + "/apk/");
        for (int i = 1; i < screenTitles.size(); i++) {
            fileCreator("", "activity" + i, ".java", Constants.PROJECT_PATH + "/apk/src/com/AndroidFramework/" + Constants.PROJECT_NAME + "/");
        }
    }
    //layout of the application is generated

    public static void layoutGenerate(Map<Button, MobileScreen> sceneMap) {

        ArrayList<Button> buttonQueue = new ArrayList<>();
        buttonQueue.add(null);
        int activityNumber = 0;

        while (buttonQueue.size() > 0) {
            String start = "";
            String component = "";
            String end = "";

            MobileScreen thisScreen = sceneMap.get(buttonQueue.get(0));
            thisScreen.setActivityNumber(activityNumber);

            buttonQueue.remove(0);
            ArrayList<Widget> screenComponents = thisScreen.getComponents();

            start = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                    + " <ScrollView xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
                    + "    xmlns:tools=\"http://schemas.android.com/tools\"\n"
                    + " android:layout_width=\"fill_parent\" \n"
                    + " android:layout_height=\"fill_parent\" >"
                    
                    + "<LinearLayout\n"
                    + "    android:orientation=\"vertical\"\n"
                    + "    android:id=\"@+id/activity" + activityNumber + "\"\n"
                    + "    android:layout_width=\"wrap_content\"\n"
                    + "    android:layout_height=\"wrap_content\"\n"
                    + "    android:gravity=\"center_horizontal\"\n"
                    + "    android:paddingLeft=\"20dp\"\n"
                    + "    android:paddingRight=\"20dp\"\n"
                    + "    tools:context=\"package com.AndroidFramework." + Constants.PROJECT_NAME
                    + "    \">\n";
            for (int i = 0; i < screenComponents.size(); i++) {
                if (screenComponents.get(i) instanceof Button) {
                    buttonQueue.add((Button) screenComponents.get(i));
                    component
                            += "   <Button\n"
                            + "    android:text=\"@string/button" + i + "a" + activityNumber + "\"\n"
                            + "    android:layout_width=\"wrap_content\"\n"
                            + "    android:layout_height=\"wrap_content\"\n"
                            + "    android:gravity=\"center\"\n"
                            + "    android:id=\"@+id/button" + i + "a" + activityNumber + "\"/>\n";
                } else {
                    component
                            += "<TextView\n"
                            + "      android:id=\"@+id/label" + i + "a" + activityNumber + "\"\n"
                            + "      android:text=\"@string/label" + i + "a" + activityNumber + "\"\n"
                            + "      android:layout_width=\"fill_parent\"\n"
                            + "      android:layout_height=\"fill_parent\"\n"
                            + "      android:capitalize=\"characters\"\n"
                            + "      android:layout_gravity=\"fill\"\n"
                            + "      android:textIsSelectable=\"false\"\n"
                            + "      android:clickable=\"false\"\n"
                            + "      android:longClickable=\"false\"\n"
                            + "      android:singleLine=\"false\"\n"
                            + "      android:textSize=\"15dp\"/>\n";
                }
            }
            end = "    </LinearLayout>\n</ScrollView>";

            fileCreator(start + component + end, "activity" + activityNumber, ".xml", Constants.PROJECT_PATH + "/apk/res/layout/");
            activityNumber++;
        }
    }

    //resource 
    public static void resourceGenerate(Map<Button, MobileScreen> sceneMap) {

        ArrayList<Button> buttonQueue = new ArrayList<>();
        buttonQueue.add(null);
        int activityNumber = 0;

        String start = "";
        String component = "";
        String end = "";

        start = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n";

        component = "    <string name=\"app_name\">" + Constants.PROJECT_NAME + "</string>\n";
        while (buttonQueue.size() > 0) {
            MobileScreen thisScreen = sceneMap.get(buttonQueue.get(0));
            buttonQueue.remove(0);
            ArrayList<Widget> screenComponents = thisScreen.getComponents();
            component += "    <string name=\"activity" + activityNumber + "\">" + thisScreen.getScreenTitle() + "</string>\n";
            for (int i = 0; i < screenComponents.size(); i++) {
                if (screenComponents.get(i) instanceof Button) {
                    buttonQueue.add((Button) screenComponents.get(i));
                    component += "    <string name=\"button" + i + "a" + activityNumber + "\">" + screenComponents.get(i) + "</string>\n";
                } else {
                    ComponentWidget labelComp = (ComponentWidget) screenComponents.get(i);
                    JXLabel label = (JXLabel) labelComp.getComponent();

                    component += "    <string name=\"label" + i + "a" + activityNumber + "\">" + label.getText() + "</string>\n";
                }
            }
            activityNumber++;
        }

        end = "</resources>";
        fileCreator(start + component + end, "strings", ".xml", Constants.PROJECT_PATH + "/apk/res/values/");
    }

    /**
     * Runs the command to make a new android project at the given project path.
     *
     */
    public static void createNewAndroidProject() {

        CommandLineUtilities.executeCommand(Constants.CREATE_PROJECT_CMD);
    }

    public static void generateAPK() {
        String cmdResult;
        cmdResult = CommandLineUtilities.executeCommand(Constants.GENERATE_APK_CMD);
        if (cmdResult.contains("BUILD SUCCESSFUL")) {
            JOptionPane.showMessageDialog(null, "APK Generated Successfully\n\nAPK Path: " + Constants.PROJECT_PATH + "/apk/bin/" + Constants.PROJECT_NAME + "-debug.apk",
                    "APK Built", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "APK Generation Failed!\n\nPlease see Console Logs!",
                    "APK Build Failed", JOptionPane.ERROR_MESSAGE);
            System.out.println(cmdResult);
        }

    }
}
