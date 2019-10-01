/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.ctx;

import java.awt.Image;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.jpasc.explorer.frame.FrameReferenceAbout;
import pasa.cbentley.jpasc.explorer.frame.FrameReferenceDaemonHelp;
import pasa.cbentley.jpasc.explorer.frame.FrameReferenceExplorer;
import pasa.cbentley.jpasc.explorer.frame.FrameReferenceNoConnection;
import pasa.cbentley.jpasc.explorer.menu.MenuBarFactoryExplorer;
import pasa.cbentley.jpasc.explorer.panel.helper.PanelHelperWaitDaemon;
import pasa.cbentley.jpasc.explorer.panel.tab.TabJPascExplorer;
import pasa.cbentley.jpasc.explorer.run.RunJPascExplorer;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;
import pasa.cbentley.jpasc.pcore.network.RPCConnection;
import pasa.cbentley.jpasc.swing.cmds.ICommandableConnect;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabConsoleAlone;
import pasa.cbentley.swing.actions.IExitable;
import pasa.cbentley.swing.ctx.SwingCtx;

public class PascExplorerCtx extends ACtx implements IExitable, ICommandableConnect {

   private FrameReferenceAbout        frameReferenceAbout;

   private FrameReferenceNoConnection frameReferenceCon;

   private FrameReferenceDaemonHelp   frameReferenceDaemon;

   private FrameReferenceExplorer     frameReferenceMain;

   private Image imageExplorerLogo64;

   private PanelTabConsoleAlone       panelConsole;

   protected final PascalSwingCtx     psc;

   private RunJPascExplorer           runner;

   protected final SwingCtx           sc;

   private TabJPascExplorer           tabExplorer;

   private String                     version;

   public PascExplorerCtx(PascalSwingCtx psc) {
      super(psc.getUCtx());
      this.psc = psc;
      this.sc = psc.getSwingCtx();
      SwingCtx sc = psc.getSwingCtx();
      MenuBarFactoryExplorer menuFactory = new MenuBarFactoryExplorer(this);
      sc.setTabMenuBarFactory(menuFactory);
   }

   /**
    * Try to connect
    * @param panelWaitDaemon
    */
   public boolean cmdDaemonConnection(PanelHelperWaitDaemon panelWaitDaemon) {
      PCoreCtx pc = psc.getPCtx();
      RPCConnection rpc = new RPCConnection(pc);
      boolean isConnected = rpc.connectLocalhost();
      if (isConnected) {
         pc.setRPCConnection(rpc);
         //bring visible the main frame

         return true;
      }

      return false;
   }

   public void cmdExit() {
      psc.getCmds().cmdExit();
   }

   public void cmdShowAboutTab() {
      //add the about tab in a frame
      if (frameReferenceAbout == null) {
         frameReferenceAbout = new FrameReferenceAbout(this);
      }
      frameReferenceAbout.showFrame();
   }

   public void cmdShowDaemonHelp() {
      //add the about tab in a frame
      if (frameReferenceDaemon == null) {
         frameReferenceDaemon = new FrameReferenceDaemonHelp(this);
      }
      frameReferenceDaemon.showFrame();
   }

   public void cmdShowMainWindow() {

      if (frameReferenceMain == null) {
         frameReferenceMain = new FrameReferenceExplorer(this);
      }
      frameReferenceMain.showFrame();
   }

   public void cmdShowNoConnection() {
      //add the about tab in a frame
      if (frameReferenceCon == null) {
         frameReferenceCon = new FrameReferenceNoConnection(this);
      }
      frameReferenceCon.showFrame();
   }

   public Image getExplorerLogo64() {
      if (imageExplorerLogo64 == null) {
         Image image = psc.createImage("/icons/logo/root_chain_64.png", "");
         imageExplorerLogo64 = image;
      }
      return imageExplorerLogo64;
   }

   public PanelTabConsoleAlone getPanelConsole() {
      return panelConsole;
   }

   public PascalSwingCtx getPascalSwingCtx() {
      return psc;
   }

   public SwingCtx getSwingCtx() {
      return psc.getSwingCtx();
   }

   public TabJPascExplorer getTabExplorer() {
      if (tabExplorer == null) {
         tabExplorer = new TabJPascExplorer(this);
         tabExplorer.setConsole(panelConsole);
      }
      return tabExplorer;
   }

   public String getVersion() {
      return version;
   }

   public void setPanelConsole(PanelTabConsoleAlone panelConsole) {
      this.panelConsole = panelConsole;

   }

   public void setRunner(RunJPascExplorer runner) {
      this.runner = runner;
   }

   public void setTabExplorer(TabJPascExplorer tabExplorer) {
      this.tabExplorer = tabExplorer;
   }

   public void setVersion(String version) {
      this.version = version;
   }

   public void showUISuccess() {
      cmdShowMainWindow();
   }

   public void showUIFailure() {
      cmdShowNoConnection();
   }

}
