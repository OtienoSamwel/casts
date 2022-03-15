package com.os.casts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.os.casts.ui.services.PlayerService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MediaDrawerFragment @Inject constructor() : BottomSheetDialogFragment() {


    @Inject
    lateinit var castPlayer: SimpleExoPlayer
    private val args: MediaDrawerFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!castPlayer.isPlaying) {
            startPlayer(args.audioUrl)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media_drawer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playerView: StyledPlayerView = view.findViewById(R.id.drawer_player_view)
        playerView.player = castPlayer
    }

    private fun startPlayer(url: String) {
        requireActivity().startService(
            Intent(activity, PlayerService::class.java).apply {
                action = url
            }
        )
    }
}