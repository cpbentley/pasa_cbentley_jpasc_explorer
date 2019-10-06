package pasa.cbentley.jpasc.explorer.frame;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.tab.TabExiting;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;
import pasa.cbentley.swing.imytab.IMyTab;


/**
 * Reference to the frame showing when you close the main window.
 * 
 * If nothing happens, exit procedure kicks in.
 * 
 * @author Charles Bentley
 *
 */
public class FrameReferenceExiting extends FrameReferenceTabAbstract {

   protected final PascExplorerCtx pec;

   public FrameReferenceExiting(PascExplorerCtx pec) {
      super(pec.getSwingCtx());
      this.pec = pec;
   }

   protected void customizeLaunch(FrameIMyTab f) {
      f.guiUpdate();
      //center on which screen? uses screen coordinate of main frame
      sc.showInNewFramePackCenter(f);
   }

   protected void customizeFrame(FrameIMyTab f) {
      //set the close call back to frame
      f.setIconImage(pec.getExplorerLogo64());
   }

   protected IMyTab createTab() {
      return new TabExiting(pec);
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "FrameReferenceExiting");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "FrameReferenceExiting");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
