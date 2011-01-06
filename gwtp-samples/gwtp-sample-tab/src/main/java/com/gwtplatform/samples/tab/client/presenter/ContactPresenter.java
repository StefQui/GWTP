/**
 * Copyright 2010 ArcBees Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.tab.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;
import com.gwtplatform.samples.tab.client.NameTokens;

/**
 * @author Christian Goudreau
 */
public class ContactPresenter extends
    Presenter<ContactPresenter.MyView, ContactPresenter.MyProxy> {
  /**
   * {@link ContactPresenter}'s proxy.
   */
  @ProxyCodeSplit
  @NameToken(NameTokens.contactPage)
  @TabInfo(container = MainPagePresenter.class, priority = 1000, // The last
                                                                 // tab, no
                                                                 // matter what
  label = "Contact")
  public interface MyProxy extends TabContentProxyPlace<ContactPresenter> {
  }

  /**
   * {@link ContactPresenter}'s view.
   */
  public interface MyView extends View {
  }

  @Inject
  public ContactPresenter(final EventBus eventBus, final MyView view,
      final MyProxy proxy) {
    super(eventBus, view, proxy);
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetTabContent,
        this);
  }
}