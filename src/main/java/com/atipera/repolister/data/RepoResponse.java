package com.atipera.repolister.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RepoResponse {
    @JsonProperty("repository_name")
    private final String name;
    @JsonProperty("owner_login")
    private final String login;
    @JsonProperty("branch")
    private final List<BranchResponse> branchResponses;
}
