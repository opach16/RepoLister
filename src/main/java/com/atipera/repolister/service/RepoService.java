package com.atipera.repolister.service;

import com.atipera.repolister.data.Repo;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient
public interface RepoService {

    @GET
    @ClientHeaderParam(name = "User-Agent", value = "RepoLister")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users/{username}/repos")
    Uni<List<Repo>> fetchRepositories(@PathParam("username") String username);
}
