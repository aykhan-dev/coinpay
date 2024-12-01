package alizada.elvin.coinpay.presentation.utils

import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.setStatusBarColor(@ColorRes colorId: Int) {
    activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), colorId)
}