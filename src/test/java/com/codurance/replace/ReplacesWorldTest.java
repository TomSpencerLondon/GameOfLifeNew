package com.codurance.replace;

import com.codurance.values.World;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReplacesWorldTest {
    @InjectMocks
    ReplacesWorld subject;

    @Mock
    KeepsTime keepsTime;

    @Mock
    ReplacesCell replacesCell;

    @Test
    void one_cell_to_be_replaced() {
        TimeLimit timeLimit = mock(TimeLimit.class);
        long timeLimitInMS = 42l;
        when(timeLimit.timesUp()).thenReturn(false, true);
        when(keepsTime.keep(timeLimitInMS)).thenReturn(timeLimit);
        MutableWorld world1 = new MutableWorld();
        Contents nextContents = new Contents();

        Outcome outcome = new Outcome(nextContents, new ArrayList<>());
        when(replacesCell.replace(new Coordinates(0, 0), world1)).thenReturn(outcome);

        World result = subject.replace(world1, 42l);

        assertThat(result.at(new Coordinates(0, 0)), is(nextContents));
    }

    @Test
    void two_cells_to_be_replaced() {
        TimeLimit timeLimit = mock(TimeLimit.class);
        when(timeLimit.timesUp()).thenReturn(false, false, true);
        when(keepsTime.keep(42l)).thenReturn(timeLimit);
        MutableWorld world1 = new MutableWorld();
        Contents nextContents = new Contents();
        Collection<Coordinates> neighbours = Arrays.asList(new Coordinates(50, 50));
        Outcome outcome = new Outcome(nextContents, neighbours);
        when(replacesCell.replace(new Coordinates(0, 0), world1)).thenReturn(outcome);
        Contents nextContents2 = new Contents();
        Outcome outcome2 = new Outcome(nextContents2, new ArrayList<>());
        when(replacesCell.replace(new Coordinates(50, 50), world1)).thenReturn(outcome2);

        World result = subject.replace(world1, 42l);

        assertThat(result.at(new Coordinates(0, 0)), is(nextContents));

        assertThat(result.at(new Coordinates(50, 50)), is(nextContents2));
    }
}
