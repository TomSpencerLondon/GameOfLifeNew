package com.codurance.values;

import com.codurance.replace.Contents;
import com.codurance.replace.Coordinates;

import java.util.HashMap;
import java.util.Map;

public abstract class World {
    protected Map<Coordinates, Contents> population = new HashMap<>();

    public abstract Contents at(Coordinates coordinates);
}
