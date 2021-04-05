package edu.kabi.live.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.kabi.live.R
import edu.kabi.live.ui.live.LiveAdapter
import edu.kabi.live.logic.model.Live

class FavoriteFragment : Fragment() {
    private val liveList = ArrayList<Live>();

    private lateinit var adapter: LiveAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_live, container, false)

        initLiveList()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_live)
        recyclerView.apply {
            layoutManager = GridLayoutManager(activity, 1)
            adapter = parentFragment?.let { LiveAdapter(it, liveList) }
        }

        return view
    }

    private fun initLiveList() {
    }

//    override fun onClick(view: View?) {
//        when (view?.id) {
//
//            else -> {
//            }
//        }
//    }
}