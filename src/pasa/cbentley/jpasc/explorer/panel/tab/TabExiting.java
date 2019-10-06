package pasa.cbentley.jpasc.explorer.panel.tab;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.SwingConstants;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.swing.cmds.CmdConnectConnect;
import pasa.cbentley.swing.imytab.AbstractMyTab;
import pasa.cbentley.swing.widgets.b.BButton;
import pasa.cbentley.swing.widgets.b.BLabel;

public class TabExiting extends AbstractMyTab {

   /**
    * 
    */
   private static final long       serialVersionUID = 3397089946479137427L;

   private BButton                 butCancelExit;

   private BLabel                  labConnecting;

   protected final PascExplorerCtx pec;

   public TabExiting(PascExplorerCtx pec) {
      super(pec.getSwingCtx(), "exiting");
      this.pec = pec;

   }

   public void disposeTab() {

   }

   protected void initTab() {

      this.setLayout(new BorderLayout());

      labConnecting = new BLabel(pec.getSwingCtx(), "text.exiting");
      labConnecting.setHorizontalAlignment(SwingConstants.CENTER);

      Icon icon = pec.getSwingCtx().getResIcon("icon.pascal_logo_64");
      butCancelExit = new BButton(pec.getSwingCtx(), icon, icon);

      this.add(labConnecting, BorderLayout.NORTH);
      this.add(butCancelExit, BorderLayout.CENTER);
      
   }

   public void tabGainFocus() {
      
      //start the timer on the progress bar
   }

   public void tabLostFocus() {
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "TabConnecting");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "TabConnecting");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {
   }

   //#enddebug

}
