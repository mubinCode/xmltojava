package com.abdullah.spacestation;

import lombok.Data;

import java.util.List;

@Data
public class SpaceStation {
    private int count;
    private Owner owner;
    private List<SpaceShip> spaceships;
}
