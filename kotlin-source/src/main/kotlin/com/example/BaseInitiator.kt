package com.example

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.InitiatingFlow
import net.corda.core.flows.StartableByRPC
import net.corda.core.flows.StartableByService
import net.corda.core.utilities.unwrap

@InitiatingFlow
@StartableByRPC
@StartableByService
open class BaseInitiator : FlowLogic<String>() {
    @Suspendable
    override fun call(): String {
        val partiesToTalkTo = serviceHub.networkMapCache.allNodes
                .filterNot { it.legalIdentities.first() in serviceHub.networkMapCache.notaryIdentities }
                .filterNot { it.legalIdentities.first().name == ourIdentity.name }.map { it.legalIdentities.first() }
        val responses = ArrayList<String>()
        for (party in partiesToTalkTo) {
            val session = initiateFlow(party)
            val received = session.receive<String>().unwrap { it }
            responses.add(party.name.toString() + " responded with backend: " + received)
        }
        return "${getFLowName()} received the following \n" + responses.joinToString("\n") { it }
    }

    open fun getFLowName(): String {
        return "Normal Computer"
    }
}