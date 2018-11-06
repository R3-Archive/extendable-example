package com.example.cass

import co.paralleluniverse.fibers.Suspendable
import com.example.BaseInitiator
import net.corda.core.flows.StartableByRPC
import net.corda.core.flows.StartableByService
import net.corda.core.utilities.unwrap

@StartableByRPC
@StartableByService
class NotaryOnlyInitiator : BaseInitiator() {

    @Suspendable
    override fun call(): String {
        return "Notary Communicator received:\n" + serviceHub.networkMapCache.notaryIdentities.map {
            "Notary: ${it.name.organisation} is using a " + initiateFlow(it).receive<String>().unwrap { it }
        }.joinToString("\n") { it }
    }
}