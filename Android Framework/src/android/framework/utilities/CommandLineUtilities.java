/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author shoaibahmed
 */
public class CommandLineUtilities {
    public static String executeCommand(String command) {

		StringBuilder output = new StringBuilder();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor(3, TimeUnit.SECONDS);
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
}
