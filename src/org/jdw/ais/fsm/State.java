/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdw.ais.fsm;

import java.util.HashMap;

/**
 *
 * @author JDW
 */
public class State {
    private HashMap<String, String> inputs;
    Integer nextStateId;
    Integer id;

    public State(int in_id) {
        this.id = in_id;
        this.inputs = new HashMap<>();
    }
    
    public void addInput(String name, String signal) {
        inputs.put(name, signal);
    }
    
    public void setNextState(int in_nextState) {
        this.nextStateId = in_nextState;
    }
}
