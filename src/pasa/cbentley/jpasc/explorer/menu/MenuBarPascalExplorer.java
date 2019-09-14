/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.menu;

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import static java.awt.event.KeyEvent.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.KeyStroke;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.jpasc.swing.menu.MenuBarPascalAbstract;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.menu.MenuDebug;
import pasa.cbentley.swing.menu.MenuLanguage;
import pasa.cbentley.swing.menu.MenuWindow;
import pasa.cbentley.swing.widgets.b.BMenu;
import pasa.cbentley.swing.widgets.b.BMenuItem;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * Menu bar used by demo frames.
 * 
 * @author Charles Bentley
 *
 */
public class MenuBarPascalExplorer extends MenuBarPascalAbstract implements ActionListener {

   /**
    * 
    */
   private static final long       serialVersionUID = -7322815975196057591L;

   private BMenuItem               itemExit;

   private MenuDebugExplorer       menuDebug;

   private BMenu                   menuFile;

   private MenuLanguage            menuLanguage;

   private MenuWindow              windowMenu;

   private BMenu                   menuHelp;

   private BMenuItem               itemAboutHelp;

   protected final PascExplorerCtx pec;

   private BMenuItem               itemAboutFile;

   public MenuBarPascalExplorer(PascExplorerCtx pec, CBentleyFrame frame) {
      super(pec.getPascalSwingCtx(), frame);
      this.pec = pec;

      SwingCtx sc = psc.getSwingCtx();

      buildMenuFile(sc);

      this.add(psc.getPascalSkinManager().getRootMenu());

      menuLanguage = new MenuLanguage(sc);
      menuLanguage.addLanguage("English US", "en", "US");
      menuLanguage.addLanguage("Français FR", "fr", "FR");

      this.add(menuLanguage);

      windowMenu = new MenuWindow(sc);
      this.add(windowMenu);

      //#mdebug
      menuDebug = new MenuDebugExplorer(pec.getPascalSwingCtx());
      this.add(menuDebug);
      //#enddebug

      buildMenuHelp(sc);

   }

   public void actionPerformed(ActionEvent e) {
      Object src = e.getSource();
      if (src == itemExit) {
         psc.getCmds().cmdExit();
      } else if (src == itemAboutHelp || src == itemAboutFile) {
         //show the about tab
         pec.cmdShowAboutTab();
      }
   }

   private void buildMenuHelp(SwingCtx sc) {
      menuHelp = new BMenu(sc, "menu.help");
      menuHelp.setMnemonic(VK_H);

      itemAboutHelp = new BMenuItem(sc, this, "menu.item.about");
      itemAboutHelp.setAccelerator(KeyStroke.getKeyStroke(VK_A, modCtrlAltShift));
      menuHelp.add(itemAboutHelp);

      this.add(menuHelp);
   }

   private void buildMenuFile(SwingCtx sc) {
      menuFile = new BMenu(sc, "menu.explorer");
      menuFile.setMnemonic(VK_F);
      itemExit = new BMenuItem(sc, this, "menu.item.exit");
      itemExit.setMnemonic(VK_E);
      itemExit.setAccelerator(KeyStroke.getKeyStroke(VK_Q, CTRL_DOWN_MASK));

      itemAboutFile = new BMenuItem(sc, this, "menu.item.about");
      itemAboutFile.setAccelerator(KeyStroke.getKeyStroke(VK_A, modCtrlAltShift));

      menuFile.add(itemAboutFile);
      menuFile.add(itemExit);

      this.add(menuFile);
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
   //#enddebug

   private void toStringPrivate(Dctx dc) {

   }

}
