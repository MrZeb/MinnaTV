package se.zeb.minnatv.models

/**
 * Forza Football
 * <p>
 * Created by Sebastian Fürle on 2018-01-14
 * <p>
 * Copyright © 2018 FootballAddicts. All rights reserved.
 */
enum class TvChannel(val remoteName: String, val displayName: String) {
    TV3("hd.tv3.se", "TV3"),
    MTV("dance.mtv.se", "MTV"),
    TV6("hd.tv6.se", "TV6"),
    TV4("tv4.se", "TV4"),
    KANAL9("hd.kanal9.se", "Kanal 9"),
    TNT("tnt-tv.se", "TNT");

    companion object {
        fun fromRemote(remoteName: String): TvChannel {
            return values().first { it.remoteName == remoteName }
        }
    }
}