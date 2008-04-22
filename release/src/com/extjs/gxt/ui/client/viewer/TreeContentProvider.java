/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Ext GWT - derived implementation
 *******************************************************************************/
package com.extjs.gxt.ui.client.viewer;

/**
 * An interface to content providers for tree-structure-oriented viewers.
 * 
 * @see TreeViewer
 */
public interface TreeContentProvider extends ContentProvider {

  /**
   * Returns the child elements of the given parent.
   * 
   * @param parent the parent element
   * @param callback the content callback
   */
  public void getChildren(Object parent, AsyncContentCallback<Object> callback);

  /**
   * Returns the parent for the given element, or <code>null</code> indicating
   * that the parent can't be computed. In this case the tree-structured viewer
   * can't expand a given node correctly if requested.
   * 
   * @param child the element
   * @return the parent element, or <code>null</code> if it has none or if the
   *         parent cannot be computed
   */
  public Object getParent(Object child);

  /**
   * Returns whether the given element has children.
   * <p>
   * Intended as an optimization for when the viewer does not need the actual
   * children. Clients may be able to implement this more efficiently than
   * <code>getChildren</code>.
   * </p>
   * 
   * @param parent the element
   * @return <code>true</code> if the given element has children, and
   *         <code>false</code> if it has no children
   */
  public boolean hasChildren(Object parent);

}
