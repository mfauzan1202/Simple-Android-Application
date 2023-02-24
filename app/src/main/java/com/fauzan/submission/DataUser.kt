package com.fauzan.submission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataUser (
    var username: String,
    var name: String,
    var location: String,
    var repo: String,
    var company: String,
    var followers: String,
    var following: String,
    var avatar: Int,
) : Parcelable