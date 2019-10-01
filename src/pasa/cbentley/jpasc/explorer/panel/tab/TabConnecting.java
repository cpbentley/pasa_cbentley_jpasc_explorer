package pasa.cbentley.jpasc.explorer.panel.tab;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.SwingConstants;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.swing.imytab.AbstractMyTab;
import pasa.cbentley.swing.widgets.b.BButton;
import pasa.cbentley.swing.widgets.b.BLabel;

public class TabConnecting extends AbstractMyTab {

   protected final PascExplorerCtx pec;

   private BLabel                  labConnecting;

   private BButton                 butConnectingLogo;

   public TabConnecting(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), "connecting");
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

      labConnecting = new BLabel(pec.getSwingCtx(), "text.connectingnode");
      labConnecting.setHorizontalAlignment(SwingConstants.CENTER);
      
      Icon icon = pec.getSwingCtx().getResIcon("icon.pascal_logo_64");
      butConnectingLogo = new BButton(pec.getSwingCtx(), icon, icon);

      this.add(labConnecting, BorderLayout.NORTH);
      this.add(butConnectingLogo, BorderLayout.CENTER);
   }
}
