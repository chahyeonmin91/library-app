package com.example.libraryapp.service.user;

import com.example.libraryapp.domain.user.User;
import com.example.libraryapp.domain.user.UserRepository;
import com.example.libraryapp.dto.user.request.UserCreateRequest;
<<<<<<< Updated upstream
import com.example.libraryapp.dto.user.request.UserUpdateRequest;
import com.example.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
=======
import org.springframework.stereotype.Service;
>>>>>>> Stashed changes

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

<<<<<<< Updated upstream
    //아래 있는 함수가 시작될 때 start transaction;을 해줌(트랜잭션 시작)
    //함수가 예외 없이 잘 끝났다면 commit
    //혹시라도 문제가 있다면 rollback
    @Transactional
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(), request.getAge()));
    }

    @Transactional
    public List<UserResponse> getUsers() {
        //유저 레포지토리에서 유저 정보들을 가져온 다음 자바의 stream으로 바꿈
        return userRepository.findAll().stream()
                //유저를 유저 response로 변환시키고 다시 리스트로 만들어서 반환
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        //Optional<User>
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        //객체를 업데이트 해주고, save메소드를 호출
        //그러면 자동으로 UPDATE SQL이 날아감
        user.updateName(request.getName());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        //delete sql은 있음
        userRepository.delete(user);

    }

=======
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(), request.getAge()));
        u.getId();

    }
>>>>>>> Stashed changes
}
