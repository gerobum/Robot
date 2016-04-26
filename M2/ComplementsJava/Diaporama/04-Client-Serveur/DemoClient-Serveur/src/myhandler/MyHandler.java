/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhandler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import static javax.imageio.ImageIO.read;

/**
 *
 * @author yvan
 */
public class MyHandler implements HttpHandler {

  @Override
  public void handle(HttpExchange t) throws IOException {
    InputStream is = t.getRequestBody();
    read(is); // .. read the request body
    String response = "<h1>This is the response</h1>";
    t.sendResponseHeaders(200, response.length());
    OutputStream os = t.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }
  
  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
   server.createContext("/applications/myapp", new MyHandler());
   server.setExecutor(null); // creates a default executor
   server.start();
  }
}
