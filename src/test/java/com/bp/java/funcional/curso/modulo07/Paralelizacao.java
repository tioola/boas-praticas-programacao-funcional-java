package com.bp.java.funcional.curso.modulo07;

import com.bp.java.funcional.curso.dtos.UserDto;
import com.bp.java.funcional.curso.repository.UserRepository;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class Paralelizacao {

    @Test
    public void testeConsumeApiParallelized() {

        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5, 6);

        Instant start = Instant.now();

        List<UserDto> userDtos = ids.parallelStream()
                .map(UserRepository::getUserById)
                .filter(userDto -> userDto.getData().getFirstName().startsWith("G"))
                .collect(Collectors.toList());

        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();

        System.out.println(String.format("Time in millis %s", duration));


    }
}
