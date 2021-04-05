package edu.kabi.live.ui.sort

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.kabi.live.R

class SortFragment : Fragment(R.layout.fragment_sort) {
    val viewModel by lazy { ViewModelProvider(this).get(SortViewModel::class.java) }

    private lateinit var sortAdapter: SortAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sortAdapter = SortAdapter(this, viewModel.sortList)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_sort)
        recyclerView.apply {
            layoutManager = GridLayoutManager(activity, 3)
            adapter = sortAdapter
        }

        viewModel.sortLiveData.observe(viewLifecycleOwner, Observer { result ->
            val sorts = result.getOrNull()
            if (sorts != null) {
                recyclerView.visibility = View.VISIBLE
                //bgImageView.visibility = View.GONE
                viewModel.sortList.clear()
                viewModel.sortList.addAll(sorts)
                recyclerView.adapter?.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "未能查询到任何地点", Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        })
    }


}
