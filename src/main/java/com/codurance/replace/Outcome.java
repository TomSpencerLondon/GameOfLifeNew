package com.codurance.replace;

import java.util.Collection;

public class Outcome {
    Contents nextContents;
    Collection<Coordinates> neighbours;

    public Outcome(Contents contents, Collection<Coordinates> neighbours) {
        this.nextContents = contents;
        this.neighbours = neighbours;
    }
}
