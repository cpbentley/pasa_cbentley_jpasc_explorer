package pasa.cbentley.jpasc.explorer.frame;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.tab.TabConnecting;
import pasa.cbentley.jpasc.explorer.panel.tab.TabWaitForDaemon;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;
import pasa.cbentley.swing.imytab.IMyTab;

public class FrameReferenceConnecting extends FrameReferenceTabAbstract {

   protected final PascExplorerCtx pec;

   public FrameReferenceConnecting(PascExplorerCtx pec) {
      super(pec.getSwingCtx());
      this.pec = pec;
   }

   protected void customizeLaunch(FrameIMyTab f) {
      f.guiUpdate();
      sc.showInNewFramePackCenter(f);
   }

   protected void customizeFrame(FrameIMyTab f) {
      //set the close call back to frame
      f.setIconImage(pec.getExplorerLogo64());
   }

   public TabConnecting getTab() {
      if(getFrame() != null) {
         FrameIMyTab f = (FrameIMyTab) getFrame();
         return (TabConnecting)f.getTab();
      }
      return null;
   }

   protected IMyTab createTab() {
      return new TabConnecting(pec);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "FrameReferenceNoConnection");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "FrameReferenceNoConnection");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
