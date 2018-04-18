package de.hamburg.haw.ais.praktikum2;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;


public class App 
{
    @SuppressWarnings("restriction")
	public static void main( String[] args ) 
    {
        HttpServer server;
		try {
			server = HttpServerFactory.create("http://localhost:8080/rest");
			server.start();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
