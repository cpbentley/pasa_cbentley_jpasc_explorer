package pasa.cbentley.jpasc.explorer.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.swing.actions.IExitable;

/**
 * 
 * @author Charles Bentley
 *
 */
public class ExitTask implements IExitable {

   protected final PascExplorerCtx pec;

   public ExitTask(PascExplorerCtx pec) {
      this.pec = pec;
   }
   
   public void cmdExit() {
      //#debug
      toDLog().pFlow("", null, ExitTask.class, "cmdExit", LVL_05_FINE, true);
      
      pec.getPascalSwingCtx().getCmds().cmdExit();
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
