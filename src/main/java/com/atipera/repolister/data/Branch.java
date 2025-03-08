package com.atipera.repolister.data;

import lombok.Data;

@Data
public class Branch {
    private String name;
    private Commit commit;
}
