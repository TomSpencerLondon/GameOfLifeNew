package com.codurance.replace.cell;

import com.codurance.replace.Contents;
import com.codurance.replace.Coordinates;
import com.codurance.replace.MutableWorld;
import com.codurance.replace.Outcome;
import com.codurance.values.Point;
import com.codurance.values.World;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReplacesCellTest {

    @InjectMocks
    ReplacesCell subject;

    @Mock
    GathersNeighbours gathersNeighbours;

    @Mock
    DeterminesNextContents determinesNextContents;

    @Test
    void test() {
        MutableWorld world = new MutableWorld();
        Contents oldContents = new Contents();
        Coordinates coordinates = new Coordinates(1337, 1337);
        world.set(coordinates, oldContents);

        Collection<Point> neighbours = new ArrayList<>();
        when(gathersNeighbours.gather(coordinates, world)).thenReturn(neighbours);

        Contents newContents = new Contents();

        when(determinesNextContents.determine(oldContents, neighbours)).thenReturn(newContents);

        Outcome result = subject.replace(coordinates, world);
        assertThat(result.neighbours, is(neighbours));
        assertThat(result.nextContents, is(newContents));
    }
}