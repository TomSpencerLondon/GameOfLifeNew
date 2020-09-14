package com.codurance.replace.cell;

import com.codurance.replace.Contents;
import com.codurance.values.Cell;
import com.codurance.values.Nothing;
import com.codurance.values.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;

class DeterminesNextContentsTest {

    DeterminesNextContents subject = new DeterminesNextContents();

    @Test
    void zero_live_neighbours_dies() {
        Contents oldContents = new Cell();

        Collection<Point> neighbours = Arrays.asList(
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null)
        );
        Contents result = subject.determine(oldContents, neighbours);

        assertThat(result, instanceOf(Nothing.class));
    }

    @Test
    void two_live_neighbours_survives() {
        Contents oldContents = new Cell();

        Collection<Point> neighbours = Arrays.asList(
                new Point(new Cell(), null),
                new Point(new Cell(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null),
                new Point(new Nothing(), null)
        );
        Contents result = subject.determine(oldContents, neighbours);

        assertThat(result, instanceOf(Cell.class));
    }


}