package se.zeb.minnatv.models

/**
 * Forza Football
 * <p>
 * Created by Sebastian Fürle on 2018-01-14
 * <p>
 * Copyright © 2018 FootballAddicts. All rights reserved.
 */
enum class FavoriteShowType(val title: String) {
    BORDER_CONTROL_AUSTRALIA("Gränsbevakarna Australien"),
    LYXFALLAN("Lyxfällan"),
    SEX_AND_THE_CITY("Sex and the City"),
    HOW_I_MET_YOUR_MOTHER("How I Met Your Mother"),
    BORDER_CONTROL_CANADA("Gränsbevakarna Kanada");

    override fun toString(): String{
        return "FavoriteShowType(title='$title')"
    }


}