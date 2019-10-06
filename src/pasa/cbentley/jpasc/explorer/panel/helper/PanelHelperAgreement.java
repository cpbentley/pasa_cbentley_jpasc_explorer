package pasa.cbentley.jpasc.explorer.panel.helper;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;
import pasa.cbentley.jpasc.swing.widgets.PanelPascalRiver;
import pasa.cbentley.swing.imytab.FrameReference;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;
import pasa.cbentley.swing.widgets.b.BButton;
import pasa.cbentley.swing.widgets.b.BLabel;

public class PanelHelperAgreement extends PanelPascalRiver implements ActionListener {

   /**
    * 
    */
   private static final long         serialVersionUID = 2191082051394194527L;

   private BLabel                    labAgreement;

   private BLabel                    labError;

   private BButton                   butAgreeYes;

   private PascExplorerCtx           pec;

   private BButton                   butAgreeNo;

   public PanelHelperAgreement(PascExplorerCtx pec) {
      super(pec.getPascalSwingCtx());
      this.pec = pec;

      labAgreement = new BLabel(sc, "text.agreement");
      butAgreeYes = new BButton(sc, this, "but.agree.yes");
      butAgreeNo = new BButton(sc, this, "but.agree.no");

      this.raddBrHfill(labAgreement);
      this.raddBr(butAgreeNo);
      this.raddTab(butAgreeYes);

   }

   public void actionPerformed(ActionEvent e) {
      Object src = e.getSource();
      if (src == butAgreeYes) {
         pec.cmdAgree();
      } else if (src == butAgreeNo) {
         pec.cmdAgreeNo();
         
      }
   }


   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "PanelHelperAgreement");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "PanelHelperAgreement");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
