package com.learning.designMode.agentMode.staticAgent.test;

import com.learning.designMode.agentMode.staticAgent.Agent;
import com.learning.designMode.agentMode.staticAgent.Star;

/**
 * @Author: 皮皮
 * @Date: 2023/7/6 18:11
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Agent agent = new Agent(new Star());
        agent.personSignature();
        agent.show();
        agent.interview();
        agent.schedule();
        agent.signContract();
        agent.bookTickets();
    }
}
