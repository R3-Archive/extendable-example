package com.example.ibm

import com.example.BaseInitiator
import com.example.BaseResponder
import net.corda.core.flows.FlowSession
import net.corda.core.flows.InitiatedBy

@InitiatedBy(BaseInitiator::class)
class IbmResponder(othersideSession: FlowSession) : BaseResponder(othersideSession) {
    override fun getMessageFromBackend(): String {
        Thread.sleep(1000)
        return "IBM-DB2-WEBLOGIC-WEBSPHERE-XML-ENGINE"
    }
}