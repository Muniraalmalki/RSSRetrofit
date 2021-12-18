package com.example.rssretrofit.Model.Entry

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "item", strict = false)
class Item constructor() : Serializable {


    @field:Element( name = "title")
    var title: String? = null
    @field:Element( name = "source")
    var source:String?=null
}