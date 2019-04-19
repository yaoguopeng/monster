package com.island.monster.security;

import com.island.monster.bean.IslandManager;
import com.island.monster.mapper.IslandManagerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class IslandManagerDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandManagerDetailsService.class);

    @Autowired
    private IslandManagerMapper islandManagerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        IslandManager target = islandManagerMapper.getByRegisterName(username);
        if (target == null) {
            LOGGER.info("failed to login : registerName={} is not really exist", username);
            return null;
        }
        LOGGER.info("a manager has login : registerName={} and role={}", target.getRegisterName(), target.getRole());
        return new IslandManagerDetails(target.getRegisterName(), target.getRegisterPassword(), target.getRole());
    }
}
