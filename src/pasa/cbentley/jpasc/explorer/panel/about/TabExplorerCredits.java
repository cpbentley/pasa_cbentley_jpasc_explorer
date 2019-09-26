package pasa.cbentley.jpasc.explorer.panel.about;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.swing.imytab.TabHTMLAbstract;

public class TabExplorerCredits extends TabHTMLAbstract {

   /**
    * 
    */
   private static final long       serialVersionUID = 8244489697535958652L;

   public static final String      ID               = "credits";

   protected final PascExplorerCtx pec;

   public TabExplorerCredits(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;
   }

   public String getPathHTML() {
      return "/html/credits.html";
   }
}
