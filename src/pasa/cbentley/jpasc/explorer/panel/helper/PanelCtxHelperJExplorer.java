package pasa.cbentley.jpasc.explorer.panel.helper;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.swing.panels.core.PanelCtxHelperAbstract;

public class PanelCtxHelperJExplorer extends PanelCtxHelperAbstract {

   /**
    * 
    */
   private static final long       serialVersionUID = 2137906542927031336L;

   protected final PascExplorerCtx pec;

   public PanelCtxHelperJExplorer(PascExplorerCtx pec) {
      super(pec.getPascalSwingCtx());
      this.pec = pec;
   }

   protected void initHelper() {
      buttonHelpAbout.setTextKey("but.about");
      Icon icon = pec.getPascalSwingCtx().createImageIcon("/icons/logo/pascal_chain_explorer_32.png", "");
      buttonHelpAbout.setIconNormal(icon);
      buttonHelpAbout.setIconSelected(icon);
   }

   public void actionPerformed(ActionEvent e) {
      //depending on the state
      if (e.getSource() == buttonHelpAbout) {
         pec.getFrames().cmdShowAboutTab();
      }
   }

   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "PanelCtxHelperJExplorer");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "PanelCtxHelperJExplorer");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
