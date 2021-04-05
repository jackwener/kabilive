package edu.kabi.live.ui.live

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.kabi.live.R

class HomeFragment : Fragment(R.layout.fragment_live) {

    val viewModel by lazy { ViewModelProvider(this).get(LiveViewModel::class.java) }

    private lateinit var liveAdapter: LiveAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        liveAdapter = LiveAdapter(this, viewModel.liveList)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_live)
        recyclerView.apply {
            layoutManager = GridLayoutManager(activity, 1)
            adapter = liveAdapter
        }

        viewModel.liveGetLiveData.observe(viewLifecycleOwner, Observer { result ->
            val lives = result.getOrNull()
            if (lives != null) {
                recyclerView.visibility = View.VISIBLE
                //bgImageView.visibility = View.GONE
                viewModel.liveList.clear()
                viewModel.liveList.addAll(lives)
                recyclerView.adapter?.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "未能查询到任何地点", Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        })
    }
}