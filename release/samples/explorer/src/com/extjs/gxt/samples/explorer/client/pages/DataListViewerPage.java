/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.explorer.client.pages;

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.viewer.DataListViewer;
import com.extjs.gxt.ui.client.viewer.ModelComparator;
import com.extjs.gxt.ui.client.viewer.ModelContentProvider;
import com.extjs.gxt.ui.client.viewer.ModelLabelProvider;
import com.extjs.gxt.ui.client.viewer.Viewer;
import com.extjs.gxt.ui.client.viewer.ViewerFilter;
import com.extjs.gxt.ui.client.viewer.ViewerSorter;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.DataList;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.TextToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

public class DataListViewerPage extends Container implements EntryPoint {

  public void onModuleLoad() {
    RootPanel.get().add(this);
  }

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);

    FlowLayout layout = new FlowLayout();
    layout.margin = 10;
    setLayout(layout);

    DataList list = new DataList();
    list.flat = true;
    list.selectionMode = SelectionMode.MULTI;

    ContentPanel panel = new ContentPanel();
    panel.frame = true;
    panel.collapsible = true;
    panel.animCollapse = false;
    panel.buttonAlign = HorizontalAlignment.CENTER;
    panel.setIconStyle("icon-list");
    panel.setHeading("DataListViewer Demo");
    panel.setLayout(new FitLayout());
    panel.add(list);
    panel.setSize(230, 250);

    final DataListViewer viewer = new DataListViewer(list);
    viewer.setContentProvider(new ModelContentProvider());
    viewer.setLabelProvider(new ModelLabelProvider() {
      public String getIconStyle(ModelData element) {
        return "icon-chart";
      }
    });

    // sorter & filter
    final ViewerSorter sorter = new ViewerSorter(new ModelComparator());
    final ViewerFilter filter = new ViewerFilter<Object, ModelData>() {
      public boolean select(Viewer viewer, Object parent, ModelData element) {
        if (((String) element.get("name")).charAt(0) == 'A') {
          return false;
        }
        return true;
      }
    };

    viewer.setInput(TestData.getStocks());

    ToolBar toolBar = new ToolBar();

    TextToolItem sort = new TextToolItem("Sort");
    sort.setIconStyle("my-icon-asc");
    sort.addSelectionListener(new SelectionListener() {
      public void componentSelected(ComponentEvent ce) {
        viewer.setSorter(sorter);
      }
    });

    TextToolItem filterItem = new TextToolItem("Filter A's");
    filterItem.setIconStyle("icon-filter");
    filterItem.addSelectionListener(new SelectionListener() {
      public void componentSelected(ComponentEvent ce) {
        viewer.addFilter(filter);
      }
    });
    toolBar.add(sort);
    toolBar.add(new SeparatorToolItem());
    toolBar.add(filterItem);
    panel.setTopComponent(toolBar);

    add(panel);

  }

}
