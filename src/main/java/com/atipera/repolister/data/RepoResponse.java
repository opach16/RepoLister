package com.atipera.repolister.data;

import lombok.Data;

import java.util.List;

@Data
public class RepoResponse {
    private final String name;
    private final String login;
    private final List<BranchResponse> branchResponses;
}
