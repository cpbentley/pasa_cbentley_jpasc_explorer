package pasa.cbentley.jpasc.explorer.frame;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.daemon.TabsNoobGifs;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;
import pasa.cbentley.swing.imytab.IMyTab;

public class FrameReferenceExplorer extends FrameReferenceTabAbstract {

   protected final PascExplorerCtx pec;

   public FrameReferenceExplorer(PascExplorerCtx pec) {
      super(pec.getSwingCtx());
      this.pec = pec;
   }

   protected void customizeLaunch(FrameIMyTab f) {
      //show it using last saved settings
      f.positionFrame();
   }

   protected void customizeFrame(FrameIMyTab f) {
      f.setIconImage(pec.getExplorerLogo64());
      f.setMainFrame();
      pec.getSwingCtx().guiUpdate();
   }

   protected IMyTab createTab() {
      return pec.getTabExplorer();
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "FrameReferenceExplorer");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "FrameReferenceExplorer");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
