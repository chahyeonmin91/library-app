package com.example.libraryapp.service.fruit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("m")
public class AppleService implements FruitService{
}
