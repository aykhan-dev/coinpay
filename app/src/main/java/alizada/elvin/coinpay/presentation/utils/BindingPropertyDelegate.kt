package alizada.elvin.coinpay.presentation.utils

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.launch
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding(
    crossinline inflate: (LayoutInflater) -> T
) = object : ReadOnlyProperty<Fragment, T> {

    private var binding: T? = null

    init {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.DESTROYED) {
                binding = null
            }
        }
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        binding?.let { return it }

        val lifecycle = viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            error("Cannot access binding as Fragment views are destroyed")
        }

        val layoutInflater = LayoutInflater.from(thisRef.context)

        return inflate(layoutInflater).also { binding = it }
    }

}