/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.panel.agree;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.about.TabExplorerAgreement;
import pasa.cbentley.jpasc.explorer.panel.about.TabExplorerLicense;
import pasa.cbentley.swing.imytab.TabbedBentleyPanel;

/**
 * Tabs for the agreement
 * 
 * @author Charles Bentley
 *
 */
public class TabsAgreement extends TabbedBentleyPanel {
   /**
    * 
    */
   private static final long       serialVersionUID = -3523191063614218767L;

   public static final String      ID               = "subtabs_agreement";

   protected final PascExplorerCtx pec;

   private TabExplorerLicense      tabLicense;

   private TabExplorerAgreement    tabAgreement;

   public TabsAgreement(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;
   }

   public void disposeTab() {
      tabLicense = null;
      tabAgreement = null;
   }

   public void initTabs() {

      tabAgreement = new TabExplorerAgreement(pec);
      tabLicense = new TabExplorerLicense(pec);

      addMyTab(tabAgreement);
      addMyTab(tabLicense);

   }

}