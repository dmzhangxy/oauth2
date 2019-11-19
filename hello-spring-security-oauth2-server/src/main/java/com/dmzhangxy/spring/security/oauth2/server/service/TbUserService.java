package com.dmzhangxy.spring.security.oauth2.server.service;

import com.dmzhangxy.spring.security.oauth2.server.domain.TbUser;

public interface TbUserService{

    TbUser getByUsername(String username);
}
