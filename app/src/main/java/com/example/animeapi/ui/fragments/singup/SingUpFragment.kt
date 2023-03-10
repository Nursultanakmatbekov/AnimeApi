package com.example.animeapi.ui.fragments.singup

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.data.models.auth.AuthModel
import com.example.animeapi.data.preferences.userdata.UserPreferencesData
import com.example.animeapi.extensions.showText
import com.excample.animeapp.R
import com.excample.animeapp.databinding.FragmentSingUpBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SingUpFragment :
    BaseFragment<FragmentSingUpBinding, SingUpViewModel>(R.layout.fragment_sing_up) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSingUpBinding::bind)
    override val viewModel: SingUpViewModel by viewModels()

    override fun setupSubscribes() = with(binding) {
        binding.btnSingUp.setOnClickListener {
            val login = edLogin.text.toString()
            val password = edPassword.text.toString()

            if (login.isEmpty() && password.isEmpty()) {
                Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_SHORT).show()
            }

            val authModel = AuthModel("password", login, password)
            viewModel.postUserData(authModel).subscribe(
                onError = {
                    Log.e("tag", "log: $it")
                },
                onSuccess = { token ->
                    showText("$token")
                    if (token != null) {
                        userPreferencesData.apply {
                            isAuthorized = true
                            accessToken = token.accessToken
                            refreshToken = token.refreshToken
                        }
                        requireActivity().findNavController(R.id.nav_host_fragment_container)
                            .navigate(R.id.action_singUpFlowFragment_to_homeFlowFragment)
                    }
                })
        }
    }
}