/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.sdk;

import android.framework.main.Button;
import android.framework.utilities.CommandLineUtilities;
import android.framework.utilities.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.netbeans.api.visual.widget.Widget;
import org.openide.util.Exceptions;

/**
 *
 * @author usamamaqbool
 */
public class CodeGenerator {
    //Used to create file
    public static void fileCreator(String data, String fileName, String fileType) {
        try {
            File f;
            // if(System.getProperty("os.name").split(" ")[0].equals("MAC"))
            f = new File(Constants.PROJECT_PATH + File.separator + fileName + fileType);

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
    public static void javaFileGenerate(ArrayList<Widget> wid ) {

       
        String start = "";
        String button = "";
        String mid="";
        String end = "";
        start = "package com.AndroidFramework."+Constants.PROJECT_NAME +
                "\n" +
                "import android.app.Activity;\n" +
                "import android.content.Intent;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.View;\n" +
                "import android.widget.Button;\n" +
                "import android.widget.EditText;\n" +
                "\n" +
                "\n" +
                "public class MainActivity extends Activity {\n" +
                "    \n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" ;

                for (int i = 0; i < wid.size(); i++) {
                    if(wid.get(i) instanceof Button)
                    {
                        button += "Button " + wid.get(i) + "=(Button)findViewById(R.id." + wid.get(i) + ");\n";
                    }
                    else
                    {
                        button += "EditText" + wid.get(i) +"= (EditText) findViewById(R.id." + wid.get(i) + ");\n";
                    }
                }
                
               mid= "        data.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                \n" +
                "                String mytext =gettext.getText().toString();\n" +
                "                Bundle bundle = new Bundle();\n" +
                "                bundle.putString(\"mytext\",mytext);\n" +
                "                Intent intent = new Intent(MainActivity.this,SecondActivity.class);\n" +
                "                intent.putExtras(bundle);\n" +
                "                startActivity(intent);\n" +
                "            }\n" +
                "        });\n "+
                "    }\n";



        end = "}";

     
        fileCreator(start + button + end, "MainActivity", ".java");

    }

    //used to generate manifest file of android
    public static void manifestGenerate() {
        String data;
        data = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"com.AndroidFramework."+Constants.PROJECT_NAME +
                "\"> <application android:allowBackup=\"true\" android:label=\"@string/app_name\"> <activity android:name=\".MainActivity\" android:label=\"@string/app_name\"> <intent-filter> <action android:name=\"android.intent.action.MAIN\" /> <category android:name=\"android.intent.category.LAUNCHER\" /> </intent-filter> </activity> </application> </manifest>";
        fileCreator(data, "AndroidManifest", ".xml");
    }
    //layout of the application is generated

    public static void layoutGenerate(ArrayList<Widget> wid) {


        String start = "";
        String button = "";

        String end = "";
        start = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "    android:id=\"@+id/activity_main\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    tools:context=\"package com.AndroidFramework."+Constants.PROJECT_NAME +
            "    \">\n";
            for (int i = 0; i < wid.size(); i++) {
                    if(wid.get(i) instanceof Button)
                    {
                    button +=
                    "    <Button\n" +
                    "    android:text=\""+ wid.get(i)+"\"\n" +
                    "    android:layout_width=\"wrap_content\"\n" +
                    "    android:layout_height=\"wrap_content\"\n" +
                    "    android:layout_below=\"@+id/tvset\"\n" +
                    "    android:layout_centerHorizontal=\"true\"\n" +
                    "    android:layout_marginTop=\"101dp\"\n" +
                    "    android:id=\"@+id/" + wid.get(i)+"\"/>\n";
                    }
                    else
                    {
                      button+="    <EditText\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"wrap_content\"\n" +
             "    android:inputType=\"textMultiLine\"\n"+
            "    android:layout_alignParentTop=\"true\"\n" +
            "    android:layout_marginTop=\"27dp\"\n" +
            "    android:id=\"@+id/" + wid.get(i).getToolTipText()+"\"/>\n";
                    }
            }
            end = "    </LinearLayout>\n";

        fileCreator(start + button + end, "activity_main", ".xml");

    }
    //resource 

    public static void resourceGenerate(ArrayList<Widget> wid) {

        String start = "";
        String str = "";
        String end = "";

        start = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n";
        str = "    <string name=\"app_name\">" + Constants.PROJECT_NAME + "</string>\n";
        for (int i = 0; i < wid.size(); i++) {
            str += "    <string name=\"" + wid.get(i) + "\">" + wid.get(i) + "</string>\n";
        }
        end = "</resources>";
        fileCreator(start + str + end, "strings", ".xml");
    }
    
    public static void createNewAndroidProject(){
        
       CommandLineUtilities.executeCommand(Constants.CREATE_PROJECT_CMD);   
    }
}