package pasa.cbentley.jpasc.explorer.panel.tab;

import java.awt.BorderLayout;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.agree.TabsAgreement;
import pasa.cbentley.jpasc.explorer.panel.helper.PanelHelperAgreement;
import pasa.cbentley.swing.imytab.AbstractMyTab;

public class TabAgreement extends AbstractMyTab {

   /**
    * 
    */
   private static final long       serialVersionUID = 460651586576355046L;

   protected final PascExplorerCtx pec;

   private TabsAgreement           tabsAgreement;

   private PanelHelperAgreement    panelAgreeButtons;

   public TabAgreement(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), "maintab_agreement");
      this.pec = pec;
   }

   public void tabLostFocus() {
   }

   public void tabGainFocus() {
   }

   public void disposeTab() {
      panelAgreeButtons = null;
      tabsAgreement = null;
   }

   protected void initTab() {
      this.setLayout(new BorderLayout());
      
      panelAgreeButtons = new PanelHelperAgreement(pec);
      tabsAgreement = new TabsAgreement(pec);
      tabsAgreement.initCheck();

      this.add(tabsAgreement, BorderLayout.CENTER);
      this.add(panelAgreeButtons, BorderLayout.SOUTH);
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "TabAgreement");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "TabAgreement");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
