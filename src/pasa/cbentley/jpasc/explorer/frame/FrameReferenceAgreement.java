package pasa.cbentley.jpasc.explorer.frame;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.tab.TabAgreement;
import pasa.cbentley.jpasc.explorer.panel.tab.TabWaitForDaemon;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;
import pasa.cbentley.swing.imytab.IMyTab;

public class FrameReferenceAgreement extends FrameReferenceTabAbstract {

   protected final PascExplorerCtx pec;

   public FrameReferenceAgreement(PascExplorerCtx pec) {
      super(pec.getSwingCtx());
      this.pec = pec;
   }

   protected void customizeLaunch(FrameIMyTab f) {
      sc.showInNewFrame(f, 0.6f, 0.7f);
   }

   protected void customizeFrame(FrameIMyTab f) {
      f.setIconImage(pec.getExplorerLogo64());
   }

   protected IMyTab createTab() {
      return new TabAgreement(pec);
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "FrameReferenceAgreement");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "FrameReferenceAgreement");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

 

   //#enddebug
   


}
