/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.panel.daemon;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.swing.panels.system.PanelTabNodeCenter;
import pasa.cbentley.jpasc.swing.panels.system.SystemTab;
import pasa.cbentley.swing.imytab.TabbedBentleyPanel;

/**
 * Tabs showing how to use the regular desktop wallet
 * @author Charles Bentley
 *
 */
public class TabsNoobGifs extends TabbedBentleyPanel {
   /**
    * 
    */
   private static final long        serialVersionUID = -3523191063614218767L;

   public static final String       ID               = "root_gifs_explorer";

   protected final PascExplorerCtx  pec;

   private NoobGifDaemon       tabDaemonRPC;

   private NoobGifDaemonKeys       tabDaemonKeys;


   public TabsNoobGifs(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;
   }

   public void disposeTab() {
      tabDaemonRPC = null;
      tabDaemonKeys = null;
   }

   public void initTabs() {
      tabDaemonKeys = new NoobGifDaemonKeys(pec.getPascalSwingCtx());
      tabDaemonRPC = new NoobGifDaemon(pec.getPascalSwingCtx());

      addMyTab(tabDaemonRPC);
      addMyTab(tabDaemonKeys);

   }

}