package se.zeb.minnatv.models

import java.util.*

/**
 * Forza Football
 * <p>
 * Created by Sebastian Fürle on 2018-01-14
 * <p>
 * Copyright © 2018 FootballAddicts. All rights reserved.
 */
data class FavoriteShow(
        val title: String,
        val channel: TvChannel,
        val start: Date,
        val stop: Date
)