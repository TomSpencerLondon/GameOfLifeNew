package com.codurance.replace.cell;

import com.codurance.replace.Contents;
import com.codurance.values.Cell;
import com.codurance.values.Nothing;
import com.codurance.values.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;

class DeterminesNextContentsTest {

    DeterminesNextContents subject = new DeterminesNextContents();

    @Test
    void zero_live_neighbours_dies() {
        Contents oldContents = new Cell();

        Collection<Point> neighbours = liveNeighbours(0);
        Contents result = subject.determine(oldContents, neighbours);

        assertThat(result, instanceOf(Nothing.class));
    }

    @Test
    void two_live_neighbours_survives() {
        Contents oldContents = new Cell();

        Collection<Point> neighbours = liveNeighbours(2);
        Contents result = subject.determine(oldContents, neighbours);

        assertThat(result, instanceOf(Cell.class));
    }


    private Collection<Point> liveNeighbours(int number) {
        List<Point> neighbours = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            neighbours.add(new Point(i < number ? new Cell() : new Nothing(), null));
        }

        return neighbours;
    }
}