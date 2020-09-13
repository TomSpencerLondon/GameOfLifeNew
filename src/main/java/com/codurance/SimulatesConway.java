package com.codurance;

public class SimulatesConway {

    GenerateSeedWorld generatesSeedWorld;
    ReplacesWorld replacesWorld;
    OutputsWorld outputsWorld;

    public void simulate(int generations, int timeLimit) {
        World world = generatesSeedWorld.generate();

        for (int i = 0; i < generations; i++){
            outputsWorld.output(world);
            world = replacesWorld.replace(world, timeLimit);
        }
        outputsWorld.output(world);


    }
}
