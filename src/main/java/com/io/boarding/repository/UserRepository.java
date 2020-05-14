package com.io.boarding.repository;

import com.io.boarding.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


}
