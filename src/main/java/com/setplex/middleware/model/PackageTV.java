package com.setplex.middleware.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ruslan Yatsevich
 */
@Data
@NoArgsConstructor
public class PackageTV implements Serializable {
    private int packageId;
    private String name;
    private List<ChannelTV> channels;

    public PackageTV (int packageId, String name) {
        this.packageId = packageId;
        this.name = name;
    }

}
