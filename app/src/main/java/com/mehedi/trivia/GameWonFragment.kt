package com.mehedi.trivia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mehedi.trivia.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false
        )


        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

                menuInflater.inflate(R.menu.winner_menu, menu)
                menu.findItem(R.id.aboutFragment).setVisible(false)
                if (null != activity?.packageManager?.let { shareIntent().resolveActivity(it) }) {
                    menu.findItem(R.id.share).setVisible(true)
                } else {
                    menu.findItem(R.id.share).setVisible(false)
                }


            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                return when (menuItem.itemId) {
                    R.id.share -> {
                        shareSuccess()
                        true
                    }

                    else -> false
                }


            }

        })



        return binding.root
    }


    private fun shareIntent(): Intent {


        val args = GameWonFragmentArgs.fromBundle(requireArguments())

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(
                Intent.EXTRA_TEXT,
                getString(R.string.share_success_text, args.numQ, args.numQ)
            )

        return shareIntent


    }


    private fun shareSuccess() {
        startActivity(shareIntent())
    }
}
