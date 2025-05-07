package com.ecommerce.service;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.User;

public interface UserService {

    public User findUserById(long userId)throws UserException;

    public User findUserByJWT(String jwt) throws UserException;
}
