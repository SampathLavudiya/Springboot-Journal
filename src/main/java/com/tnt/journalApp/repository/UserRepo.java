package com.tnt.journalApp.repository;

import com.tnt.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
//    findBy + field name
    User findByUserName(String userName);

    User deleteByUserName(String userName);

}