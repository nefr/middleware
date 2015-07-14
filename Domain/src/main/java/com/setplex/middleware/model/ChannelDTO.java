package com.setplex.middleware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Ruslan Yatsevich
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDTO implements Serializable {
    private int channelId;
    private String name;
    private String language;
    private int packageId;


}
