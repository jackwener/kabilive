package edu.kabi.live.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import edu.kabi.live.R

class PlayerActivity : AppCompatActivity() {
    var videoPlayer: StandardGSYVideoPlayer? = null
    var orientationUtils: OrientationUtils? = null
    private var url = "rtmp://47.94.222.34:1935/stream/1234"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val url = intent.getStringExtra("url")
        if (url != null) {
            this.url = url
        }

        init()
    }

    private fun init() {
        videoPlayer = findViewById<View>(R.id.player) as StandardGSYVideoPlayer
        videoPlayer!!.setUp(this.url, true, "测试视频")

        //增加封面
        //val imageView = ImageView(this)
        //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP)
        // imageView.setImageResource(R.mipmap.xxx1)
        //videoPlayer!!.thumbImageView = imageView
        //增加title
        videoPlayer!!.titleTextView.visibility = View.VISIBLE
        //设置返回键
        videoPlayer!!.backButton.visibility = View.VISIBLE
        //设置旋转
        orientationUtils = OrientationUtils(this, videoPlayer)
        //设置全屏按键功能,这是使用的是选择屏幕，而不是全屏
        videoPlayer!!.fullscreenButton
            .setOnClickListener { orientationUtils!!.resolveByClick() }
        //是否可以滑动调整
        videoPlayer!!.setIsTouchWiget(true)
        //设置返回按键功能
        videoPlayer!!.backButton.setOnClickListener { onBackPressed() }
        videoPlayer!!.startPlayLogic()
    }

    override fun onPause() {
        super.onPause()
        videoPlayer!!.onVideoPause()
    }

    override fun onResume() {
        super.onResume()
        videoPlayer!!.onVideoResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        GSYVideoManager.releaseAllVideos()
        if (orientationUtils != null) orientationUtils!!.releaseListener()
    }

    override fun onBackPressed() {
        //先返回正常状态
        if (orientationUtils!!.screenType == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            videoPlayer!!.fullscreenButton.performClick()
            return
        }
        //释放所有
        videoPlayer!!.setVideoAllCallBack(null)
        super.onBackPressed()
    }
}