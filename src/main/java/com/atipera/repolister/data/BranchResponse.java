package com.atipera.repolister.data;

import lombok.Data;

@Data
public class BranchResponse {
    private final String branchName;
    private final String sha;
}
