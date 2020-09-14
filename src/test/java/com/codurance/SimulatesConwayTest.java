package com.codurance;

import com.codurance.replace.MutableWorld;
import com.codurance.replace.ReplacesWorld;
import com.codurance.values.World;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SimulatesConwayTest {
    @InjectMocks
    SimulatesConway subject;

    @Mock
    GenerateSeedWorld generatesSeedWorld;

    @Mock
    OutputsWorld outputsWorld;

    @Mock
    ReplacesWorld replacesWorld;

    @Test
    void zero_generations() {
        // Arrange
        World seedWorld = new MutableWorld();
        when(generatesSeedWorld.generate())
                .thenReturn(seedWorld);
        // Act
        subject.simulate(0, 1337);
        // Assert

        verify(outputsWorld).output(seedWorld);
    }

    @Test
    void one_generation() {
        World seedWorld = new MutableWorld();
        when(generatesSeedWorld.generate())
                .thenReturn(seedWorld);

        World world2 = new MutableWorld();
        when(replacesWorld.replace(seedWorld, 1337)).thenReturn(world2);
        // Act
        subject.simulate(1, 1337);
        // Assert

        verify(outputsWorld).output(seedWorld);
        verify(outputsWorld).output(world2);
    }
}
