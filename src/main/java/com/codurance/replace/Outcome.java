package com.codurance.replace;

import com.codurance.values.Point;

import java.util.Collection;

public class Outcome {
    public Contents nextContents;
    public Collection<Point> neighbours;

    public Outcome(Contents contents, Collection<Point> neighbours) {
        this.nextContents = contents;
        this.neighbours = neighbours;
    }
}
