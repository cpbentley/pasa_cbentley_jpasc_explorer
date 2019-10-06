/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.panel.about;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.agree.TabsAgreement;
import pasa.cbentley.jpasc.explorer.panel.tab.TabAgreement;
import pasa.cbentley.jpasc.swing.panels.system.PanelTabNodeCenter;
import pasa.cbentley.jpasc.swing.panels.system.SystemTab;
import pasa.cbentley.swing.imytab.TabbedBentleyPanel;
import pasa.cbentley.swing.panels.PreferenceTab;

public class TabsExplorerAboutRoot extends TabbedBentleyPanel {
   /**
    * 
    */
   private static final long        serialVersionUID = -3523191063614218767L;

   public static final String       ID               = "root_about_explorer";

   protected final PascExplorerCtx  pec;

   private TabAgreement             tabExplorerLicense;

   private TabExplorerCredits       tabExplorerCredits;

   private TabExplorerAboutBentley  tabExplorerBentley;

   private TabExplorerAboutDonation tabExplorerDonations;

   private TabExplorerChangeLog     tabExplorerChangeLog;

   private PanelTabNodeCenter       tabNodeCenter;

   private SystemTab                tabSystem;

   private PreferenceTab            tabPreferences;

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
      tabNodeCenter = null;
      tabSystem = null;
      tabPreferences = null;
   }

   public void initTabs() {
      tabExplorerCredits = new TabExplorerCredits(pec);
      tabExplorerLicense = new TabAgreement(pec);
      tabExplorerBentley = new TabExplorerAboutBentley(pec);
      tabExplorerDonations = new TabExplorerAboutDonation(pec);
      tabExplorerChangeLog = new TabExplorerChangeLog(pec);
      tabNodeCenter = new PanelTabNodeCenter(pec.getPascalSwingCtx());
      tabSystem = new SystemTab(pec.getPascalSwingCtx().getSwingCtx());
      tabPreferences = new PreferenceTab(pec.getPascalSwingCtx().getSwingCtx());

      addMyTab(tabExplorerCredits);
      addMyTab(tabExplorerLicense);
      addMyTab(tabExplorerBentley);
      addMyTab(tabExplorerDonations);
      addMyTab(tabExplorerChangeLog);
      addMyTab(tabNodeCenter);
      addMyTab(tabSystem);
      addMyTab(tabPreferences);

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "TabsExplorerAboutRoot");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "TabsExplorerAboutRoot");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}