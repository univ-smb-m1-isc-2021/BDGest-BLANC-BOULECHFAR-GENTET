package com.example.bdgesttest.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BDGestUserRepository extends JpaRepository<BDGestUser, Long>  {

    BDGestUser findUserById(Long id);
    BDGestUser findBDGestUserByLogin(String login);

}
