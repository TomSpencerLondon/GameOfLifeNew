package com.codurance.replace.cell;

import com.codurance.replace.Contents;
import com.codurance.values.Cell;
import com.codurance.values.Nothing;
import com.codurance.values.Point;

import java.util.Collection;

public class DeterminesNextContents {
    public Contents determine(Contents oldContents, Collection<Point> neighbours) {
        switch(countLive(neighbours)){
            case 2:
                return oldContents instanceof Cell ? new Cell() : new Nothing();
            case 3:
                return new Cell();
            default:
                return new Nothing();
        }
    }

    private int countLive(Collection<Point> neighbours) {
        int i = 0;
        for (Point point : neighbours){
            if (point.contents instanceof Cell)
                i++;
        }
        return i;
    }
}
