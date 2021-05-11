package com.example.model

import java.io.Serializable

data class PlayListDetail(

    var id: Long? = null,
    var nextPageToken: String? = null,
    var items: MutableList<DetailVideo>? = null

) : Serializable

data class DetailVideo(

    var id: String? = null,
    var snippet: Snippet? = null,
    var thumbnails: Thumbnails,


) : Serializable

data class ResourceId(
    var videoId: String? = null

) : Serializable