package pasa.cbentley.jpasc.explorer.panel.about;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.swing.imytab.TabHTMLAbstract;

public class TabExplorerAgreement extends TabHTMLAbstract {

   /**
    * 
    */
   private static final long       serialVersionUID = -1381488953929259385L;

   public static final String      ID               = "agreement";

   protected final PascExplorerCtx pec;

   public TabExplorerAgreement(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;

   }

   public String getPathHTML() {
      return "/html/agreement.html";
   }

}
