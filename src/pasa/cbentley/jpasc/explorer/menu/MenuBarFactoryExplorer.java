/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.menu;

import javax.swing.JMenuBar;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.TabJPascExplorer;
import pasa.cbentley.jpasc.swing.menu.MenuBarPascalFactory;
import pasa.cbentley.swing.imytab.ITabMenuBarFactory;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * Create a menu bar.
 * 
 * What if the panel is decided by the brander?
 * 
 * @author Charles Bentley
 *
 */
public class MenuBarFactoryExplorer extends MenuBarPascalFactory implements ITabMenuBarFactory {


   protected final PascExplorerCtx pec;

   public MenuBarFactoryExplorer(PascExplorerCtx pec) {
      super(pec.getPascalSwingCtx());
      this.pec = pec;
   }

   public JMenuBar getMenuBar(Object owner, CBentleyFrame frame) {
      if (owner instanceof TabJPascExplorer) {
         return new MenuBarPascalExplorer(pec, frame);
      } else {
         return super.getMenuBar(owner, frame);
      }
   }
}
