package com.codurance.replace;

import com.codurance.replace.cell.ReplacesCell;
import com.codurance.values.Point;
import com.codurance.values.World;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReplacesWorld {
    public KeepsTime keepsTime;
    public ReplacesCell replacesCell;

    public World replace(World oldWorld, long timeLimitInMS) {
        MutableWorld newWorld = new MutableWorld();
        TimeLimit timeLimit = keepsTime.keep(timeLimitInMS);
        Queue<Point> cellsToReplace = new LinkedList<Point>(Arrays.asList(new Point(null, new Coordinates(0, 0))));

        while(!cellsToReplace.isEmpty() && !timeLimit.timesUp()){
            Coordinates coordinates = cellsToReplace.remove().coordinates;
            Outcome outcome = replacesCell.replace(coordinates, oldWorld);
            newWorld.set(coordinates, outcome.nextContents);
            cellsToReplace.addAll(outcome.neighbours);
        }

        return newWorld;
    }
}
