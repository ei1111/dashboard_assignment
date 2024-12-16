package com.dashBoard.user.infrastructure.domain;

import com.dashBoard.loan.infrastructure.domain.Loan;
import com.dashBoard.user.request.UserRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Loan> loans = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static User of(UserRequestDto requestDto) {
        return new User(requestDto.getName(), requestDto.getAge());
    }

    public void update(UserRequestDto userRequestDto) {
        this.name = userRequestDto.getName();
        this.age = userAgeCheck(userRequestDto.getAge());
    }

    private int userAgeCheck(int age) {
        return age > 0 ? age : this.age;
    }
}
