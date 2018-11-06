package com.example

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.*

@InitiatedBy(BaseInitiator::class)
open class BaseResponder(val othersideSession: FlowSession) : FlowLogic<Unit>() {
    @Suspendable
    override fun call() {
        othersideSession.send(getMessageFromBackend())
    }


    open fun getMessageFromBackend(): String {
        return "Normal Computer"
    }
}