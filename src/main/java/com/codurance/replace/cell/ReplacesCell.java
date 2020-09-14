package com.codurance.replace.cell;

import com.codurance.replace.Contents;
import com.codurance.replace.Coordinates;
import com.codurance.replace.MutableWorld;
import com.codurance.replace.Outcome;
import com.codurance.values.Point;
import com.codurance.values.World;
import org.mockito.Mock;

import java.util.Collection;

public class ReplacesCell {
    GathersNeighbours gathersNeighbours;
    DeterminesNextContents determinesNextContents;

    public Outcome replace(Coordinates coordinates, World world) {
        Collection<Point> neighbours = gathersNeighbours.gather(coordinates, world);
        Contents newContents = determinesNextContents.determine(world.at(coordinates), neighbours);
        return new Outcome(newContents, neighbours);
    }
}
