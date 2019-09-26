/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.run;

import java.awt.Image;
import java.util.List;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.interfaces.IPrefs;
import pasa.cbentley.core.src4.logging.BaseDLogger;
import pasa.cbentley.core.src4.logging.IConfig;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.TabJPascExplorer;
import pasa.cbentley.jpasc.pcore.ctx.ITechPCore;
import pasa.cbentley.jpasc.swing.interfaces.ITechPrefsPascalSwing;
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
      
      //set the current version of the explorer. for the user
      pec.setVersion("1.0.0");
      
      pec.setRunner(this);
   }

   protected void addI18nPascal(List<String> list) {
      list.add("i18nJPascExplorer");
   }

   protected void initForPrefsPascal(IPrefs prefs) {

   }

   protected CBentleyFrame initUIThreadInsideSwing() {
      //we don't want auto lock
      pc.getPrefs().putBoolean(ITechPCore.PKEY_AUTO_LOCK, false);

      psc.getPascPrefs().putBoolean(ITechPrefsPascalSwing.PREF_GLOBAL_MANUAL_REFRESH, true);
      
      TabJPascExplorer tabExplorer = new TabJPascExplorer(pec);
      //, "jpasc_explorer"

      frame = new FrameIMyTab(tabExplorer);

      Image image = psc.createImage("/icons/logo/root_chain_64.png", "");
      frame.setIconImage(image);

      return frame;
   }

   /**
    * setup the logger at. sub class may override.
    * Default opens all at finest level
    */
   //#mdebug
   protected void toStringSetupLogger(UCtx uc) {
      BaseDLogger loggerFirst = (BaseDLogger) uc.toDLog();
      IConfig config = loggerFirst.getDefault().getConfig();
      config.setLevelGlobal(LVL_05_FINE);
      config.setLevelTag(LVL_03_FINEST, FLAG_09_PRINT_FLOW);
      config.setLevelTag(LVL_03_FINEST, FLAG_06_PRINT_WORK);
      
      config.setFlagTag(FLAG_09_PRINT_FLOW, true);
      config.setFlagTag(FLAG_18_PRINT_MEMORY, false);

      //we want to see thread info when debugging workers
      config.setFlagFormat(MASTER_FLAG_07_THREAD_DATA, true);

   }
   //#enddebug
}
