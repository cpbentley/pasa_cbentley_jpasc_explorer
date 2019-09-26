package pasa.cbentley.jpasc.explorer.panel.about;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.swing.imytab.TabHTMLAbstract;

public class TabExplorerChangeLog extends TabHTMLAbstract {

   /**
    * 
    */
   private static final long       serialVersionUID = -1381488953929259385L;

   public static final String      ID               = "changelog";

   protected final PascExplorerCtx pec;

   public TabExplorerChangeLog(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;

   }

   public String getPathHTML() {
      return "/html/changelog.html";
   }

}
