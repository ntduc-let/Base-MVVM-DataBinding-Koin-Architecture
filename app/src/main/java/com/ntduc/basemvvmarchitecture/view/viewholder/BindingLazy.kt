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

package com.ntduc.basemvvmarchitecture.view.viewholder

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

inline fun <reified T : ViewDataBinding> BaseViewHolder.bindings(): Lazy<T> =
  lazy(LazyThreadSafetyMode.NONE) {
    requireNotNull(DataBindingUtil.bind(itemView)) { "cannot find the matched view to layout." }
  }
