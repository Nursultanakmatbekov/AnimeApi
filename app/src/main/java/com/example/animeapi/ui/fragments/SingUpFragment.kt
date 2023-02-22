package com.example.animeapi.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.data.models.auth.AuthModel
import com.example.animeapi.data.preferences.userdata.UserPreferencesData
import com.example.animeapi.extensions.showText
import com.excample.animeapp.R
import com.excample.animeapp.databinding.FragmentSingUpBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.math.log

@AndroidEntryPoint
class SingUpFragment :
    BaseFragment<FragmentSingUpBinding, SingUpViewModel>(R.layout.fragment_sing_up) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSingUpBinding::bind)
    override val viewModel: SingUpViewModel by viewModels()

    override fun setupSubscribes() = with(binding) {
            binding.btnSingUp.setOnClickListener {
                val email = edLogin.text.toString()
                val password = edPassword.text.toString()
                val authModel = AuthModel("password", email, password)
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
                            findNavController().navigate(
                                R.id.action_singUpFragment_to_homeFragment
                            )
                        }
                    }
                )
            }
        }
    }