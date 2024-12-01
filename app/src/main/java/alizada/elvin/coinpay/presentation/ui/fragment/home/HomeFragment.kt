package alizada.elvin.coinpay.presentation.ui.fragment.home

import alizada.elvin.coinpay.R
import alizada.elvin.coinpay.databinding.FragmentHomeBinding
import alizada.elvin.coinpay.presentation.utils.setStatusBarColor
import alizada.elvin.coinpay.presentation.utils.viewBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    private val binding by viewBinding(FragmentHomeBinding::inflate)

    private var originalStatusBarColor: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Store original color
        originalStatusBarColor = activity?.window?.statusBarColor ?: 0

        // Set new color
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.background_bgAccent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.window?.statusBarColor = originalStatusBarColor
    }

}