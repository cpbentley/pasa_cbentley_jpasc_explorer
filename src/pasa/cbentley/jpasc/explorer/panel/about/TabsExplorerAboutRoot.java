/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.panel.about;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.swing.panels.system.PanelTabNodeCenter;
import pasa.cbentley.swing.imytab.TabbedBentleyPanel;

public class TabsExplorerAboutRoot extends TabbedBentleyPanel {
   /**
    * 
    */
   private static final long        serialVersionUID = -3523191063614218767L;

   public static final String       ID               = "root_about_explorer";

   protected final PascExplorerCtx  pec;

   private TabExplorerLicense       tabExplorerLicense;

   private TabExplorerCredits       tabExplorerCredits;

   private TabExplorerAboutBentley  tabExplorerBentley;

   private TabExplorerAboutDonation tabExplorerDonations;

   private TabExplorerChangeLog tabExplorerChangeLog;

   private PanelTabNodeCenter tabNodeCenter;

   public TabsExplorerAboutRoot(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;
   }

   public void disposeTab() {
      tabExplorerLicense = null;
      tabExplorerCredits = null;
      tabExplorerBentley = null;
      tabExplorerDonations = null;
      tabExplorerChangeLog = null;
   }

   public void initTabs() {
      tabExplorerCredits = new TabExplorerCredits(pec);
      tabExplorerLicense = new TabExplorerLicense(pec);
      tabExplorerBentley = new TabExplorerAboutBentley(pec);
      tabExplorerDonations = new TabExplorerAboutDonation(pec);
      tabExplorerChangeLog = new TabExplorerChangeLog(pec);
      tabNodeCenter = new PanelTabNodeCenter(pec.getPascalSwingCtx());
      
      addMyTab(tabExplorerCredits);
      addMyTab(tabExplorerLicense);
      addMyTab(tabExplorerBentley);
      addMyTab(tabExplorerDonations);
      addMyTab(tabExplorerChangeLog);
      addMyTab(tabNodeCenter);

   }

}