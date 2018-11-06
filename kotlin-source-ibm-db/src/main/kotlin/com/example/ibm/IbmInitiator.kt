package com.example.ibm

import com.example.BaseInitiator
import net.corda.core.flows.StartableByRPC
import net.corda.core.flows.StartableByService

@StartableByRPC
@StartableByService
class IbmInitiator : BaseInitiator() {

    override fun getFLowName(): String {
        return "SuperIBM Mainfame V2"
    }
}