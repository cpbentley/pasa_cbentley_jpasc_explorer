package pasa.cbentley.jpasc.explorer.panel.daemon;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.swing.gif.ui.AbstractGifTab;

/**
 * A message with a GIF playing with how to use the daemon
 * @author Charles Bentley
 *
 */
public class NoobGifDaemon extends AbstractGifTab {

   private PascalSwingCtx psc;

   public NoobGifDaemon(PascalSwingCtx psc) {
      super(psc.getGifContext(), "noob_daemon", "/gifs/rpc_enable.gif", "noob.daemon.rpc");
      this.psc = psc;
   }

   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "NoobGifDaemon");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "NoobGifDaemon");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
