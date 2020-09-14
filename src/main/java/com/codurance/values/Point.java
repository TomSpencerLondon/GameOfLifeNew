package com.codurance.values;

import com.codurance.replace.Contents;
import com.codurance.replace.Coordinates;

public class Point {

    public Contents contents;
    public Coordinates coordinates;

    public Point(Contents contents, Coordinates coordinates) {
        this.contents = contents;
        this.coordinates = coordinates;
    }
}
