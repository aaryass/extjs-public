/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.explorer.client.pages;

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Button;
import com.extjs.gxt.ui.client.widget.ButtonBar;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

public class DialogPage extends Container implements EntryPoint {

  public void onModuleLoad() {
    RootPanel.get().add(this);
  }

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    final Dialog simple = new Dialog();
    simple.setHeading("Dialog Test");
    simple.buttons = Dialog.YESNO;
    simple.addText(TestData.DUMMY_TEXT_SHORT);
    simple.setScrollMode(Scroll.AUTO);

    final Dialog complex = new Dialog();
    complex.border = false;
    complex.buttons = Dialog.OK;
    complex.setIconStyle("icon-app-side");
    complex.setHeading("BorderLayout Dialog");
    complex.setWidth(400);
    complex.setHeight(225);

    BorderLayout layout = new BorderLayout();
    complex.setLayout(layout);

    // west
    ContentPanel panel = new ContentPanel();
    panel.setHeading("West");
    BorderLayoutData data = new BorderLayoutData(LayoutRegion.WEST, 150, 100, 250);
    data.margins = new Margins(0, 5, 0, 0);
    data.split = true;
    data.collapsible = true;
    data.floatable = true;
    panel.setData(data);
    complex.add(panel);

    // center
    panel = new ContentPanel();
    panel.setHeading("West");
    data = new BorderLayoutData(LayoutRegion.CENTER);
    panel.setData(data);
    complex.add(panel);

    ButtonBar buttons = new ButtonBar();

    buttons.add(new Button("Simple", new SelectionListener() {
      public void componentSelected(ComponentEvent ce) {
        simple.show();
      }
    }));

    buttons.add(new Button("Layout", new SelectionListener() {
      public void componentSelected(ComponentEvent ce) {
        complex.show();
      }
    }));

    add(buttons);
    setLayout(new FlowLayout(4));
    layout(true);
  }

}
