package com.codurance;

import org.mockito.Mock;

public class SimulatesConway {

    GenerateSeedWorld generatesSeedWorld;
    OutputsWorld outputsWorld;

    public void simulate() {
        World seedWorld = generatesSeedWorld.generate();
        outputsWorld.output(seedWorld);
    }
}
