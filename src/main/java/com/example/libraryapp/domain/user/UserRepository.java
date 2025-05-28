package com.example.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //반환 타입은 유저
    //함수이름이 중요함 이거에 맞춰 sql이 알아서 조립되는 방식
    Optional<User> findByName(String name);


}
