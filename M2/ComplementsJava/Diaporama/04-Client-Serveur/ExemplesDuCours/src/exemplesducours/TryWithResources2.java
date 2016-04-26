/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplesducours;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author yvan
 */
public class TryWithResources2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {        
            try (
                ZipFile zf = new ZipFile(args[0]);
                PrintWriter writer = new PrintWriter(args[1]);
            ) {
            Enumeration<? extends ZipEntry> eze = zf.entries();
            while (eze.hasMoreElements()) {
                writer.println(eze.nextElement());
            }
        }
    }
}
