/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.run;

import java.awt.Image;
import java.util.List;

import com.github.davidbolet.jpascalcoin.api.model.Account;
import com.github.davidbolet.jpascalcoin.api.model.Block;
import com.github.davidbolet.jpascalcoin.api.model.PublicKey;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.interfaces.IPrefs;
import pasa.cbentley.core.src4.logging.BaseDLogger;
import pasa.cbentley.core.src4.logging.IConfig;
import pasa.cbentley.core.src4.logging.ITechConfig;
import pasa.cbentley.core.src4.logging.ITechLvl;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.menu.MenuBarPascalExplorer;
import pasa.cbentley.jpasc.explorer.panel.TabExplorerAbout;
import pasa.cbentley.jpasc.explorer.panel.TabJPascExplorer;
import pasa.cbentley.jpasc.pcore.ctx.ITechPCore;
import pasa.cbentley.jpasc.pcore.domain.java.PublicKeyJava;
import pasa.cbentley.jpasc.pcore.interfaces.IAccessPascal;
import pasa.cbentley.jpasc.swing.interfaces.IRootTabPane;
import pasa.cbentley.jpasc.swing.others.CentralLogger;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabConsoleAlone;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabLogin;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabLoginConsole;
import pasa.cbentley.jpasc.swing.panels.core.TabsChainExplorer;
import pasa.cbentley.jpasc.swing.run.RunPascalSwingAbstract;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * 
 * @author Charles Bentley
 *
 */
public class RunJPascExplorer extends RunPascalSwingAbstract {

   public static void main(String[] args) {
      RunJPascExplorer runner = new RunJPascExplorer();
      runner.initUIThreadOutside();
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            runner.initUIThreadInside();
         }
      });
   }

   protected final PascExplorerCtx pec;

   public RunJPascExplorer() {
      super();
      pec = new PascExplorerCtx(psc);
      pec.setRunner(this);
   }

   protected void initUIThreadInsideSwing() {
      //we don't want auto lock
      pc.getPrefs().putBoolean(ITechPCore.PKEY_AUTO_LOCK, false);

      TabJPascExplorer tabExplorer = new TabJPascExplorer(pec);
      //, "jpasc_explorer"

      frame = new FrameIMyTab(tabExplorer);

      Image image = psc.createImage("/icons/logo/root_chain_64.png", "");
      frame.setIconImage(image);

      frame.setExitable(this);
      sc.guiUpdate();
      frame.positionFrame();
   }

   /**
    * setup the logger at. sub class may override.
    * Default opens all at finest level
    */
   protected void toStringSetupLogger(UCtx uc) {
      BaseDLogger loggerFirst = (BaseDLogger) uc.toDLog();
      IConfig config = loggerFirst.getDefault().getConfig();
      config.setLevelGlobal(LVL_05_FINE);
      config.setLevelTag(LVL_03_FINEST, FLAG_09_PRINT_FLOW);
      config.setLevelTag(LVL_03_FINEST, FLAG_06_PRINT_WORK);
      config.setFlagPrint(MASTER_FLAG_02_OPEN_ALL_PRINT, true);
      
      //we want to see thread info when debugging workers
      config.setFlagFormat(MASTER_FLAG_07_THREAD_DATA, true);
      
   }

   protected void initForPrefsPascal(IPrefs prefs) {
      
   }

   protected void addI18nPascal(List<String> list) {
      list.add("i18nJPascExplorer");
   }

}
