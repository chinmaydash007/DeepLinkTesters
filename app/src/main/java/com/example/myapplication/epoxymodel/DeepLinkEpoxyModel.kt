package com.example.myapplication.epoxymodel

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.myapplication.R
import com.example.myapplication.adapter.DeepLinkListener
import com.example.myapplication.model.DeepLink

@EpoxyModelClass
abstract class DeepLinkEpoxyModel : EpoxyModelWithHolder<DeepLinkEpoxyModel.Holder>() {

    @EpoxyAttribute
    lateinit var deeplink: DeepLink

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var listener: DeepLinkListener


    override fun bind(holder: Holder) {
        super.bind(holder)

        holder.deeplinkTextView.text = deeplink.link
        holder.button.text = deeplink.name
        holder.button.setOnClickListener {
            listener.openDeeplink(deeplink.link)
        }


    }

    class Holder : EpoxyHolder() {
        lateinit var deeplinkTextView: TextView
        lateinit var button: Button
        override fun bindView(itemView: View) {
            deeplinkTextView = itemView.findViewById(R.id.textView7)
            button = itemView.findViewById(R.id.button2)
        }

    }

    override fun getDefaultLayout(): Int {
        return R.layout.deep_link_layout
    }
}