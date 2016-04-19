package com;

import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpHandler;

/**
 * Created by Nicholas on 11/18/2015.
 *
 */
public class SelfServer extends HoardServer {
    public boolean getFileCacheEnabled(){
        return true;
    }

    public HttpHandler getHttpHandler(){
        return new CLStaticHttpHandler(SelfServer.class.getClassLoader(), "webapp/");
    }
}
