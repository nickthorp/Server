package com;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

/**
 * Created by Nicholas on 10/31/2015.
 *
 */
public class HoardServer {

    private static final String BASE_API_URI = "http://localhost:8080/HoardServer/";

    public static void main(String[] args) throws Exception {
        HoardServer server = new HoardServer();
        HttpServer httpServer = server.startServer();
        //System.in.read();
        httpServer.shutdown();
    }

    HttpServer startServer(){
        ResourceConfig resourceConfig = new ResourceConfig().packages("com");
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_API_URI), resourceConfig);
        httpServer.getServerConfiguration().addHttpHandler(getHttpHandler(), "/page");
        return httpServer;
    }

    public HttpHandler getHttpHandler() {
        StaticHttpHandler handler = new StaticHttpHandler("src/main/resources/webapp/");
        handler.setFileCacheEnabled(getFileCacheEnabled());
        return handler;
    }

    public boolean getFileCacheEnabled() {
        return false;
    }
}
