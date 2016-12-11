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
    private HashMap<String, Signal.value> inputs;
    Integer nextStateId;
    Integer id;

    public State(int in_id) {
        this.id = in_id;
        this.inputs = new HashMap<>();
    }
    
    public void addInput(String in_signal, Signal.value in_value) {
        inputs.put(in_signal, in_value); 
    }
    
    public void setNextState(int in_nextState) {
        this.nextStateId = in_nextState;
    }
    
    public void update(final HashMap<String, Signal.value> in_signals) {
        Boolean toNextState = true;
        
        for  (String signalName: inputs.keySet()) {
            if (!toNextState) break;
            Signal.value signalValue = inputs.get(signalName);
            if (signalValue.equals(Signal.value.DC)) continue;
            
            toNextState = signalValue.equals(in_signals.get(signalName));
        }
    }
    
    public String toString() {
        String ret = "" + id;
        
        for  (String signalName: inputs.keySet()) {
            ret  += "," + inputs.get(signalName);
        }
        
        ret += "," + nextStateId;
        
        return ret;
    }
}
