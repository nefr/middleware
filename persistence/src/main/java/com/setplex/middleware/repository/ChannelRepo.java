package com.setplex.middleware.repository;

import com.setplex.middleware.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepo extends JpaRepository<Channel, Integer> {
}
