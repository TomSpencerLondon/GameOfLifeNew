package com.codurance;

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

    @Test
    void zero_generations() {
        // Arrange
        World seedWorld = new World();
        when(generatesSeedWorld.generate())
                .thenReturn(seedWorld);
        // Act
        subject.simulate();
        // Assert

        verify(outputsWorld).output(seedWorld);
    }
}
