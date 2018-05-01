/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andriod.framework.sdk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
            f = new File(fileName + fileType);

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
    public static void javaFileGenerate(String name) {
        ArrayList<String> buttons = new ArrayList();
        buttons.add("abc");
        buttons.add("cbf");
        String start = "";
        String button = "";
        String end = "";
        start = "package com.temp.usamamaqbool.assignment4task2;"
                + "import android.content.Intent;"
                + "import android.support.v7.app.AppCompatActivity;"
                + "import android.os.Bundle;"
                + "import android.view.View;"
                + "import android.widget.Button;"
                + "public class MainActivity extends AppCompatActivity {"
                + "protected void onCreate(Bundle savedInstanceState) {"
                + "super.onCreate(savedInstanceState);"
                + "setContentView(R.layout.activity_main);  ";
        for (int i = 0; i < buttons.size(); i++) {

            button += "Button " + buttons.get(i) + "=(Button)findViewById(R.id." + buttons.get(i) + ");";
        }
        button = button + "}";

        for (int i = 0; i < buttons.size(); i++) {
            button = button + "protected void goTo" + buttons.get(i) + "Activity(View view) {"
                    + "Intent intent = new Intent(getApplicationContext()," + buttons.get(i) + ".class);"
                    + "startActivity(intent);}";
        }

        end = "}";

        fileCreator(start + button + end, "MainActivity", ".java");

    }

    //used to generate manifest file of android
    public static void manifestGenerate() {
        String data;
        data = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"com.swin.usamamaqbool.@string/app_name\"> <application android:allowBackup=\"true\"android:icon=\"@mipmap/ic_launcher\" android:label=\"@string/app_name\" android:supportsRtl=\"true\" android:theme=\"@style/AppTheme\"> <activity android:name=\".MainActivity\" android:label=\"@string/app_name\"> <intent-filter> <action android:name=\"android.intent.action.MAIN\" /> <category android:name=\"android.intent.category.LAUNCHER\" /> </intent-filter> </activity> </application> </manifest>";
        fileCreator(data, "AndroidManifest", ".xml");
    }
    //layout of the application is generated

    public static void layoutGenerate() {
        ArrayList<String> buttons = new ArrayList();
        buttons.add("abc");
        buttons.add("cbf");
        String start = "";
        String button = "";
        String end = "";
        start = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                + "<android.support.constraint.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
                + "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n"
                + "    xmlns:tools=\"http://schemas.android.com/tools\"\n"
                + "    android:layout_width=\"match_parent\"\n"
                + "    android:layout_height=\"match_parent\"\n"
                + "    tools:context=\"com.temp.usamamaqbool.assignment4task2.MainActivity\">\n"
                + "\n"
                + "    <RelativeLayout\n"
                + "        android:layout_width=\"304dp\"\n"
                + "        android:layout_height=\"437dp\"\n"
                + "        android:layout_marginLeft=\"3dp\"\n"
                + "        android:layout_marginStart=\"3dp\"\n"
                + "        app:layout_constraintBottom_toBottomOf=\"parent\"\n"
                + "        app:layout_constraintLeft_toLeftOf=\"parent\">\n";

        for (int i = 0; i < buttons.size(); i++) {
            button += "<Button\n"
                    + "            android:id=\"@+id/" + buttons.get(i) + "\"\n"
                    + "            android:layout_width=\"wrap_content\"\n"
                    + "            android:layout_height=\"wrap_content\"\n"
                    + "            android:layout_alignParentTop=\"true\"\n"
                    + "            android:layout_centerHorizontal=\"true\"\n"
                    + "            android:layout_marginTop=\"77dp\"\n"
                    + "            android:onClick=\"goTo" + buttons.get(i) + "Activity\"\n"
                    + "            android:text=\"@+id/" + buttons.get(i) + ">\n";
        }
        end = "    </RelativeLayout>\n"
                + "</android.support.constraint.ConstraintLayout>";
        fileCreator(start + button + end, "activity_main", ".xml");

    }
    //resource 

    public static void resourceGenerate(String AppName) {
        ArrayList<String> buttons = new ArrayList();
        buttons.add("abc");
        buttons.add("cbf");
        String start = "";
        String button = "";
        String end = "";

        start = "<resources>\n";
        button = "    <string name=app_name>" + AppName + "</string>\n";
        for (int i = 0; i < buttons.size(); i++) {
            button += "    <string name=" + buttons.get(i) + ">" + buttons.get(i) + "</string>\n";
        }
        end = "</resources>";
        fileCreator(start + button + end, "strings", ".xml");
    }
}
