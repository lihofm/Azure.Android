package com.azure.data.util.json

import com.google.gson.*
import com.azure.data.model.*
import com.azure.data.util.ContextProvider
import java.util.*

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
*/

val gson: Gson =
        GsonBuilder()
                .disableHtmlEscaping()
                .checkVerboseMode()
                .registerTypeAdapter(Date::class.java, DateTypeAdapter())
                .registerTypeAdapter(Timestamp::class.java, TimestampAdapter())
                .registerTypeAdapter(DictionaryDocument::class.java, DocumentAdapter())
                .create()


fun GsonBuilder.checkVerboseMode() : GsonBuilder {

    if (ContextProvider.verboseLogging) {
        this.setPrettyPrinting()
    }

    return this
}