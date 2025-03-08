package com.atipera.repolister.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BranchResponse {
    @JsonProperty("branch_name")
    private final String branchName;
    @JsonProperty("commit_sha")
    private final String sha;
}
