package pasa.cbentley.jpasc.explorer.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.interfaces.ICallBack;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;
import pasa.cbentley.jpasc.swing.audio.PascalAudio;
import pasa.cbentley.jpasc.swing.audio.SoundPlay;
import pasa.cbentley.jpasc.swing.cmds.PascalCmdManager;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.swing.actions.IExitable;
import pasa.cbentley.swing.ctx.SwingCtx;

/**
 * Responsible to call the exits of each modules
 * @author Charles Bentley
 *
 */
public class ExitTaskJPascExplorer implements IExitable, ICallBack {

   protected final PascExplorerCtx pec;

   public ExitTaskJPascExplorer(PascExplorerCtx pec) {
      this.pec = pec;
   }

   public void prepareExit() {
      int activeCount = Thread.activeCount();
      
      //#debug
      toDLog().pFlow("#threads=" + activeCount, null, ExitTaskJPascExplorer.class, "prepareExit", LVL_05_FINE, true);
      
      //wait for sound to play and then exit
      try {
         PascalSwingCtx psc = pec.getPascalSwingCtx();
         //wrap in a try in case whatever happens. Audio might be buggy.
         psc.getAudio().playAudioRandom(PascalAudio.SOUNDS_BYE, this);
      } catch (Error e) {
         e.printStackTrace();
         //do this exit
      }
   }

   public void cmdExit() {
      //#debug
      toDLog().pFlow("", null, ExitTaskJPascExplorer.class, "cmdExit", LVL_05_FINE, true);

      PascalSwingCtx psc = pec.getPascalSwingCtx();
      SwingCtx sc = pec.getSwingCtx();
      PCoreCtx pc = psc.getPCtx();
      //
      pc.cmdExit();
      sc.cmdExit();
      psc.cmdExit();
      
      System.exit(0);
   }

   public void callBack(Object o) {
      //which call back ?
      if (o instanceof SoundPlay) {
         System.exit(0);
      } else {

         //#debug
         toDLog().pTest("Unknown Class " + o, this, PascalCmdManager.class, "callBack", LVL_05_FINE, true);
         System.exit(0);
      }
   }

   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, "ExitTask");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "ExitTask");
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return pec.getUCtx();
   }

   //#enddebug

}
