package com.atipera.repolister.service;

import com.atipera.repolister.data.BranchResponse;
import com.atipera.repolister.data.Repo;
import com.atipera.repolister.data.RepoResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/repo")
public class GithubResource {

    @RestClient
    private RepoService repoService;

    @RestClient
    private BranchService branchService;

    @GET
    @Path("/{username}")
    public Uni<List<RepoResponse>> fetchRepositories(@PathParam("username") String username) {
        return repoService.fetchRepositories(username)
                .onItem()
                .transformToUni(repos -> {
                    List<Uni<RepoResponse>> repoResponses = repos.stream()
                            .filter(repo -> !repo.isFork())
                            .map(this::fetchBranches)
                            .toList();
                    return Uni.combine().all().unis(repoResponses).with(responses ->
                            responses.stream()
                                    .map(item -> (RepoResponse) item)
                                    .toList()
                    );
                });
    }

    private Uni<RepoResponse> fetchBranches(Repo repo) {
        return branchService.fetchBranches(repo.getOwner().getLogin(), repo.getName())
                .onItem()
                .transform(branches -> new RepoResponse(
                        repo.getName(),
                        repo.getOwner().getLogin(),
                        branches.stream()
                                .map(branch -> new BranchResponse(branch.getName(), branch.getCommit().getSha()))
                                .toList()
                ));
    }
}
