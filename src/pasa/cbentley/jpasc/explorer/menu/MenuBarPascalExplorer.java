/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.menu;

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_E;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_H;
import static java.awt.event.KeyEvent.VK_P;
import static java.awt.event.KeyEvent.VK_Q;
import static java.awt.event.KeyEvent.VK_T;
import static java.awt.event.KeyEvent.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.KeyStroke;

import pasa.cbentley.core.src4.interfaces.ICommandable;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.swing.cmds.ICommandableConnect;
import pasa.cbentley.jpasc.swing.menu.MenuBarPascalAbstract;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.menu.MenuLanguage;
import pasa.cbentley.swing.menu.MenuWindow;
import pasa.cbentley.swing.widgets.b.BCMenuItem;
import pasa.cbentley.swing.widgets.b.BMenu;
import pasa.cbentley.swing.widgets.b.BMenuItem;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * Menu bar used by demo frames.
 * 
 * @author Charles Bentley
 *
 */
public class MenuBarPascalExplorer extends MenuBarPascalAbstract implements ActionListener, ICommandable {

   /**
    * 
    */
   private static final long               serialVersionUID = -7322815975196057591L;

   private BMenuItem                       itemExit;

   private MenuDebugExplorer               menuDebug;

   private BMenu                           menuFile;

   private MenuLanguage                    menuLanguage;

   private MenuWindow                      windowMenu;

   private BMenu                           menuHelp;

   private BMenuItem                       itemAboutHelp;

   protected final PascExplorerCtx         pec;

   private BMenuItem                       itemAboutFile;

   private BCMenuItem                      itemToggle;

   private BCMenuItem<ICommandable>        itemConnectTestNet;

   private BCMenuItem<ICommandable>        itemDisconnect;

   private BCMenuItem<ICommandableConnect> itemConnectRealNet;

   private BMenuItem                       itemDaemonHelp;

   private BCMenuItem<ICommandable> itemLock;

   private BCMenuItem<ICommandable> itemUnLock;

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
      } else if (src == itemConnectTestNet) {
         //show the about tab
         psc.getPCtx().getRPCConnection().connectLocalhostTestNet();
      } else if (src == itemDaemonHelp) {
         //show the about tab
         pec.cmdShowDaemonHelp();
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

      itemToggle = new BCMenuItem<ICommandable>(sc, this, psc.getCmds().getCmdTogglePrivacyCtx());
      itemToggle.setMnemonic(VK_P);
      itemToggle.setAccelerator(KeyStroke.getKeyStroke(VK_P, CTRL_DOWN_MASK));

      itemExit = new BMenuItem(sc, this, "menu.item.exit");
      itemExit.setMnemonic(VK_E);
      itemExit.setAccelerator(KeyStroke.getKeyStroke(VK_Q, CTRL_DOWN_MASK));

      itemAboutFile = new BMenuItem(sc, this, "menu.item.about");
      itemAboutFile.setAccelerator(KeyStroke.getKeyStroke(VK_A, modCtrlAltShift));

      itemDaemonHelp = new BMenuItem(sc, this, "menu.daemon.help");
      itemDaemonHelp.setAccelerator(KeyStroke.getKeyStroke(VK_H, modCtrlAltShift));

      itemConnectRealNet = new BCMenuItem<ICommandableConnect>(sc, pec, psc.getCmds().getCmdConnectConnect());
      itemConnectRealNet.setMnemonic(VK_C);
      itemConnectRealNet.setAccelerator(KeyStroke.getKeyStroke(VK_C, modCtrlAltShift));
      itemConnectRealNet.startListeningToCmdChanges();

      itemDisconnect = new BCMenuItem<ICommandable>(sc, this, psc.getCmds().getCmdConnectDisconnect());
      itemDisconnect.setMnemonic(VK_D);
      itemDisconnect.setAccelerator(KeyStroke.getKeyStroke(VK_D, modCtrlAltShift));
      itemDisconnect.startListeningToCmdChanges();

      itemConnectTestNet = new BCMenuItem<ICommandable>(sc, this, psc.getCmds().getCmdConnectTestNet());
      itemConnectTestNet.setMnemonic(VK_T);
      itemConnectTestNet.setAccelerator(KeyStroke.getKeyStroke(VK_T, modCtrlAltShift));
      itemConnectTestNet.startListeningToCmdChanges();

      
      itemLock = new BCMenuItem<ICommandable>(sc, this, psc.getCmds().getCmdLockLock());
      itemLock.setMnemonic(VK_L);
      itemLock.setAccelerator(KeyStroke.getKeyStroke(VK_S, modAltShit));
      
      itemUnLock = new BCMenuItem<ICommandable>(sc, this, psc.getCmds().getCmdLockUnlock());
      itemUnLock.setMnemonic(VK_U);
      itemUnLock.setAccelerator(KeyStroke.getKeyStroke(VK_D, modAltShit));
      
      
      menuFile.add(itemToggle);
      menuFile.addSeparator();
      menuFile.add(itemAboutFile);
      menuFile.add(itemDaemonHelp);
      menuFile.addSeparator();
      menuFile.add(itemLock);
      menuFile.add(itemUnLock);
      menuFile.addSeparator();
      menuFile.add(itemConnectRealNet);
      menuFile.add(itemConnectTestNet);
      menuFile.add(itemDisconnect);
      menuFile.addSeparator();
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
