package com.example.cass

import com.example.BaseInitiator
import com.example.BaseResponder
import net.corda.core.flows.FlowSession
import net.corda.core.flows.InitiatedBy

@InitiatedBy(BaseInitiator::class)
class HackedResponder(othersideSession: FlowSession) : BaseResponder(othersideSession) {
    override fun getMessageFromBackend(): String {
        return "Robert'); DROP TABLE STATES;"
    }
}