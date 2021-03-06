/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.swing.menu.MenuBarPascalAbstract;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.menu.MenuWindow;
import pasa.cbentley.swing.widgets.b.BMenuItem;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * Menu bar used by demo frames.
 * 
 * @author Charles Bentley
 *
 */
public class MenuBarPascalExplorerAbout extends MenuBarPascalAbstract implements ActionListener {

   /**
    * 
    */
   private static final long       serialVersionUID = -7322815975196057591L;


   private MenuDebugExplorer       menuDebug;

   protected final PascExplorerCtx pec;

   private MenuWindow              windowMenu;

   public MenuBarPascalExplorerAbout(PascExplorerCtx pec, CBentleyFrame frame) {
      super(pec.getPascalSwingCtx(), frame);
      this.pec = pec;

      SwingCtx sc = psc.getSwingCtx();

      windowMenu = new MenuWindow(sc);
      windowMenu.addCloseItem();
      this.add(windowMenu);

      //#mdebug
      menuDebug = new MenuDebugExplorer(pec.getPascalSwingCtx());
      this.add(menuDebug);
      //#enddebug

   }

   public void actionPerformed(ActionEvent e) {
   }

   public void guiUpdate() {
      super.guiUpdate();
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "PascalMenuBarDemo");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "PascalMenuBarDemo");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug
}
