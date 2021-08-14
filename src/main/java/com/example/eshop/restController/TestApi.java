package com.example.eshop.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@Profile("dev")
@RestController
@RequiredArgsConstructor
public class TestApi {
}
