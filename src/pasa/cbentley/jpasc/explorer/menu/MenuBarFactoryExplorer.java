/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.menu;

import javax.swing.JMenuBar;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.about.TabsExplorerAboutRoot;
import pasa.cbentley.jpasc.explorer.panel.daemon.TabsNoobGifs;
import pasa.cbentley.jpasc.explorer.panel.tab.TabConnecting;
import pasa.cbentley.jpasc.explorer.panel.tab.TabJPascExplorer;
import pasa.cbentley.jpasc.explorer.panel.tab.TabWaitForDaemon;
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
      } else if (owner instanceof TabsExplorerAboutRoot) {
         //we want a menu bar for the about frame
         return new MenuBarPascalExplorerAbout(pec, frame);
      } else if (owner instanceof TabConnecting) {
         return null;
      } else if (owner instanceof TabWaitForDaemon) {
         return new MenuBarPascalExplorerNoConnection(pec, frame);
      } else if (owner instanceof TabsNoobGifs) {
         return new MenuBarPascalExplorerDaemonHelp(pec, frame);
      } else {
         //the default menu
         return new MenuBarPascalExplorerAbout(pec, frame);
      }
   }
}
