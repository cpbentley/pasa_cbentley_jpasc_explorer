package pasa.cbentley.jpasc.explorer.panel.helper;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.swing.widgets.PanelPascalRiver;
import pasa.cbentley.swing.widgets.b.BButton;
import pasa.cbentley.swing.widgets.b.BLabel;

public class PanelHelperWaitDaemon extends PanelPascalRiver implements ActionListener {

   /**
    * 
    */
   private static final long serialVersionUID = 2191082051394194527L;

   private BLabel            labMessageRPC;

   private BLabel            labMessageInstall;

   private BLabel            labError;

   private BButton           butConnect;

   private PascExplorerCtx   pec;

   public PanelHelperWaitDaemon(PascExplorerCtx pec) {
      super(pec.getPascalSwingCtx());
      this.pec = pec;
      labMessageInstall = new BLabel(sc, "text.daemon.noconnection.install");
      labMessageRPC = new BLabel(sc, "text.daemon.noconnection.rpc");
      labError = new BLabel(sc, "");
      butConnect = new BButton(sc, this, "but.connect");

      this.radd(labMessageInstall);
      this.raddTab(butConnect);
      this.raddBr(labMessageRPC);
      this.raddTab(labError);

   }

   public void actionPerformed(ActionEvent e) {
      Object src = e.getSource();
      if (src == butConnect) {
         cmdConnect();
      }
   }

   private void cmdConnect() {
      labError.setForeground(Color.ORANGE);
      labError.setText("Connecting to daemon...");

      sc.executeLaterInUIThread(new Runnable() {

         public void run() {
            boolean r = pec.cmdDaemonConnection(PanelHelperWaitDaemon.this);
            if (!r) {
               labError.setForeground(Color.RED);
               labError.setText("Failed to connect to daemon.");
            } else {
               pec.getFrames().cmdShowMainWindow();
            }
         }
      });

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "PanelHelperWaitDaemon");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "PanelHelperWaitDaemon");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
