package com.example.rssretrofit.Model.Entry

import android.content.ClipData
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "channel", strict = false)
class Channel @JvmOverloads constructor(

    @field:Element(name = "title")
    @param:Element(name = "title") val title: String? = null ,

    @field:ElementList(inline=true,name = "item")
    @param:ElementList(name = "item")
    val item: List<Item>? = null


) : Serializable {


}