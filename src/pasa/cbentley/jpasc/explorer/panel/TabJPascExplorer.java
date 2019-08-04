/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.panel;

import java.awt.BorderLayout;

import com.github.davidbolet.jpascalcoin.api.model.Account;
import com.github.davidbolet.jpascalcoin.api.model.Block;
import com.github.davidbolet.jpascalcoin.api.model.PublicKey;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.pcore.domain.java.PublicKeyJava;
import pasa.cbentley.jpasc.pcore.interfaces.IAccessPascal;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.jpasc.swing.interfaces.IRootTabPane;
import pasa.cbentley.jpasc.swing.others.CentralLogger;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabConsoleAlone;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabLogin;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabLoginConsole;
import pasa.cbentley.jpasc.swing.panels.core.TabsChainExplorer;
import pasa.cbentley.swing.imytab.AbstractMyTab;

/**
 * 
 * @author Charles Bentley
 *
 */
public class TabJPascExplorer extends AbstractMyTab implements IRootTabPane {

   /**
    * 
    */
   private static final long       serialVersionUID = -4520926230634085959L;

   public static final String      ID               = "jpasc_explorer";

   protected final PascExplorerCtx pec;

   protected final PascalSwingCtx  psc;

   private TabsChainExplorer       chainExplorer;

   private PanelTabConsoleAlone    panelConsole;

   private PanelTabLogin           loginPanel;

   protected final UCtx            uc;

   private PanelTabLoginConsole    panelTabLoginConsole;

   public TabJPascExplorer(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;
      this.psc = pec.getPascalSwingCtx();
      this.uc = pec.getUCtx();
      panelConsole = new PanelTabConsoleAlone(psc);
      CentralLogger logger = new CentralLogger(psc, panelConsole);
      uc.setUserLog(logger);

      loginPanel = new PanelTabLogin(psc);
      loginPanel.setConfigShowBlockInfo(false);

      panelTabLoginConsole = new PanelTabLoginConsole(psc, loginPanel, panelConsole);
      panelTabLoginConsole.loginAuto();
   }

   public void tabLostFocus() {
      //#debug
      toDLog().pFlow("", this, TabJPascExplorer.class, "tabLostFocus", LVL_05_FINE, true);
      if (chainExplorer != null) {
         chainExplorer.tabLostFocus();
      }
   }

   public void tabGainFocus() {
      //#debug
      toDLog().pFlow("", this, TabJPascExplorer.class, "tabGainFocus", LVL_05_FINE, true);
      if (chainExplorer != null) {
         chainExplorer.tabGainFocus();
      }
   }

   public void disposeTab() {

   }

   protected void initTab() {
      this.setLayout(new BorderLayout());
      this.add(panelTabLoginConsole, BorderLayout.CENTER);
      panelTabLoginConsole.initCheck();
      loginPanel.initCheck();
      panelConsole.initCheck();
      chainExplorer = new TabsChainExplorer(psc, this);
      chainExplorer.initCheck();
      panelTabLoginConsole.setPanelCenter(chainExplorer);
   }

   public Integer getAccountNext(Integer account) {
      initCheck();
      return chainExplorer.getAccountNext(account);
   }

   public Integer getAccountPrev(Integer account) {
      initCheck();
      return chainExplorer.getAccountPrev(account);
   }

   public IAccessPascal getAccessPascal() {
      initCheck();
      return chainExplorer.getAccessPascal();
   }

   public void showAccountDetails(Account ac) {
      initCheck();
      //must not be null of after init
      chainExplorer.showAccountDetails(ac);
   }

   public void showAccountDetails(Integer ac) {
      initCheck();
      //must not be null of after init
      chainExplorer.showAccountDetails(ac);
   }

   public void showAccountOwner(Account ac) {
      initCheck();
      //must not be null of after init
      chainExplorer.showAccountOwner(ac);
   }

   public void showAccountOwner(Integer ac) {
      initCheck();
      //must not be null of after init
      chainExplorer.showAccountOwner(ac);
   }

   public void showBlock(Block ac) {
      initCheck();
      //must not be null of after init
      chainExplorer.showBlock(ac);
   }

   public void showPublicKeyAccounts(PublicKey pk) {
      initCheck();
      //must not be null of after init
      chainExplorer.showPublicKeyAccounts(pk);
   }

   public void showPublicKeyJavaAccountNames(PublicKeyJava pk) {
      initCheck();
      //must not be null of after init
      chainExplorer.showPublicKeyJavaAccountNames(pk);
   }

   public void showPublicKeyJavaAccounts(PublicKeyJava pk) {
      initCheck();
      //must not be null of after init
      chainExplorer.showPublicKeyJavaAccounts(pk);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "TabJPascExplorer");
      toStringPrivate(dc);
      super.toString(dc.sup());
      dc.nlLvl(chainExplorer, "chainExplorer");
      dc.nlLvl(panelTabLoginConsole, "panelTabLoginConsole");
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "TabJPascExplorer");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
      dc.nlLvlOneLine(chainExplorer, "chainExplorer");
   }

   //#enddebug

}
