package alizada.elvin.coinpay.presentation.ui.fragment.onboarding

import alizada.elvin.coinpay.databinding.FragmentOnboardingInfoBinding
import alizada.elvin.coinpay.presentation.ui.model.uiModel.OnboardingInfoUiModel
import alizada.elvin.coinpay.presentation.utils.viewBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class OnboardingInfoFragment : Fragment() {

    companion object {
        fun newInstance(model: OnboardingInfoUiModel): OnboardingInfoFragment {
            return OnboardingInfoFragment().apply {
                drawableResId = model.drawableResId
            }
        }
    }

    private val binding by viewBinding(FragmentOnboardingInfoBinding::inflate)

    private var drawableResId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivIllustration.setImageResource(drawableResId)
    }

}