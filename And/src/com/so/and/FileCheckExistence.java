package com.so.and;

import java.io.File;
import java.io.IOException;

public class FileCheckExistence {
	public static void lance() throws IOException {
		
		File f = new File("/data/data/com.so.and/historique.xml");
		if (f.exists()) {
		System.out.println("File Historique " + f.getCanonicalPath() + " exists");
		} else {
			Initial_historique.lance();
		}
		
	}
	
}
