package edu.kabi.live.ui.sort

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import edu.kabi.live.R

class SortAdapter(private val fragment: Fragment, private val sortList: List<String>) :
    RecyclerView.Adapter<SortAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val sortImage: ImageView = view.findViewById(R.id.sortImage)
        val sortName: TextView = view.findViewById(R.id.sort_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sort_item, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {

        }
        return holder
    }

    override fun getItemCount() = sortList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sort = sortList[position]
        //holder.sortImage.setImageResource(sort.)
        holder.sortName.text = sort
    }
}
