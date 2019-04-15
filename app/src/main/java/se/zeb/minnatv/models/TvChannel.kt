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
    KANAL9("hd.kanal9.se", "Kanal 9"),
    MTV("", "MTV"),
    TV6("", "TV6"),
    TV4("", "TV4");

    companion object {
        fun fromRemote(remoteName: String?): TvChannel? {
            return values().firstOrNull { it.remoteName == remoteName }
        }
    }
}