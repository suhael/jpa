package com.suhael.jpa.rest;

import javax.ws.rs.core.Application;
import java.util.Set;

@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.suhael.jpa.rest.TagRest.class);
        resources.add(com.suhael.jpa.rest.UserRest.class);
    }

}