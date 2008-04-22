/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.explorer.client.pages;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Button;
import com.extjs.gxt.ui.client.widget.ButtonBar;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.SplitButton;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.TextMenuItem;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Element;

public class SplitButtonPage extends Container implements EntryPoint {

  public void onModuleLoad() {

  }

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);

    SelectionListener listener = new SelectionListener() {
      public void componentSelected(ComponentEvent ce) {
        Button btn = (Button) ce.component;
        Info.display("Click Event", "The '{0}' button was clicked.", btn.getText());
      }
    };

    ButtonBar buttonBar = new ButtonBar();

    Menu menu = new Menu();
    menu.add(new TextMenuItem("Item 1"));
    menu.add(new TextMenuItem("Item 2"));

    SplitButton button = new SplitButton();
    button.setText("Split Button");
    button.addSelectionListener(listener);
    button.setMenu(menu);

    buttonBar.add(button);

    setLayout(new FlowLayout(8));
    add(buttonBar);
  }

}
