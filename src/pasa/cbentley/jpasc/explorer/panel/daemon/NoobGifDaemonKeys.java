package pasa.cbentley.jpasc.explorer.panel.daemon;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.jpasc.swing.interfaces.IWizardNoob;
import pasa.cbentley.swing.gif.ui.AbstractGifTab;

/**
 * A message with a GIF playing with how to use the daemon
 * @author Charles Bentley
 *
 */
public class NoobGifDaemonKeys extends AbstractGifTab implements IWizardNoob {

   public static final String ID = "noob_daemon_keys";

   private PascalSwingCtx     psc;

   public NoobGifDaemonKeys(PascalSwingCtx psc) {
      super(psc.getGifContext(), ID, "/gifs/create_new_key.gif", "noob.daemon.keys");
      this.psc = psc;

   }

   public void cmdShowNoobWizard(Object caller) {
      psc.showInNewFrameRelToFrameRoot(this);
   }

   public String getID() {
      return ID;
   }

   public String getStringKeyTitle() {
      return "tab." + ID + ".title";
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "NoobGifDaemonKeys");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "NoobGifDaemonKeys");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
