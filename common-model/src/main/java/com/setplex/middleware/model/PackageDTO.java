package com.setplex.middleware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ruslan Yatsevich
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDTO implements Serializable {
    private int packageId;
    private String name;
    private List<ChannelDTO> channels;

    public PackageDTO(int packageId, String name) {
        this.packageId = packageId;
        this.name = name;
    }

}
