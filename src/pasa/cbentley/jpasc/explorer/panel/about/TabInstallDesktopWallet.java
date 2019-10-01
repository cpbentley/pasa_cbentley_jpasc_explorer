package pasa.cbentley.jpasc.explorer.panel.about;

import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.swing.imytab.TabHTMLAbstract;

/**
 * Show data on how to install the reference wallet.
 * 
 * Its basically an HTML page
 * 
 * @author Charles Bentley
 *
 */
public class TabInstallDesktopWallet extends TabHTMLAbstract {


   public TabInstallDesktopWallet(PascalSwingCtx psc) {
      super(psc.getSwingCtx(), "install_wallet");
   }


   public String getPathHTML() {
      return "/html/installwallet.html";
   }
}
