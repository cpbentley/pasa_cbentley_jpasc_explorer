package pasa.cbentley.jpasc.explorer.frame;

import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.FrameReference;
import pasa.cbentley.swing.imytab.IMyTab;

public abstract class FrameReferenceTabAbstract extends FrameReference {

   public FrameReferenceTabAbstract(SwingCtx sc) {
      super(sc);
   }

   public void showFrame() {
      if (getFrame() == null) {
         IMyTab about = createTab();
         FrameIMyTab f = new FrameIMyTab(about); //deal with tab dispose auto
         //so the reference to be set to null when closed
         f.setFrameReference(this);
         customizeFrame(f);
         customizeLaunch(f);
      } else {
         getFrame().setVisible(true);
      }
   }

   protected void customizeLaunch(FrameIMyTab f) {
      sc.showInNewFrame(f, 0.6f, 0.9f);
   }

   protected abstract void customizeFrame(FrameIMyTab f);

   protected abstract IMyTab createTab();
}
