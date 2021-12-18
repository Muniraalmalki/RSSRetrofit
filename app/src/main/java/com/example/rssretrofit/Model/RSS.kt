package com.example.rssretrofit.Model

import com.example.rssretrofit.Model.Entry.Channel

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable



@Root(name = "rss", strict = false)
class RSS constructor() : Serializable {


    @field:Element( name = "channel")
    var channel: Channel?=null


}
