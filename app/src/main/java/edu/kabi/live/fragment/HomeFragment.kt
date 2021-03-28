package edu.kabi.live.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import edu.kabi.live.PlayerActivity
import edu.kabi.live.R

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val btn: Button = view.findViewById(R.id.play_button)
        btn.setOnClickListener(this)
        return view
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.play_button -> {
                val intent = Intent(
                    activity,
                    PlayerActivity::class.java
                ).putExtra(
                    "url", "rtmp://47.94.222.34:1935/stream/" + "1234"
                )
                startActivity(intent)
            }

            else -> {
            }
        }
    }
}