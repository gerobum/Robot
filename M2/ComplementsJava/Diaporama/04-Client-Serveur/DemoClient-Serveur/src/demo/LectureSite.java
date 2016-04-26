/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import com.sun.xml.internal.stream.XMLInputFactoryImpl;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author yvan
 */
public class LectureSite {

  public static void main(String[] args) throws MalformedURLException, IOException, XMLStreamException {
    URL url = new URL("http://www.uha.fr");
    /*URLConnection hc = url.openConnection();
    hc.connect();
    Scanner sc = new Scanner(hc.getInputStream());
    
    while (sc.hasNext()) {
      String ligne = sc.nextLine();
      //System.out.println(ligne);
      Matcher m = Pattern.compile(".*href=\"(http[^\"]*)\".*").matcher(ligne);
      while (m.find()) {
        System.out.println(m.group(1));
      }
    }

    **/
    HttpURLConnection http = (HttpURLConnection) url.openConnection();
    http.connect();
    XMLStreamReader xml = XMLInputFactory.newFactory().createXMLStreamReader(http.getInputStream());
    
    
    
    
    while (xml.hasNext()) {
      String ligne = xml.next()+"";
      System.err.println(ligne);
    }
  }
}
