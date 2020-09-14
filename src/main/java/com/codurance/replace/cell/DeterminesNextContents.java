package com.codurance.replace.cell;

import com.codurance.replace.Contents;
import com.codurance.values.Cell;
import com.codurance.values.Nothing;
import com.codurance.values.Point;

import java.util.Collection;

public class DeterminesNextContents {
    public Contents determine(Contents oldContents, Collection<Point> neighbours) {
        if(countLive(neighbours) == 0)
            return new Nothing();
        return new Cell();
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
