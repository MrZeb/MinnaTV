package se.zeb.minnatv

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import se.zeb.minnatv.models.FavoriteShow
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : FragmentActivity(), Observer<List<FavoriteShow>> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_button.setOnClickListener { _ ->
            currentShowIndex += 1

            if (currentShowIndex == currentTvShows.size) {
                currentShowIndex = 0
            }

            Log.d("currentshow", currentShowIndex.toString() + " " + currentTvShows.size)

            show(currentTvShows[currentShowIndex])
        }

        initViewModel()
    }

    private fun initViewModel() {

        val viewModel = ViewModelProviders.of(this).get(TvScheduleViewModel::class.java)

        // Update the list when the data changes
        viewModel.tvSchedules.observe(this, this)
    }

    private lateinit var currentTvShows: List<FavoriteShow>

    private var currentShowIndex: Int = 0

    override fun onChanged(tvSchedules: List<FavoriteShow>?) {
        Log.d("TV", tvSchedules?.toString())

        if (tvSchedules != null && tvSchedules.size > 1) {
            next_button.visibility = View.VISIBLE
        } else {
            next_button.visibility = View.GONE
        }

        if (tvSchedules == null || tvSchedules.isEmpty()) {

            show_title.text = "Inget att kolla för Minna :(\nSorry babe!"
            sexy_seb.visibility = View.VISIBLE

            return
        }

        sexy_seb.visibility = View.GONE

        currentTvShows = tvSchedules

        show(currentTvShows[currentShowIndex])
    }

    private fun show(show: FavoriteShow) {
        show_title.text = "%s p\u00E5 %s kl %s".format(show.title, show.channel.displayName, SimpleDateFormat("HH:mm", Locale.GERMANY).format(show.start))
    }
}
