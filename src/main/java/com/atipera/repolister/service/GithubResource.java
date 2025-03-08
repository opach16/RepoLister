package com.atipera.repolister.service;

import com.atipera.repolister.data.RepoResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Collections;
import java.util.List;

public class GithubResource {

    @RestClient
    private RepoService repoService;

    @RestClient
    private BranchService branchService;

    @GET
    @Path("/repo/{username}")
    public Uni<List<RepoResponse>> fetchRepositories(@PathParam("username") String username) {
        return Uni.createFrom().item(Collections.emptyList());
    }
}
