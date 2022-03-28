package com.example.myapplication.adapter

import com.airbnb.epoxy.EpoxyAdapter
import com.example.myapplication.epoxymodel.DeepLinkEpoxyModel_
import com.example.myapplication.model.DeepLink

class DeeplinkAdapter(var listener: DeepLinkListener) : EpoxyAdapter() {

    fun addDeeplink(list: List<DeepLink>) {
        removeAllModels()
        list.forEach { link ->
            addModel(DeepLinkEpoxyModel_().deeplink(link).listener(listener))
        }
    }
}

interface DeepLinkListener {
    fun openDeeplink(url: String)
}