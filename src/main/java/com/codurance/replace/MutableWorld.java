package com.codurance.replace;

import com.codurance.values.World;

public class MutableWorld extends World {
    public void set(Coordinates coordinates, Contents contents) {
        population.put(coordinates, contents);
    }

    public Contents at(Coordinates coordinates) {
        return population.get(coordinates);
    }
}
