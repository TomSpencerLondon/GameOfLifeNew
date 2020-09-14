package com.codurance.replace;

import com.codurance.values.World;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReplacesWorld {
    KeepsTime keepsTime;
    ReplacesCell replacesCell;

    public World replace(World oldWorld, long timeLimitInMS) {
        MutableWorld newWorld = new MutableWorld();
        TimeLimit timeLimit = keepsTime.keep(timeLimitInMS);
        Queue<Coordinates> cellsToReplace = new LinkedList<>(Arrays.asList(new Coordinates(0, 0)));

        while(!cellsToReplace.isEmpty() && !timeLimit.timesUp()){
            Coordinates coordinates = cellsToReplace.remove();
            Outcome outcome = replacesCell.replace(coordinates, oldWorld);
            newWorld.set(coordinates, outcome.nextContents);
            cellsToReplace.addAll(outcome.neighbours);
        }

        return newWorld;
    }
}
