/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.run;

import java.util.List;

import javax.swing.ImageIcon;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.helpers.StringBBuilder;
import pasa.cbentley.core.src4.interfaces.IPrefs;
import pasa.cbentley.core.src4.logging.BaseDLogger;
import pasa.cbentley.core.src4.logging.IDLogConfig;
import pasa.cbentley.core.src4.logging.ITechTags;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.frame.FrameReferenceAgreement;
import pasa.cbentley.jpasc.explorer.frame.FrameReferenceConnecting;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JPascJsonRPCClientFactory;
import pasa.cbentley.jpasc.pcore.ctx.IPascalCoinClientFactory;
import pasa.cbentley.jpasc.pcore.ctx.ITechPCore;
import pasa.cbentley.jpasc.swing.interfaces.IPrefsPascalSwing;
import pasa.cbentley.jpasc.swing.others.CentralLogger;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabConsoleAlone;
import pasa.cbentley.jpasc.swing.panels.table.abstrakt.TablePanelAbstract;
import pasa.cbentley.jpasc.swing.run.RunPascalSwingAbstract;
import pasa.cbentley.swing.images.anim.AnimRunnerProducer;
import pasa.cbentley.swing.images.anim.ui.JComponentAnim;
import pasa.cbentley.swing.skin.main.SwingSkinManager;
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

      //we decide here what to use for RPC lib
      JPascJsonRpcCtx jjc = new JPascJsonRpcCtx(pc);
      IPascalCoinClientFactory fac = new JPascJsonRPCClientFactory(jjc);
      psc.getPCtx().setPascalCoinClientFactory(fac);
      
      //set the current version of the explorer. for the user
      pec.setVersion("1.1.0");

      pec.setRunner(this);
   }

   /**
    * 
    */
   protected void initSkinner() {
      //load the look and feel before any Swing component
      SwingSkinManager pascalSkinManager = new SwingSkinManager(ssc);
      ImageIcon icon = psc.createImageIcon("/icons/logo/pascal_chain_explorer_20.png", "");
      pascalSkinManager.setDefault("com.jtattoo.plaf.mint.MintLookAndFeel", "Medium-Font");
      pascalSkinManager.setIconSelected(icon);
      pascalSkinManager.prefsInit();
      psc.setSwingSkinManager(pascalSkinManager);
   }

   protected void addI18nPascal(List<String> list) {
      pec.addI18NKey(list);
   }

   protected void initForPrefsPascal(IPrefs prefs) {

   }

   protected CBentleyFrame initUIThreadInsideSwing() {

      sc.setResMissingLog(true);

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

      message = sc.getSBBuilder();
      message.append("This software has been built for Pascal Full Node Wallet 5.3. Other versions are not supported.");
      logger.consoleLogDate(message.toString());
      pec.setPanelConsole(panelConsole);
      
      String keyPrefAgree = IPrefsPascalSwing.PREF_AGREE_PREFIX + pec.getVersion();
      String agree = psc.getPascPrefs().get(keyPrefAgree, "");

      FrameReferenceConnecting frameConnecting = pec.getFrames().getFrameConnecting();

      if (agree.length() == 0) {
         //show the agreement window
         FrameReferenceAgreement frameAgreement = pec.getFrames().getFrameAgreement();
         //create a chain action
         frameAgreement.showFrame();
      } else {
         frameConnecting.showFrame();
         frameConnecting.getTab().cmdConnect();
      }

      return null;
   }

   /**
    * setup the logger at. sub class may override.
    * Default opens all at finest level
    */
   //#mdebug
   protected void toStringSetupLogger(UCtx uc) {
      BaseDLogger loggerFirst = (BaseDLogger) uc.toDLog();
      IDLogConfig config = loggerFirst.getDefault().getConfig();
      config.setLevelGlobal(LVL_05_FINE);
      config.setLevelTag(LVL_03_FINEST, FLAG_09_PRINT_FLOW);
      config.setLevelTag(LVL_03_FINEST, FLAG_06_PRINT_WORK);

      config.setFlagTag(FLAG_09_PRINT_FLOW, true);
      config.setFlagTag(FLAG_18_PRINT_MEMORY, false);

      //we want to see thread info when debugging workers
      config.setFlagFormat(MASTER_FLAG_07_THREAD_DATA, true);

      config.setFlagTag(ITechTags.FLAG_09_PRINT_FLOW, true);
      config.setClassNegative(AnimRunnerProducer.class, true);
      config.setClassNegative(JComponentAnim.class, true);
      //config.setClassNegative(SwingCtx.class, true);
      config.setClassNegative(TablePanelAbstract.class, true);

      sc.setResMissingLog(false);

   }
   //#enddebug
}
