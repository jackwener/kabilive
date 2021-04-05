package edu.kabi.live.ui.live

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import edu.kabi.live.R
import edu.kabi.live.logic.model.Live
import edu.kabi.live.ui.PlayerActivity

class LiveAdapter(private val fragment: Fragment, private val liveList: List<Live>) :
    RecyclerView.Adapter<LiveAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val liveName: TextView = view.findViewById(R.id.live_name)
        val liveDescription: TextView = view.findViewById(R.id.live_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.live_item, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val live = liveList[position]
            val intent = Intent(parent.context, PlayerActivity::class.java).apply {
                putExtra("url", live.url)
            }
            fragment.startActivity(intent)

//            val activity = fragment.activity
//            if (activity is WeatherActivity) {
//                activity.drawerLayout.closeDrawers()
//                activity.viewModel.locationLng = place.location.lng
//                activity.viewModel.locationLat = place.location.lat
//                activity.viewModel.placeName = place.name
//                activity.refreshWeather()
//            } else {
//                val intent = Intent(parent.context, WeatherActivity::class.java).apply {
//                    putExtra("location_lng", place.location.lng)
//                    putExtra("location_lat", place.location.lat)
//                    putExtra("place_name", place.name)
//                }
//                fragment.startActivity(intent)
//                activity?.finish()
//            }
            //fragment.viewModel.savePlace(place)
        }
        return holder
    }

    override fun getItemCount() = liveList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val live = liveList[position]
        holder.liveName.text = live.creatorId
        holder.liveDescription.text = live.description
    }
}
