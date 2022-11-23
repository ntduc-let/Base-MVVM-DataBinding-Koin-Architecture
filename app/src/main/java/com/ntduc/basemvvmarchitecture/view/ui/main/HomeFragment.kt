/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ntduc.basemvvmarchitecture.view.ui.main

import android.graphics.Color
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.ntduc.basemvvmarchitecture.R
import com.skydoves.bindables.BindingFragment
import com.ntduc.basemvvmarchitecture.extensions.gone
import com.ntduc.basemvvmarchitecture.extensions.visible
import com.ntduc.basemvvmarchitecture.view.adapter.PosterAdapter
import org.koin.android.viewmodel.ext.android.getSharedViewModel
import com.ntduc.basemvvmarchitecture.databinding.FragmentHomeBinding

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    super.onCreateView(inflater, container, savedInstanceState)
    return binding {
      viewModel = getSharedViewModel()
      adapter = PosterAdapter()
    }.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding {
      fab.setOnClickListener {
        TransitionManager.beginDelayedTransition(
          container,
          getTransform(it, card)
        )
        card.visible()
        it.gone(true)
      }

      card.setOnClickListener {
        TransitionManager.beginDelayedTransition(
          container,
          getTransform(it, fab)
        )
        fab.visible()
        it.gone(true)
      }
    }
  }

  private fun getTransform(mStartView: View, mEndView: View): MaterialContainerTransform {
    return MaterialContainerTransform().apply {
      startView = mStartView
      endView = mEndView
      addTarget(mEndView)
      pathMotion = MaterialArcMotion()
      duration = 550
      scrimColor = Color.TRANSPARENT
    }
  }
}
