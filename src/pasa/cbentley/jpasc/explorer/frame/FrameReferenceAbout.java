package pasa.cbentley.jpasc.explorer.frame;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.about.TabsExplorerAboutRoot;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;
import pasa.cbentley.swing.imytab.IMyTab;

public class FrameReferenceAbout extends FrameReferenceTabAbstract {

   protected final PascExplorerCtx pec;

   public FrameReferenceAbout(PascExplorerCtx pec) {
      super(pec.getSwingCtx());
      this.pec = pec;
   }

   protected void customizeLaunch(FrameIMyTab f) {
      sc.showInNewFrame(f, 0.6f, 0.9f);
   }

   protected void customizeFrame(FrameIMyTab f) {
      f.setIconImage(pec.getExplorerLogo64());
   }

   protected IMyTab createTab() {
      TabsExplorerAboutRoot about = new TabsExplorerAboutRoot(pec);
      return about;
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "FrameReferenceAbout");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "FrameReferenceAbout");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
