package com.caidapao.repository;

import com.caidapao.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by caidapao on 2019-7-24
 * Time 17:32
 * Address https://today.caidapao.com
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);
}
