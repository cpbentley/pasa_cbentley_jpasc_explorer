/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.run;

import java.awt.Image;
import java.util.List;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.helpers.StringBBuilder;
import pasa.cbentley.core.src4.interfaces.IPrefs;
import pasa.cbentley.core.src4.logging.BaseDLogger;
import pasa.cbentley.core.src4.logging.IConfig;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.tab.TabConnecting;
import pasa.cbentley.jpasc.explorer.panel.tab.TabJPascExplorer;
import pasa.cbentley.jpasc.explorer.panel.tab.TabWaitForDaemon;
import pasa.cbentley.jpasc.pcore.ctx.ITechPCore;
import pasa.cbentley.jpasc.pcore.network.RPCConnection;
import pasa.cbentley.jpasc.swing.cmds.CmdConnectConnect;
import pasa.cbentley.jpasc.swing.interfaces.IPrefsPascalSwing;
import pasa.cbentley.jpasc.swing.others.CentralLogger;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabConsoleAlone;
import pasa.cbentley.jpasc.swing.run.RunPascalSwingAbstract;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.IMyTab;
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

      psc.getPascPrefs().putBoolean(IPrefsPascalSwing.PREF_GLOBAL_MANUAL_REFRESH, true);
      //disable built in sounds for this release
      psc.getPascPrefs().putInt(IPrefsPascalSwing.PREF_PLAY_SOUND, IPrefsPascalSwing.PREF_PLAY_SOUND_0_NONE);

      //show ui for trying to connect to localhost ? TODO put it up
      psc.applyPrefs(psc.getPascPrefs());
      
      //setup the gui logger so that we log the user log to be active
      PanelTabConsoleAlone panelConsole = new PanelTabConsoleAlone(psc);
      CentralLogger logger = new CentralLogger(psc, panelConsole);
      uc.setUserLog(logger);

      StringBBuilder message = sc.getSBBuilder();
      message.append("Welcome to Pascal Explorer ");
      message.append(pec.getVersion());
      message.append(". For updates visit https://github.com/cpbentley/pasa_cbentley_jpasc_explorer");
      logger.consoleLogDate(message.toString());

      pec.setPanelConsole(panelConsole);

      TabConnecting tabConnecting = new TabConnecting(pec);
      FrameIMyTab frame = new FrameIMyTab(tabConnecting);
      //we want the position to be "packed" and shown in the center of the screen
      
      
      frame.setIconImage(pec.getExplorerLogo64());

      
      //we want fast gui update for this one, not the whole tree
      tabConnecting.guiUpdate();
      sc.showInNewFramePackCenter(frame);
      
      //start the call after the setVisible call has been made in the GUI thread
      sc.executeLaterInUIThread(new Runnable() {
         public void run() {
            
            CmdConnectConnect cmd = pec.getPascalSwingCtx().getCmds().getCmdConnectConnect();
            cmd.executeWith(pec);
            frame.setVisible(false);
         }
      });
      return null;
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
