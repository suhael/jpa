package com.suhael.jpa.rest;

import com.suhael.jpa.dao.jpa.TagDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Stateless
@Path("tag")
public class TagRest {

    @Inject
    private TagDao tagDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipes() throws IOException {
        return ResponseBuilder.returnJsonResponse(tagDao.getTags());
    }
}
