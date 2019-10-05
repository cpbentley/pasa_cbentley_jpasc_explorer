package pasa.cbentley.jpasc.explorer.panel.tab;

import java.awt.BorderLayout;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.explorer.panel.daemon.TabsNoobGifs;
import pasa.cbentley.jpasc.explorer.panel.helper.PanelHelperWaitDaemon;
import pasa.cbentley.jpasc.explorer.panel.helper.TabsNoConnection;
import pasa.cbentley.swing.imytab.AbstractMyTab;

public class TabWaitForDaemon extends AbstractMyTab {

   protected final PascExplorerCtx pec;

   private TabsNoConnection        tabsGIF;

   private PanelHelperWaitDaemon   panelWaitMessage;

   public TabWaitForDaemon(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), "daemon_connection");
      this.pec = pec;

   }

   public void tabLostFocus() {
   }

   public void tabGainFocus() {
   }

   public void disposeTab() {

   }

   protected void initTab() {

      this.setLayout(new BorderLayout());

      panelWaitMessage = new PanelHelperWaitDaemon(pec);
      
      tabsGIF = new TabsNoConnection(pec);
      tabsGIF.initCheck();

      this.add(panelWaitMessage, BorderLayout.NORTH);
      this.add(tabsGIF, BorderLayout.CENTER);
   }
}
