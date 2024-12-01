package alizada.elvin.coinpay.presentation.ui.fragment.onboarding

import alizada.elvin.coinpay.R
import alizada.elvin.coinpay.databinding.FragmentOnboardingBinding
import alizada.elvin.coinpay.presentation.ui.adapter.pager.OnboardingPagerAdapter
import alizada.elvin.coinpay.presentation.ui.model.uiModel.OnboardingInfoUiModel
import alizada.elvin.coinpay.presentation.utils.viewBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2

class OnboardingFragment : Fragment() {

    private val binding by viewBinding(FragmentOnboardingBinding::inflate)

    private val pagerAdapter by lazy {
        OnboardingPagerAdapter(
            this.childFragmentManager,
            this.lifecycle,
            providePages(onboardingInfoUiModels),
        )
    }

    private val onboardingInfoUiModels by lazy { provideOnboardingInfoUiModels() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pagerOnboardingImages.adapter = pagerAdapter
        binding.pagerOnboardingImages.isSaveEnabled = false

        binding.pagerOnboardingImages.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tvDescription.text = onboardingInfoUiModels[position].description
                }
            }
        )

        binding.btnNext.setOnClickListener {
            val nextPage = binding.pagerOnboardingImages.currentItem + 1

            if (nextPage > onboardingInfoUiModels.lastIndex) {
                findNavController().navigate(R.id.dashboardFragment)
            } else {
                binding.pagerOnboardingImages.currentItem = nextPage
            }
        }
    }

    private fun providePages(models: List<OnboardingInfoUiModel>): List<OnboardingInfoFragment> {
        return models.map { model -> OnboardingInfoFragment.newInstance(model) }
    }

    private fun provideOnboardingInfoUiModels(): List<OnboardingInfoUiModel> {
        val pairs = listOf(
            R.drawable.img_trust to R.string.msg_onboarding_first,
            R.drawable.img_receive_money to R.string.msg_onboarding_second,
            R.drawable.img_send_money_abroad to R.string.msg_onboarding_third,
        )

        return pairs.map { eachPair ->
            OnboardingInfoUiModel(
                drawableResId = eachPair.first,
                description = getString(eachPair.second),
            )
        }
    }

}